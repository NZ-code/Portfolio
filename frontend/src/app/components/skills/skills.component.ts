import { Component } from '@angular/core';
import { Skill } from 'src/app/classes/skill';


@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent {
  header: string = "Skills";
  
  skills:Skill[] =[]; 
  
  ngOnInit(){
    this.skills = [
      new Skill("Spring Boot",""),
      new Skill("Angular", ""),
      new Skill("Python",""),
      new Skill("English C1", ""),
      new Skill("Polish C1", ""),
      new Skill("Problem Solving", ""),
    ]
  }
  //= ['Spring', 'Angular', 'Python', 'English C1', 'Polish C1', 'Problem Solving'];
  

}
