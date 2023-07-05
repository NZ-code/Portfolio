import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CoverComponent } from './components/cover/cover.component';
import { HeaderComponent } from './components/header/header.component';

import { MatButtonModule } from '@angular/material/button';
import { AboutComponent } from './components/about/about.component';
import { SkillsComponent } from './components/skills/skills.component';
import { FooterComponent } from './components/footer/footer.component';
import { ProjectsComponent } from './components/projects/projects.component';
import { ProjectDetailsComponent } from './components/project-details/project-details.component';
import { MainPageComponent } from './components/main-page/main-page.component';
import { ProjectDetailsHeaderComponent } from './components/project-details/project-details-header/project-details-header.component';

@NgModule({
  declarations: [
    AppComponent,
    CoverComponent,
    HeaderComponent,
    AboutComponent,
    SkillsComponent,
    FooterComponent,
    ProjectsComponent,
    ProjectDetailsComponent,
    MainPageComponent,
    ProjectDetailsHeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
