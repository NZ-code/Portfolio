import { Component } from '@angular/core';
import { Project } from '../../classes/project';
import { Router } from '@angular/router';
import { Colors } from '../../utils/colors';
import { ProjectService } from 'src/app/services/project.service';
import { SkillService } from 'src/app/services/skill.service';
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

    this.projects.push(project1);

    var project2 = new Project("90 Films");
    

    this.projects.push(project2);

    var project3 = new Project("Bizzare Timer");

    this.projects.push(project3);
  }
  ngOnInit():void{
    //this.basicInit();
    this.projectService.getProjects().subscribe(
        response =>
       {this.projects = response
         
      }
       
    );
  };
  getRandomSkillColor(id:number){
    return Colors.getColorById(id);
  }
}
