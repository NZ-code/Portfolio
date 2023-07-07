import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../classes/project';
import { Url } from '../utils/url';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private apiUrl = Url.BASE_URL  + ':8080/api/projects';
  constructor(private http: HttpClient) {
    
   }
  getProjects():Observable<Project[]>{
    return this.http.get<Project[]>(this.apiUrl);
  }
  getProjectById(id:string):Observable<Project>{
    return this.http.get<Project>(this.apiUrl + '/'+id);
  }
}
