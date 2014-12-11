package de.hdodenhof.xingapi;

import de.hdodenhof.xingapi.internal.communication.ErrorHandler;
import de.hdodenhof.xingapi.internal.communication.XingApiInterface;
import de.hdodenhof.xingapi.models.Conversation;
import de.hdodenhof.xingapi.models.Conversations;
import de.hdodenhof.xingapi.models.Message;
import de.hdodenhof.xingapi.models.Messages;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class MessagesAPI extends BaseAPI {

    private final XingApiInterface.Messages mAPI;

    protected MessagesAPI(RestAdapter restAdapter) {
        mAPI = restAdapter.create(XingApiInterface.Messages.class);
    }

    public Conversations getConversations(String userId) {
        validateNotEmpty(userId, "userId");

        try {
            return mAPI.getConversations(userId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public Conversation postConversation(String userId, String subject, String content, String recipientId) {
        validateNotEmpty(userId, "userId");
        validateNotEmpty(subject, "subject");
        validateNotEmpty(content, "content");
        validateNotEmpty(recipientId, "recipientId");

        try {
            return mAPI.postConversation(userId, subject, content, recipientId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public Conversation getConversation(String userId, String conversationId) {
        validateNotEmpty(userId, "userId");
        validateNotEmpty(conversationId, "conversationId");

        try {
            return mAPI.getConversation(userId, conversationId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public void markConversationAsRead(String userId, String conversationId) {
        validateNotEmpty(userId, "userId");
        validateNotEmpty(conversationId, "conversationId");

        try {
            mAPI.markConversationAsRead(userId, conversationId);
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
    }

    public Messages getMessages(String userId, String conversationId) {
        validateNotEmpty(userId, "userId");
        validateNotEmpty(conversationId, "conversationId");

        try {
            return mAPI.getMessages(userId, conversationId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public Message getMessage(String userId, String conversationId, String messageId) {
        validateNotEmpty(userId, "userId");
        validateNotEmpty(conversationId, "conversationId");
        validateNotEmpty(messageId, "messageId");

        try {
            return mAPI.getMessage(userId, conversationId, messageId).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public void markMessageAsRead(String userId, String conversationId, String messageId) {
        validateNotEmpty(userId, "userId");
        validateNotEmpty(conversationId, "conversationId");
        validateNotEmpty(messageId, "messageId");

        try {
            mAPI.markMessageAsRead(userId, conversationId, messageId);
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
    }

    public void markMessageAsUnread(String userId, String conversationId, String messageId) {
        validateNotEmpty(userId, "userId");
        validateNotEmpty(conversationId, "conversationId");
        validateNotEmpty(messageId, "messageId");

        try {
            mAPI.markMessageAsUnread(userId, conversationId, messageId);
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
    }

    public Message postMessage(String userId, String conversationId, String content) {
        validateNotEmpty(userId, "userId");
        validateNotEmpty(conversationId, "conversationId");
        validateNotEmpty(content, "content");

        try {
            return mAPI.postMessage(userId, conversationId, content).unwrap();
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public void deleteConversation(String userId, String conversationId) {
        validateNotEmpty(userId, "userId");
        validateNotEmpty(conversationId, "conversationId");

        try {
            mAPI.deleteConversation(userId, conversationId);
        } catch (RetrofitError e) {
            ErrorHandler.handle(e);
        }
    }
}
