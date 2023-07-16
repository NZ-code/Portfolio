import { Skill } from "./skill";
export class Project {
    id:string;
    name:string;
    description:string;
    projectStartDate:Date;
    skills:Skill[] =[];
    githubLink:string;
    constructor(name:string){
        this.name = name;
        this.skills = [];
    }

}
export class ProjectBuilder{
    private id:string;
    private name:string;
    private description:string;
    private projectStartDate:Date;
    private skills:Skill[] =[];
    private githubLink:string;
    
    setId(id:string):ProjectBuilder{
        this.id = id;
        return this;
    }
    setName(name:string):ProjectBuilder{
        this.name = name;
        return this;
    }
    setDescription(description:string):ProjectBuilder{
        this.description = description;
        return this;
    }
    setProjectStartDate(projectStartDate:Date):ProjectBuilder{
        this.projectStartDate = projectStartDate;
        return this;
    }
    setSkills(skills:Skill[]):ProjectBuilder{
        this.skills = skills;
        return this;
    }
    setGithubLink(githubLink:string){
        this.githubLink = githubLink;
        return this;
    }
    build():Project{
        let project = new Project(this.name);
        project.description = this.description;
        project.githubLink = this.githubLink;
        project.id = this.id;
        project.projectStartDate = this.projectStartDate;
        project.skills = this.skills;
        return project;
    }
    
} 
