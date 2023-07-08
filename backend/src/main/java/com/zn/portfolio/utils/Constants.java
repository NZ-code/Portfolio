package com.zn.portfolio.utils;

public class Constants {
    public static final String API_PROJECTS_URI = "/api/projects";
    public static final String PROJECT_ID_PATH_VAR = "projectId";
    public static final String API_SPECIFIC_PROJECT_URI =API_PROJECTS_URI + "/{"+PROJECT_ID_PATH_VAR+"}"; ;

    public static final String API_SKILLS_URI ="/api/skills";
    public static final String SKILL_ID_PATH_VAR = "skillId";
    public static final String API_SPECIFIC_SKILL_URI = API_SKILLS_URI + "/{"+SKILL_ID_PATH_VAR+"}";
    public static final String FRONTEND_BASE = "http://localhost";
    public static final String CORS = "http://zenevichmikita.pl:4200";
    ;

    public static String generatePathVar(String pathVar){
        return "/{"+pathVar+"}";
    }

}
