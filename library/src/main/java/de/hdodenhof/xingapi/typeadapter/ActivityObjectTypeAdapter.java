package de.hdodenhof.xingapi.typeadapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.xingapi.BuildConfig;
import de.hdodenhof.xingapi.enums.ActivityObjectType;
import de.hdodenhof.xingapi.models.*;

public class ActivityObjectTypeAdapter implements JsonDeserializer<ActivityObject> {

    private static final String BASE_PACKAGE = BuildConfig.APPLICATION_ID + ".models.";

    private static final Map<String, String> sClassMap = new HashMap<>();

    static {
        sClassMap.put(ActivityObjectType.BOOKMARK.name().toLowerCase(), BASE_PACKAGE + Bookmark.class.getSimpleName());
        sClassMap.put(ActivityObjectType.COMPANY_PROFILE.name().toLowerCase(), BASE_PACKAGE + CompanyProfile.class.getSimpleName());
        sClassMap.put(ActivityObjectType.COMPANY_PROFILE_UPDATE.name().toLowerCase(), BASE_PACKAGE + CompanyProfileUpdate.class.getSimpleName());
        sClassMap.put(ActivityObjectType.EVENT.name().toLowerCase(), BASE_PACKAGE + Event.class.getSimpleName());
        sClassMap.put(ActivityObjectType.GROUP.name().toLowerCase(), BASE_PACKAGE + Group.class.getSimpleName());
        sClassMap.put(ActivityObjectType.JOB_POSTING.name().toLowerCase(), BASE_PACKAGE + JobPosting.class.getSimpleName());
        sClassMap.put(ActivityObjectType.STATUS.name().toLowerCase(), BASE_PACKAGE + Status.class.getSimpleName());
        sClassMap.put(ActivityObjectType.THREAD.name().toLowerCase(), BASE_PACKAGE + de.hdodenhof.xingapi.models.Thread.class.getSimpleName());
        sClassMap.put(ActivityObjectType.USER.name().toLowerCase(), BASE_PACKAGE + User.class.getSimpleName());
    }

    @Override
    public ActivityObject deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String type = jsonObject.get("type").getAsString().toLowerCase();

        try {
            return jsonDeserializationContext.deserialize(jsonElement, Class.forName(sClassMap.get(type)));
        } catch (ClassNotFoundException e) {
            throw new JsonParseException("Unknown element type: " + type, e);
        }
    }
}
