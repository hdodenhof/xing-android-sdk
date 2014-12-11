package de.hdodenhof.xingapi;

import java.util.List;

import de.hdodenhof.xingapi.enums.UserField;
import de.hdodenhof.xingapi.internal.communication.ErrorHandler;
import de.hdodenhof.xingapi.internal.communication.XingApiInterface;
import de.hdodenhof.xingapi.internal.util.URLUtils;
import de.hdodenhof.xingapi.models.FindByEmailsResult;
import de.hdodenhof.xingapi.models.IdCard;
import de.hdodenhof.xingapi.models.Results;
import de.hdodenhof.xingapi.models.User;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class UserProfilesAPI extends BaseAPI {

    private XingApiInterface.UserProfiles mAPI;

    protected UserProfilesAPI(RestAdapter restAdapter) {
        mAPI = restAdapter.create(XingApiInterface.UserProfiles.class);
    }

    public User getUser(String id) {
        return getUser(id, null);
    }

    public User getUser(String id, List<UserField> userFields) {
        validateNotEmpty(id, "id");
        try {
            List<User> users = mAPI.getUser(id, URLUtils.toQueryParam(userFields)).unwrap();
            if (users != null && !users.isEmpty()) {
                return users.get(0);
            }
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public User getMe() {
        return getMe(null);
    }

    public User getMe(List<UserField> userFields) {
        try {
            List<User> users = mAPI.getMe(URLUtils.toQueryParam(userFields)).unwrap();
            if (users != null && !users.isEmpty()) {
                return users.get(0);
            }
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public IdCard getIdCard() {
        try {
            return mAPI.getIdCard().unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public Results<FindByEmailsResult> findByEmails(List<String> emails) {
        return findByEmails(emails, null);
    }

    public Results<FindByEmailsResult> findByEmails(List<String> emails, List<UserField> userFields) {
        validateNotEmpty(emails, "emails");

        try {
            return mAPI.findByEmails(URLUtils.toQueryParam(emails), URLUtils.toQueryParam(userFields)).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

}
