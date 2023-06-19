import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectService } from 'src/app/service/project-service.service';
import { Project } from '../../../../../models/project.model';

@Component({
  selector: 'app-project-card',
  templateUrl: './project-card.component.html',
  styleUrls: ['./project-card.component.scss']
})
export class ProjectCardComponent implements OnInit {

  @Input() project: Project = new Project(0, "", "", 0, "", "", "") ;

  pathCode: string = this.project.imageFileCode;
  errorMessage: string = "error : project deletion error message";
  submitted: boolean = false;
  imagePath: string = "";

  constructor( 
    private projectService: ProjectService,
    private router: Router
    ) { }

  ngOnInit(): void { 
    this.getProjectImage();
    //this.getImagePath();
  }

  imageURL: string = "";

  public getProjectImage(): void {
    this.projectService.getProjectById(this.project.id)
    .subscribe({
      next: (data) => {
        this.project=data;
      },
      error: (errorMessage) => console.error(errorMessage)
    });
  }

  /*
  public getImagePath(): void {
    this.projectService.downloadImage(this.project.imageFileCode)
    .subscribe({
      next: (data) => {
        console.log(data);
      },
      error: (errorMessage) => console.error(errorMessage)
    });
  }
*/

confirmDelete: boolean = false;

deleteConfirm(id: number){
  this.confirmDelete = true;
  if(window.confirm('Are sure you want to delete this item ?')){
    //put your delete method logic here

   }
}


  deleteProject(id: number){
    this.projectService.deleteProject(id)
    .subscribe({
      next: (res) => {
        this.submitted = true;
        location.reload();
      },
      error: (errorMessage) => 
      {
        console.error(errorMessage);
        this.submitted=false;
      }
    });
  }


  updateProject(id: number) {
    this.router.navigate(['edit/'+id]);
  }

  viewProject(id: number) {
    this.router.navigate(['projects/'+id]);
  }

}
