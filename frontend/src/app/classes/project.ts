import { Skill } from "./skill";
export class Project {
    id:string;
    name:string;
    description:string;
    projectStartDate:Date;
    skills:Skill[] =[];
    constructor(name:string){
        this.name = name;
        this.skills = [];
    }
    
    
}
