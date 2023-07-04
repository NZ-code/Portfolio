import { Component } from '@angular/core';
import { Project } from './project';
@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent {
  title:string = "LATEST PROJECTS";
  projects:Project[] =[];
  constructor(){
    var project1 = new Project("Food Service");
    project1.skills.push("Angular");
    project1.skills.push("Spring");
    this.projects.push(project1);

    var project2 = new Project("90 Films");
    project2.skills.push("HTML");
    project2.skills.push("CSS");
    this.projects.push(project2);

    var project3 = new Project("Bizzare Timer");
    project3.skills.push("Python");
    project3.skills.push("Java");
    this.projects.push(project3);
  }
}
