package de.hdodenhof.xingapi.models;

import java.util.List;
import java.util.Map;

import de.hdodenhof.xingapi.enums.ActivityObjectType;
import de.hdodenhof.xingapi.enums.Badge;
import de.hdodenhof.xingapi.enums.EmploymentStatus;
import de.hdodenhof.xingapi.enums.IMAccount;
import de.hdodenhof.xingapi.enums.Language;
import de.hdodenhof.xingapi.enums.LanguageSkill;
import de.hdodenhof.xingapi.enums.PremiumService;
import de.hdodenhof.xingapi.enums.WebProfile;

public class User implements ActivityObject {

    private String id;
    private String activeEmail;
    private List<Badge> badges;
    private BirthDate birthDate;
    private Address businessAddress;
    private String displayName;
    private EducationalBackground educationalBackground;
    private EmploymentStatus employmentStatus;
    private String firstName;
    private String gender;
    private String haves;
    private String interests;
    private String organisationMember;
    private Map<Language, LanguageSkill> languages;
    private String lastName;
    private String pageName;
    private String permalink;
    private PhotoUrls photoUrls;
    private List<PremiumService> premiumServices;
    private Address privateAddress;
    private ProfessionalExperience professionalExperience;
    private TimeZone timeZone;
    private String wants;
    private Map<WebProfile, List<String>> webProfiles;
    private Map<IMAccount, String> instantMessagingAccounts;

    public String getId() {
        return id;
    }

    public String getActiveEmail() {
        return activeEmail;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }

    public Address getBusinessAddress() {
        return businessAddress;
    }

    public String getDisplayName() {
        return displayName;
    }

    public EducationalBackground getEducationalBackground() {
        return educationalBackground;
    }

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getHaves() {
        return haves;
    }

    public String getInterests() {
        return interests;
    }

    public String getOrganisationMember() {
        return organisationMember;
    }

    public Map<Language, LanguageSkill> getLanguages() {
        return languages;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPageName() {
        return pageName;
    }

    public String getPermalink() {
        return permalink;
    }

    public PhotoUrls getPhotoUrls() {
        return photoUrls;
    }

    public List<PremiumService> getPremiumServices() {
        return premiumServices;
    }

    public Address getPrivateAddress() {
        return privateAddress;
    }

    public ProfessionalExperience getProfessionalExperience() {
        return professionalExperience;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public String getWants() {
        return wants;
    }

    public Map<WebProfile, List<String>> getWebProfiles() {
        return webProfiles;
    }

    public Map<IMAccount, String> getInstantMessagingAccounts() {
        return instantMessagingAccounts;
    }

    @Override
    public ActivityObjectType getType() {
        return ActivityObjectType.USER;
    }
}
