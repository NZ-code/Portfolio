import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Project , ProjectBuilder} from '../classes/project';
import { Url } from '../utils/url';
import { Skill } from '../classes/skill';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  projects : Project[] = [];

  private apiUrl = Url.BASE_URL  + ':8080/api/projects';
  constructor(private http: HttpClient) {
    // project 1;
    const project1= new ProjectBuilder()
    .setId("1")
    .setName("This Page")
    .setDescription("Portfolio Website")
    .setGithubLink("https://github.com/NZ-code/Portfolio")
    .setSkills([
      new Skill("Angular"," "),
      new Skill("Typescript"," ")
    ])
    .setProjectStartDate(new Date(2023, 6, 16))
    .build();
  
    const project2= new ProjectBuilder()
    .setId("2")
    .setName("ToDo App")
    .setDescription("Spring Web To Do App")
    .setGithubLink("https://github.com/NZ-code/ToDo")
    .setSkills([
      new Skill("Angular"," "),
      new Skill("Typescript"," "),
      new Skill("Java"," "),
      new Skill("Spring", " ")
    ])
    .setProjectStartDate(new Date(2023, 5, 7))
    .build();

    const project3= new ProjectBuilder()
    .setId("3")
    .setName("Ryanair Scraper")
    .setDescription("I reverse-engineered Ryanair API so it works without limitations.")
    .setGithubLink("https://github.com/NZ-code/ryanApiScrapper")
    .setSkills([
      new Skill("Python"," "),
      new Skill("Dijkstra", " ")
    ])
    .setProjectStartDate(new Date(2023, 3, 21))
    .build();
    this.projects.push(project1);
  
    this.projects.push(project2);
    this.projects.push(project3);
  }
  getUrlId(id:string){
    return this.apiUrl + '/'+id;
  }
  getProjects():Observable<Project[]>{
    return of(this.projects);
    //return this.http.get<Project[]>(this.apiUrl);
  }
  getProjectById(id:string):Observable<Project>{
    const index = this.projects.findIndex((p)=> p.id === id);
    return of(this.projects[index]!);
    //return this.http.get<Project>(this.getUrlId(id));
  }
  save(project:Project){
    this.projects.push(project)
    return of(undefined);
    //return this.http.post<Project>(this.apiUrl, project);
  }
  delete(id:string){
    this.projects.filter((p)=> p.id !== id);
    return of(undefined);
    //return this.http.delete<Project>(this.getUrlId(id));
  }
  update(id:string, project:Project){
    const index = this.projects.findIndex((p)=> p.id === id);
    this.projects[index] = project;
    return of(undefined);
    //return this.http.put<Project>(this.getUrlId(id), project);
  }
}
