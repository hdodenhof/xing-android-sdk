package de.hdodenhof.xingapi;

import de.hdodenhof.xingapi.internal.communication.ErrorHandler;
import de.hdodenhof.xingapi.internal.communication.XingApiInterface;
import de.hdodenhof.xingapi.models.Contacts;
import de.hdodenhof.xingapi.models.Tags;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class ContactsAPI extends BaseAPI {

    private final XingApiInterface.Contacts mAPI;

    protected ContactsAPI(RestAdapter restAdapter) {
        mAPI = restAdapter.create(XingApiInterface.Contacts.class);
    }

    public Contacts getContacts(String userId) {
        validateNotEmpty(userId, "userId");

        try {
            return mAPI.getContacts(userId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public Tags getContactTags(String userId, String contactId) {
        validateNotEmpty(userId, "userId");
        validateNotEmpty(contactId, "contactId");

        try {
            return mAPI.getContactTags(userId, contactId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public Contacts getSharedContacts(String userId) {
        validateNotEmpty(userId, "userId");

        try {
            return mAPI.getSharedContacts(userId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

}
