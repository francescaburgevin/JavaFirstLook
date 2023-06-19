import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../models/project.model';

@Injectable({
              providedIn: 'root'
            })

export class ProjectService {

  private projectsUrl: string = 'http://localhost:8080/api/v1/project/';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {  }

  public getAllProjects(): Observable<any> {
    return this.http.get(this.projectsUrl);
  }

  public getProjectById(id: number): Observable<any> {
    return this.http.get(`${this.projectsUrl}${id}`);
  }

  public addProject(data: any): Observable<any> {
    return this.http.post(this.projectsUrl, data);
  }

  public deleteProject (id: number): Observable<any> {
    return this.http.delete(`${this.projectsUrl}${id}`);
  }

  public updateProject(id: number, data: Project): Observable<any> {    
    return this.http.put(`${this.projectsUrl}${id}`, data);
  }

  public findByKeyword (keyword: string): Observable<any> {
    return this.http.get(`${this.projectsUrl}keyword/${keyword}`);
  }

  public uploadImage(file: any): Observable<any>
  {
    return this.http.post(`${this.projectsUrl}uploadFile`, file);
  }

  public downloadImage (fileName: String): Observable<any>
  {
    return this.http.get(`${this.projectsUrl}downloadFile/${fileName}`, {responseType: 'text'});
  }
  
}