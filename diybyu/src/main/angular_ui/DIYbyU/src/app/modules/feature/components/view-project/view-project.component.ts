import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from 'src/app/models/project.model';
import { ProjectService} from 'src/app/service/project-service.service';

@Component({
  selector: 'app-view-project',
  templateUrl: './view-project.component.html',
  styleUrls: ['./view-project.component.scss']
})
export class ViewProjectComponent implements OnInit {
  
  id: number = 0;
  errorMessage: string ="error : getbyid";
  project: Project = new Project(0, "", "", 0, "", "", "") ;

  constructor(
    private projectService: ProjectService,
    private route: ActivatedRoute,
    private router: Router
  ) {   }

  ngOnInit() {
    var urlNumberString = this.route.snapshot.paramMap.get('id');
    if (urlNumberString) {
      this.id=parseInt(urlNumberString);
      this.getProject();
    } else { this.router.navigate(['/'])}
}



  public getProject(): void {

    this.projectService.getProjectById(this.id)
    .subscribe({
      next: (data) => {
        this.project=data;
      },
      error: (errorMessage) => console.error(errorMessage)
    });
  }

}
