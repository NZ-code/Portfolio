import { Component } from '@angular/core';
import { Project } from '../../classes/project';
import { Router } from '@angular/router';
import { Colors } from '../utils/colors';
import { ProjectService } from 'src/app/services/project.service';
@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent {
  title:string = "LATEST PROJECTS";
  projects:Project[] =[];
  constructor(private projectService:ProjectService){

  }
  basicInit():void{

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
  ngOnInit():void{
    this.projectService.getProjects().subscribe(
      response =>
      {this.projects = response}
    )
  };
  getRandomSkillColor(){
    return Colors.getRandomColor();
  }
}
