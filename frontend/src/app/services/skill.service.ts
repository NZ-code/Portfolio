import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Skill } from '../classes/skill';
import { Url } from '../utils/url';
@Injectable({
  providedIn: 'root'
})
export class SkillService {
  private apiUrl = Url.BASE_URL+ ':8080/api/projects';
  constructor(private http: HttpClient) {
  }
  getSkillsByProjectId(projectId :string):Observable<Skill[]>{
    return this.http.get<Skill[]>(this.apiUrl + '/' + projectId+'/skills');
  }
  
}
