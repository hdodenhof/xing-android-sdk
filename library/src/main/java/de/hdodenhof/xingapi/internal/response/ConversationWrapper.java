package de.hdodenhof.xingapi.internal.response;

import de.hdodenhof.xingapi.models.Conversation;

public class ConversationWrapper implements ResponseWrapper<Conversation> {

    Conversation conversation;

    @Override
    public Conversation unwrap() {
        return conversation;
    }
}
