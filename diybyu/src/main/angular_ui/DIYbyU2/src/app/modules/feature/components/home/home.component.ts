import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectService } from 'src/app/service/project-service.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  projectList: any = [];
  

  constructor(
    private router: Router,
    private projectService: ProjectService) { }

  ngOnInit(): void {
  }

  AddProject() {
      this.router.navigate(['add']);
    }

 
}
