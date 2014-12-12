package de.hdodenhof.xingapi;

import java.util.Date;
import java.util.List;

import de.hdodenhof.xingapi.enums.UserField;
import de.hdodenhof.xingapi.internal.communication.ErrorHandler;
import de.hdodenhof.xingapi.internal.communication.XingApiInterface;
import de.hdodenhof.xingapi.models.Comment;
import de.hdodenhof.xingapi.models.NetworkActivity;
import de.hdodenhof.xingapi.models.User;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class NetworkFeedAPI extends BaseAPI {

    private final XingApiInterface.NetworkFeed mAPI;

    protected NetworkFeedAPI(RestAdapter restAdapter) {
        mAPI = restAdapter.create(XingApiInterface.NetworkFeed.class);
    }

    public List<NetworkActivity> getNetworkFeed(String userId, Boolean aggregate, Date since, Date until, List<UserField> userFields) {
        validateNotEmpty(userId, "userId");

        String userFieldsFlat = null;
        if (!userFields.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (UserField userField : userFields) {
                sb.append(userField.toString());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            userFieldsFlat = sb.toString();
        }

        try {
            return mAPI.getNetworkFeed(userId, aggregate, since, until, userFieldsFlat).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public List<NetworkActivity> getUserFeed(String userId) {
        validateNotEmpty(userId, "userId");

        try {
            return mAPI.getUserFeed(userId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public void postStatusMessage(String userId, String message) {
        validateNotEmpty(userId, "userId");
        validateNotEmpty(message, "message");

        try {
            mAPI.postStatusMessage(userId, message);
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
    }

    public NetworkActivity getActivity(String activityId) {
        validateNotEmpty(activityId, "activityId");

        try {
            List<NetworkActivity> activities = mAPI.getActivity(activityId).unwrap();
            if (activities != null && !activities.isEmpty()) {
                return activities.get(0);
            }
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public NetworkActivity shareActivity(String activityId, String message) {
        validateNotEmpty(activityId, "activityId");

        try {
            List<NetworkActivity> activities = mAPI.shareActivity(activityId, message).unwrap();
            if (activities != null && !activities.isEmpty()) {
                return activities.get(0);
            }
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public void deleteAcitivty(String activityId) {
        validateNotEmpty(activityId, "activityId");

        try {
            mAPI.deleteActivity(activityId);
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
    }

    public List<Comment> getComments(String activityId) {
        validateNotEmpty(activityId, "activityId");

        try {
            return mAPI.getComments(activityId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public List<Comment> postComment(String activityId, String message) {
        validateNotEmpty(activityId, "activityId");
        validateNotEmpty(message, "message");

        try {
            return mAPI.postComment(activityId, message).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public void deleteComment(String activityId, String commentId) {
        validateNotEmpty(activityId, "activityId");
        validateNotEmpty(commentId, "commentId");

        try {
            mAPI.deleteComment(activityId, commentId);
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
    }

    public List<User> getLikes(String activityId) {
        validateNotEmpty(activityId, "activityId");

        try {
            return mAPI.getLikes(activityId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public void like(String activityId) {
        validateNotEmpty(activityId, "activityId");

        try {
            mAPI.like(activityId);
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
    }

    public void unlike(String activityId) {
        validateNotEmpty(activityId, "activityId");

        try {
            mAPI.unlike(activityId);
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
    }

}
