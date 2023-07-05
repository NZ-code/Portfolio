import { Component } from '@angular/core';

@Component({
  selector: 'app-project-details-header',
  templateUrl: './project-details-header.component.html',
  styleUrls: ['./project-details-header.component.css']
})
export class ProjectDetailsHeaderComponent {
  skills:string[] = ["spring", "java","angular"]
}
