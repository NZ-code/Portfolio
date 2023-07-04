import { Component } from '@angular/core';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent {
  header: string = "Skills";
  
  skills = ['Spring', 'Angular', 'Python', 'English C1', 'Polish C1', 'Problem Solving'];
}
