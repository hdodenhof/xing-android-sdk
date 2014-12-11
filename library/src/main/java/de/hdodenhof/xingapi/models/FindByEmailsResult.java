package de.hdodenhof.xingapi.models;

public class FindByEmailsResult {

    private String hash;
    private String email;
    private User user;

    public String getHash() {
        return hash;
    }

    public String getEmail() {
        return email;
    }

    public User getUser() {
        return user;
    }
}
