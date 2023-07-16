import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SkillsComponent } from './components/skills/skills.component';
import { ProjectDetailsComponent } from './components/project-details/project-details.component';
import { MainPageComponent } from './components/main-page/main-page.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';

const routes: Routes = [
  {path:'', component:MainPageComponent},
  {path:'project/:projectId', component: ProjectDetailsComponent, pathMatch: 'full'},
  //{path:'admin', component:AdminPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
