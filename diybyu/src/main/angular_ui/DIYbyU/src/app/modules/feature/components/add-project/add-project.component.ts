import { Component } from '@angular/core';
import { ProjectService } from 'src/app/service/project-service.service';
import { NgForm } from '@angular/forms';
import { Project } from 'src/app/models/project.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrls: ['./add-project.component.scss']
})
export class AddProjectComponent {

  project: Project = {
    id: 0,
    dateAdded: new Date().toString(),
    name: '',
    timeNeeded: 0,
    material: '',
    description: '',
    imageFileCode: ''
  };
  private submitted: boolean = false;
  public formData = new FormData();
  public fileName: string = "";

  constructor(
    private projectService: ProjectService,
    private router: Router) { }

  ngOnInit(){}

  saveProject(form: NgForm): void {
    
    let date = new Date();
    const data = {
      name: this.project.name,
      dateAdded: date,
      timeNeeded: this.project.timeNeeded,
      material: this.project.material,
      description: this.project.description,
      imageFileCode: this.project.imageFileCode
    };
    
    this.projectService.addProject(data)
      .subscribe({
        next: (res) => {
          this.submitted = true;
          this.router.navigate(['projects']);
        },
        error: (e) => console.error(e)
      });
  }

  cancel() {
    this.router.navigate(['projects']);
  }

  uploadedImage(newImage: File) {
    this.fileName = newImage.name;
    if(newImage) {
      this.formData.append("file", newImage);

      this.projectService.uploadImage(this.formData).subscribe({
        next: (res) => {
          this.submitted = true;
          this.project.imageFileCode = res.downloadUri;
        },
        error: (e) => console.error("image not uploaded")
      });

    }
  }

}