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

  @Input() project: any ;
  //projects: any = [];
  errorMessage: string = "error : project deletion error message";
  submitted: boolean = false;

  constructor( 
    private projectService: ProjectService,
    private router: Router
    ) { }

  ngOnInit(): void { }
    
  deleteProject(id: number){
    this.projectService.deleteProject(id)
    .subscribe({
      next: (res) => {
        console.log(res);
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
