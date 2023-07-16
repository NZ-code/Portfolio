import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Project } from 'src/app/classes/project';
import { ProjectService } from 'src/app/services/project.service';
import { Colors } from 'src/app/utils/colors';

@Component({
  selector: 'app-project-details-header',
  templateUrl: './project-details-header.component.html',
  styleUrls: ['./project-details-header.component.css']
})
export class ProjectDetailsHeaderComponent {
  skills:string[] = ["spring", "java","angular"]
  project:Project;
  projectId:string;
  constructor(private projectService:ProjectService,private route: ActivatedRoute){
    
  }
  ngOnInit(){
    this.route.params.subscribe(params => {
      this.projectId = params['projectId'];
      
      this.projectService.getProjectById(this.projectId).subscribe(
        data=>{
          
          this.project = data;
        }
      );
    });
  }
  getRandomSkillColor(id:number){
    return Colors.getColorById(id);
  }
}
