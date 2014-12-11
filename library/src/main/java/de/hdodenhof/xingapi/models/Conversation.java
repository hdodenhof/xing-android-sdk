package de.hdodenhof.xingapi.models;

public class Conversation {

    private String id;
    private String subject;
    private Integer messageCount;
    private Integer unreadMessageCount;

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getMessageCount() {
        return messageCount;
    }

    public Integer getUnreadMessageCount() {
        return unreadMessageCount;
    }
}
