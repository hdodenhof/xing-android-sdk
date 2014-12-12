package de.hdodenhof.xingapi.internal.communication;

import java.util.Date;

import de.hdodenhof.xingapi.internal.response.ActivityWrapper;
import de.hdodenhof.xingapi.internal.response.CommentsWrapper;
import de.hdodenhof.xingapi.internal.response.ContactsWrapper;
import de.hdodenhof.xingapi.internal.response.ConversationWrapper;
import de.hdodenhof.xingapi.internal.response.ConversationsWrapper;
import de.hdodenhof.xingapi.internal.response.IdCardWrapper;
import de.hdodenhof.xingapi.internal.response.LikesWrapper;
import de.hdodenhof.xingapi.internal.response.MessageWrapper;
import de.hdodenhof.xingapi.internal.response.MessagesWrapper;
import de.hdodenhof.xingapi.internal.response.NetworkActivityWrapper;
import de.hdodenhof.xingapi.internal.response.ProfileMessageWrapper;
import de.hdodenhof.xingapi.internal.response.ResultWrapper;
import de.hdodenhof.xingapi.internal.response.SharedContactsWrapper;
import de.hdodenhof.xingapi.internal.response.TagsWrapper;
import de.hdodenhof.xingapi.internal.response.UserWrapper;
import de.hdodenhof.xingapi.internal.response.VisitsWrapper;
import de.hdodenhof.xingapi.models.FindByEmailsResult;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

public abstract class XingApiInterface {

    static final String BASEPATH = "/v1";

    public interface UserProfiles {

        @GET(BASEPATH + "/users/{id}.json")
        UserWrapper getUser(@Path("userId") String userId, @Query("fields") String fields);

        @GET(BASEPATH + "/users/me.json")
        UserWrapper getMe(@Query("fields") String fields);

        @GET(BASEPATH + "/users/me/idcard.json")
        IdCardWrapper getIdCard();

        @GET(BASEPATH + "/users/find_by_emails.json")
        ResultWrapper<FindByEmailsResult> findByEmails(String emails, @Query("fields") String fields);

    }

    public interface Messages {

        @GET(BASEPATH + "/users/{userId}/conversations.json")
        ConversationsWrapper getConversations(@Path("userId") String userId);

        @POST(BASEPATH + "/users/{userId}/conversations.json")
        ConversationWrapper postConversation(@Path("userId") String userId, @Query("subject") String subject, @Query("content") String content, @Query("recipient_id") String recipientId);

        @GET(BASEPATH + "/users/{userId}/conversations/{conversationId}.json")
        ConversationWrapper getConversation(@Path("userId") String userId, @Path("conversationId") String conversationId);

        @PUT(BASEPATH + "/users/{userId}/conversations/{conversationId}/read")
        String markConversationAsRead(@Path("userId") String userId, @Path("conversationId") String conversationId);

        @GET(BASEPATH + "/users/{userId}/conversations/{conversationId}/messages.json")
        MessagesWrapper getMessages(@Path("userId") String userId, @Path("conversationId") String conversationId);

        @GET(BASEPATH + "/users/{userId}/conversations/{conversationId}/messages/{messageId}.json")
        MessageWrapper getMessage(@Path("userId") String userId, @Path("conversationId") String conversationId, @Path("messageId") String messageId);

        @PUT(BASEPATH + "/users/{userId}/conversations/{conversationId}/messages/{messageId}/read")
        String markMessageAsRead(@Path("userId") String userId, @Path("conversationId") String conversationId, @Path("messageId") String messageId);

        @DELETE(BASEPATH + "/users/{userId}/conversations/{conversationId}/messages/{messageId}/read")
        String markMessageAsUnread(@Path("userId") String userId, @Path("conversationId") String conversationId, @Path("messageId") String messageId);

        @POST(BASEPATH + "/users/{userId}/conversations/{conversationId}/messages.json")
        MessageWrapper postMessage(@Path("userId") String userId, @Path("conversationId") String conversationId, @Query("content") String content);

        @DELETE(BASEPATH + "/users/{userId}/conversations/{conversationId}")
        String deleteConversation(@Path("userId") String userId, @Path("conversationId") String conversationId);

    }

    public interface ProfileMessages {

        @GET(BASEPATH + "/users/{userId}/profile_message.json")
        ProfileMessageWrapper getProfileMessage(@Path("userId") String userId);

        @PUT(BASEPATH + "/users/{userId}/profile_message")
        String setProfileMessage(@Path("userId") String userId, @Query("message") String message, @Query("public") Boolean isPublic);

    }

    public interface Contacts {

        @GET(BASEPATH + "/users/{userId}/contacts.json")
        ContactsWrapper getContacts(@Path("userId") String userId);

        @GET(BASEPATH + "/users/{userId}/contacts/{contactId}/tags")
        TagsWrapper getContactTags(@Path("userId") String userId, @Path("contactId") String contactId);

        @GET(BASEPATH + "/users/{userId}/contacts/shared.json")
        SharedContactsWrapper getSharedContacts(@Path("userId") String userId);

    }

    public interface NetworkFeed {

        @GET(BASEPATH + "/users/{userId}/network_feed.json")
        NetworkActivityWrapper getNetworkFeed(@Path("userId") String userId, @Query("aggregate") Boolean aggregate, @Query("since") Date since, @Query("until") Date until, @Query("user_fields") String userFields);

        @GET(BASEPATH + "/users/{userId}/feed.json")
        NetworkActivityWrapper getUserFeed(@Path("userId") String userId);

        @POST(BASEPATH + "/users/{userId}/status_message.json")
        String postStatusMessage(@Path("userId") String userId, @Query("message") String message);

        @GET(BASEPATH + "/activities/{activityId}.json")
        ActivityWrapper getActivity(@Path("activityId") String activityId);

        @POST(BASEPATH + "/activities/{activityId}/share.json")
        ActivityWrapper shareActivity(@Path("activityId") String activityId, @Query("text") String text);

        @DELETE(BASEPATH + "/activities/{activityId}")
        String deleteActivity(@Path("activityId") String activityId);

        @GET(BASEPATH + "/activities/{activityId}/comments.json")
        CommentsWrapper getComments(@Path("activityId") String activityId);

        @POST(BASEPATH + "/activities/{activityId}/comments.json")
        CommentsWrapper postComment(@Path("activityId") String activityId, @Query("text") String text);

        @DELETE(BASEPATH + "/activities/{activityId}/comments/{commentId}")
        String deleteComment(@Path("activityId") String activityId, @Path("commentId") String commentId);

        @GET(BASEPATH + "/activities/{activityId}/likes.json")
        LikesWrapper getLikes(@Path("activityId") String activityId);

        @PUT(BASEPATH + "/activities/{activityId}/like.json")
        String like(@Path("activityId") String activityId);

        @DELETE(BASEPATH + "/activities/{activityId}/like.json")
        String unlike(@Path("activityId") String activityId);

    }

    public interface ProfileVisits {

        @GET(BASEPATH + "/users/{userId}/visits.json")
        VisitsWrapper getVisits(@Path("userId") String userId);

        @POST(BASEPATH + "/users/{userId}/visits.json")
        VisitsWrapper postVisit(@Path("userId") String userId);

    }

}
