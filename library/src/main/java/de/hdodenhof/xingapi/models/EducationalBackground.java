package de.hdodenhof.xingapi.models;

import java.util.List;

public class EducationalBackground {

    private String degree;
    private School primarySchool;
    private List<School> schools;
    private List<String> qualifications;

    public String getDegree() {
        return degree;
    }

    public School getPrimarySchool() {
        return primarySchool;
    }

    public List<School> getSchools() {
        return schools;
    }

    public List<String> getQualifications() {
        return qualifications;
    }
}
