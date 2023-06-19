import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from 'src/app/models/project.model';
import { ProjectService } from 'src/app/service/project-service.service';
import { saveAs } from 'file-saver';


@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.scss']
})
export class EditProjectComponent implements OnInit {

  id: number = 0;
  project: Project = {
    id: 0,
    dateAdded: "",
    name: '',
    timeNeeded: 0,
    material: '',
    description: '',
    imageFileCode: ''
  };
  submitted: boolean = false;
  data: any; 
  public formData = new FormData();
  public fileName: string = "";


  constructor(
    private projectService: ProjectService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    var urlNumberString = this.route.snapshot.paramMap.get('id');
    if (urlNumberString) {
      this.id=parseInt(urlNumberString);
      this.projectService.getProjectById(this.id).subscribe({
        next: (response) => {
          console.log(response);
          this.project = response;
          this.submitted = true;
        },
        error: (errorMessage) => 
        {
          console.error(errorMessage);
          this.submitted=false;
        }
      });
    } else { this.router.navigate(['projects'])};
    
    this.projectService.uploadImage(this.project.imageFileCode)
    .subscribe({
      next: (response) => {
        console.log(response);
        this.submitted = true;
      },
      error: (errorMessage) => 
      {
        console.error(errorMessage);
        this.submitted=false;
      }
    });
    
  }

  updateProjectForm(form: NgForm): void {
    this.data = {
      id: this.project.id,
      dateAdded: "",
      name: this.project.name,
      timeNeeded: this.project.timeNeeded,
      material: this.project.material,
      description: this.project.description,
      imageFileCode: this.project.imageFileCode
    };
    this.updateProject(this.project.id, this.data);
  }

  
  updateProject(id: number, data: any){
    this.projectService.updateProject(id, data)
    .subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
        this.router.navigate(['projects']);
      },
      error: (errorMessage) => 
      {
        console.error(errorMessage);
        this.submitted=false;
      }
    });
  }

  uploadedImage(newImage: File) {
    this.fileName = newImage.name;
    if(newImage) {
      this.formData.append("file", newImage);

      this.projectService.uploadImage(this.formData).subscribe({
        next: (res) => {
          this.submitted = true;
          this.project.imageFileCode = res.downloadUri;
          console.log("new uri : "+this.project.imageFileCode);
        },
        error: (e) => console.error("image not uploaded")
      });

    }
  }

  cancel() {
    this.router.navigate(['projects']);
  }
  

}
