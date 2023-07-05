import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectDetailsHeaderComponent } from './project-details-header.component';

describe('ProjectDetailsHeaderComponent', () => {
  let component: ProjectDetailsHeaderComponent;
  let fixture: ComponentFixture<ProjectDetailsHeaderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProjectDetailsHeaderComponent]
    });
    fixture = TestBed.createComponent(ProjectDetailsHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
