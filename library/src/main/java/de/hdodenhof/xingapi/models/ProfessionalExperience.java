package de.hdodenhof.xingapi.models;

import java.util.List;

public class ProfessionalExperience {

    private Company primaryCompany;
    private List<Company> companies;
    private List<Award> awards;

    public Company getPrimaryCompany() {
        return primaryCompany;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public List<Award> getAwards() {
        return awards;
    }
}
