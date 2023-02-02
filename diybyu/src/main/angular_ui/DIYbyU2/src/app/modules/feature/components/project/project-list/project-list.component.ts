import { Component, Input, OnInit } from '@angular/core';
import { Project } from 'src/app/models/project.model';
import { ProjectService} from 'src/app/service/project-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.scss']
})
export class ProjectListComponent implements OnInit {

projects: Project[] = [];
loading: boolean = false;
errorMessage: string = "error: function did not work";

keyword: string = "";

  constructor(
    private projectService: ProjectService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.getProjects();
  }

  public getProjects(): void {
    this.projectService.getAllProjects()
    .subscribe({
      next: (data) => {
        this.projects=data;
        console.log(data);
      },
      error: (errorMessage) => console.error(errorMessage)
    });
  }

  newKeyword(newWord: string) {
    this.keyword = newWord ;
    this.projectService.findByKeyword(this.keyword).subscribe({
      next: (data) => {
        console.log(data);
        this.projects = data;
      },
      error: (errorMessage) => console.error(errorMessage)
    });

  }
    
}
