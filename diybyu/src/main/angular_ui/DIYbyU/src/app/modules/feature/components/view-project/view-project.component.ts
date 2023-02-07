import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectService} from 'src/app/service/project-service.service';

@Component({
  selector: 'app-view-project',
  templateUrl: './view-project.component.html',
  styleUrls: ['./view-project.component.scss']
})
export class ViewProjectComponent implements OnInit {
  
  id: number = 0;
  errorMessage: string ="error : getbyid";
  project: any;

  constructor(
    private projectService: ProjectService,
    private route: ActivatedRoute,
    private router: Router
  ) {   }

  ngOnInit() {
    var urlNumberString = this.route.snapshot.paramMap.get('id');
    if (urlNumberString) {
      this.id=parseInt(urlNumberString);
      this.getProjectById(this.id);
    } else { this.router.navigate(['/'])}
}


  public getProjectById(id: number): void {
    console.log("getProjectById launched");
    console.log("project number : "+id);

    this.projectService.getProjectById(id).subscribe(
      data => {
        this.project = data;
        console.log(data);
      },
      error => {
        console.log(this.errorMessage);
      }
    );
  }

}
