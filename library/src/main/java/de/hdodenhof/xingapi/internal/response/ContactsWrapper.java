package de.hdodenhof.xingapi.internal.response;

import de.hdodenhof.xingapi.models.Contacts;

public class ContactsWrapper implements ResponseWrapper<Contacts> {

    Contacts contacts;

    @Override
    public Contacts unwrap() {
        return contacts;
    }
}
