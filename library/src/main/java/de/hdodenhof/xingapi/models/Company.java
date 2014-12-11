package de.hdodenhof.xingapi.models;

import de.hdodenhof.xingapi.enums.CarrerLevel;
import de.hdodenhof.xingapi.enums.CompanyIndustry;
import de.hdodenhof.xingapi.enums.CompanySize;
import de.hdodenhof.xingapi.enums.FormOfEmployment;

public class Company {

    private String id;
    private String name;
    private String url;
    private String tag;
    private String title;
    private String beginDate;
    private String endDate;
    private String description;
    private Boolean untilNow;
    private CompanyIndustry industry;
    private CompanySize companySize;
    private CarrerLevel carrerLevel;
    private FormOfEmployment formOfEmployment;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getTag() {
        return tag;
    }

    public String getTitle() {
        return title;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getUntilNow() {
        return untilNow;
    }

    public CompanyIndustry getIndustry() {
        return industry;
    }

    public CompanySize getCompanySize() {
        return companySize;
    }

    public CarrerLevel getCarrerLevel() {
        return carrerLevel;
    }

    public FormOfEmployment getFormOfEmployment() {
        return formOfEmployment;
    }
}
