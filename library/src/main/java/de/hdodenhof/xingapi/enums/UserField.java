package de.hdodenhof.xingapi.enums;

public enum UserField {

    ID,
    ACTIVE_EMAIL,
    BADGES,
    BIRTH_DATE,
    BUSINESS_ADDRESS,
    DISPLAY_NAME,
    EDUCATIONAL_BACKGROUND,
    EMPLOYMENT_STATUS,
    FIRST_NAME,
    GENDER,
    HAVES,
    INTERESTS,
    ORGANISATION_MEMBER,
    LANGUAGES,
    LAST_NAME,
    PAGE_NAME,
    PERMALINK,
    PHOTO_URLS,
    PREMIUM_SERVICES,
    PRIVATE_ADDRESS,
    PROFESSIONAL_EXPERIENCE,
    TIME_ZONE,
    WANTS,
    WEB_PROFILES,
    INSTANT_MESSAGING_ACCOUNTS;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
