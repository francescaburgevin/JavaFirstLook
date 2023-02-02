import { Component, OnInit } from '@angular/core';
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
    dateAdded: 0,
    name: '',
    timeNeeded: 0,
    material: '',
    description: '',
    thumbnail: ''
  };
  submitted = false;

  constructor(
    private projectService: ProjectService,
    private router: Router) { }

  saveProject(form: NgForm): void {
    const data = {
      dateAdded: 2222,
      name: this.project.name,
      timeNeeded: this.project.timeNeeded,
      material: this.project.material,
      description: this.project.description,
      thumbnail: this.project.thumbnail
    };

    this.projectService.addProject(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
          this.router.navigate(['projects']);
        },
        error: (e) => console.error(e)
      });
  }

  newProject(): void {
    this.submitted = false;
    this.project = {
      id: 0,
      dateAdded: 0,
      name: '',
      timeNeeded: 0,
      material: '',
      description: '',
      thumbnail: ''
    };
  }

  cancel() {
    this.router.navigate(['projects']);
  }
  
}
