package de.hdodenhof.xingapi.internal.response;

import de.hdodenhof.xingapi.models.Conversations;

public class ConversationsWrapper implements ResponseWrapper<Conversations> {

    Conversations conversations;

    @Override
    public Conversations unwrap() {
        return conversations;
    }
}
