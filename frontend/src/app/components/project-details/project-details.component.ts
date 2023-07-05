import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css']
})
export class ProjectDetailsComponent {
  projectId : string
  constructor(private route :ActivatedRoute){

  }
  ngOnInit(){
    this.route.params.subscribe((params) => {
      this.projectId = params['projectId'];
    });
  }
}
