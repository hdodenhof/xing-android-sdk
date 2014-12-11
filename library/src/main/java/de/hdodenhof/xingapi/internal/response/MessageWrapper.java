package de.hdodenhof.xingapi.internal.response;

import de.hdodenhof.xingapi.models.Message;

public class MessageWrapper implements ResponseWrapper<Message> {

    Message message;

    @Override
    public Message unwrap() {
        return message;
    }
}
