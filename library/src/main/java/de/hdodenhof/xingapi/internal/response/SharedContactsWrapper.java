package de.hdodenhof.xingapi.internal.response;

import de.hdodenhof.xingapi.models.Contacts;

public class SharedContactsWrapper implements ResponseWrapper<Contacts> {

    Contacts sharedContacts;

    @Override
    public Contacts unwrap() {
        return sharedContacts;
    }
}
