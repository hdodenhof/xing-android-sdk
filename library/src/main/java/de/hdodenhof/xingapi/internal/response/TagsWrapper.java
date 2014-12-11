package de.hdodenhof.xingapi.internal.response;

import de.hdodenhof.xingapi.models.Tags;

public class TagsWrapper implements ResponseWrapper<Tags> {

    Tags tags;

    @Override
    public Tags unwrap() {
        return tags;
    }
}
