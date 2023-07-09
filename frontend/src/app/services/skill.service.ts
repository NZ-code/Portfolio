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
  getProjectSkillsPath(projectId :string){
    return this.apiUrl + '/' + projectId+'/skills';
  }
  getSpecificSkillPat(projectId:string, skillId:String){
    this.getProjectSkillsPath(projectId)+'/'+skillId;
  }
  getSkillsByProjectId(projectId :string):Observable<Skill[]>{
    return this.http.get<Skill[]>(this.getProjectSkillsPath(projectId));
  }

  deleteSkillByProject(projectId: string, skillId: string) {
    
    return this.http.delete<Skill>(this.getProjectSkillsPath(projectId)+'/'+skillId);
    
  }
  putSkillByProject(skill: Skill, projectId: string, skillId: string) {
    console.log("PUT WAS SENT TO" + this.getProjectSkillsPath(projectId)+'/'+skillId);
    console.log("SKILL:" + skill)
    return this.http.put<Skill>(this.getProjectSkillsPath(projectId)+'/'+skillId, skill);
  }
  postSkillByProject(skill:Skill,projectId: string) {
    return this.http.post<Skill>(this.getProjectSkillsPath(projectId), skill);
  }
}
