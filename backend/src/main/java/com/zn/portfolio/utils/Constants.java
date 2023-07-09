package com.zn.portfolio.utils;

public class Constants {
    public static final String API_PROJECTS_URI = "/api/projects";
    public static final String PROJECT_ID_PATH_VAR = "projectId";
    public static final String API_SPECIFIC_PROJECT_URI =API_PROJECTS_URI + "/{"+PROJECT_ID_PATH_VAR+"}"; ;
    public static final String SKILL_ID_PATH_VAR = "skillId";
    public static final String API_SPECIFIC_PROJECT_SKILLS_URI = API_SPECIFIC_PROJECT_URI  + "/skills";
    public static final String API_SPECIFIC_PROJECT_SPECIFIC_SKILL_URI = API_SPECIFIC_PROJECT_SKILLS_URI+ "/{"+SKILL_ID_PATH_VAR+"}";



    public static final String API_SKILLS_URI ="/api/skills";

    public static final String API_SPECIFIC_SKILL_URI = API_SKILLS_URI + "/{"+SKILL_ID_PATH_VAR+"}";

    public static final String CORS = "*";


    public static String generatePathVar(String pathVar){
        return "/{"+pathVar+"}";
    }

    public static final String DATA_SOURCE_DRIVER = "com.mysql.cj.jdbc.Driver";
    //global:
    public static final String DATA_SOURCE_URL = "jdbc:mysql://database:3306/mydatabase";
    // local:
    //public static final String DATA_SOURCE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    public static final String DATA_SOURCE_USER = "myuser";
    public static final String DATA_SOURCE_PASSWORD = "mypassword";

}
