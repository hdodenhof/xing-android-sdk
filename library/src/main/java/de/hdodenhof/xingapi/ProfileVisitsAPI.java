package de.hdodenhof.xingapi;

import java.util.List;

import de.hdodenhof.xingapi.internal.communication.ErrorHandler;
import de.hdodenhof.xingapi.internal.communication.XingApiInterface;
import de.hdodenhof.xingapi.models.Visit;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class ProfileVisitsAPI extends BaseAPI {

    private XingApiInterface.ProfileVisits mAPI;

    protected ProfileVisitsAPI(RestAdapter restAdapter) {
        mAPI = restAdapter.create(XingApiInterface.ProfileVisits.class);
    }

    public List<Visit> getVisits(String userId) {
        validateNotEmpty(userId, "userId");

        try {
            return mAPI.getVisits(userId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public List<Visit> postVisit(String userId) {
        validateNotEmpty(userId, "userId");

        try {
            return mAPI.postVisit(userId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

}
