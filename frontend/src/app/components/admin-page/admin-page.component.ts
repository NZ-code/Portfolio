import { Component } from '@angular/core';
import { ProjectService } from '../../services/project.service';
import { Project } from '../../classes/project';
import {  FormBuilder, FormGroup } from '@angular/forms';
import { from } from 'rxjs';
import { SkillService } from '../../services/skill.service';
import { Skill } from '../../classes/skill';


@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent {



  projects:Project[] = [];
  newSkill:Skill;
  newProjectForm:FormGroup;
  constructor(private projectService:ProjectService, private skillService:SkillService, 
    private fb:FormBuilder){
    this.newProjectForm = this.fb.group(
      {
        projectName:"",
        projectDescription:"",
        projectStartDate:""
      }
    )
  }
  ngOnInit(){
    this.refreshPageContent();
    
  }
  refreshPageContent(){
    this.projectService.getProjects().subscribe(
      (data)=> this.projects = data
    );
    this.newSkill = new Skill("","");
  }
  onNewProjectSubmit(){
    let projectName = this.newProjectForm.get('projectName')?.value;
    let project = new Project(projectName);
    project.projectStartDate = this.newProjectForm.get('projectStartDate')?.value;
    project.description = this.newProjectForm.get('projectDescription')?.value;

    this.newProjectForm.reset();

    this.projectService.save(project).subscribe(
      _ => this.refreshPageContent()
    )
  }
  onDeleteProject(projectId:string){
    this.projectService.delete(projectId).subscribe(
      _ => this.refreshPageContent()
    )
  }

  updateProject(project:Project){
    this.projectService.update(project.id, project).subscribe(
      _ => this.refreshPageContent()
    )
  }
  onDeleteSkillByProject(projectId:string, skillId:string){
    this.skillService.deleteSkillByProject(projectId, skillId).subscribe(
      _=>this.refreshPageContent()
    );
  }
  addSkillToProject(project: Project) {
    this.skillService.postSkillByProject(this.newSkill, project.id).subscribe(
      _=>this.refreshPageContent()
    )
  }
  onUpdateSkillByProject(skill: Skill, projectId: string, skillId: string) {
    this.skillService.putSkillByProject(skill, projectId, skillId).subscribe(
      _=>this.refreshPageContent()
    )
  }



}
