package de.hdodenhof.xingapi.internal.response;

import de.hdodenhof.xingapi.models.Messages;

public class MessagesWrapper implements ResponseWrapper<Messages> {

    Messages messages;

    @Override
    public Messages unwrap() {
        return messages;
    }
}
