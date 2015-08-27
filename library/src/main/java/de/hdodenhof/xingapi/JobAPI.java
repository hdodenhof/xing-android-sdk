package de.hdodenhof.xingapi;

import java.util.List;

import de.hdodenhof.xingapi.enums.UserField;
import de.hdodenhof.xingapi.internal.communication.ErrorHandler;
import de.hdodenhof.xingapi.internal.communication.XingApiInterface;
import de.hdodenhof.xingapi.internal.util.URLUtils;
import de.hdodenhof.xingapi.models.Job;
import de.hdodenhof.xingapi.models.Results;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by alfdev on 12/08/15.
 */
public class JobAPI extends BaseAPI {
    private XingApiInterface.Jobs mAPI;

    protected JobAPI(RestAdapter restAdapter) {
        mAPI = restAdapter.create(XingApiInterface.Jobs.class);
    }

    public Results<Job> find(String query, int limit, String location, List<UserField> userFields) {
        validateNotEmpty(query, "query");

        try {
            return mAPI.find(query, limit, location, URLUtils.toQueryParam(userFields)).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
