package de.hdodenhof.xingapi.enums;

import com.google.gson.annotations.SerializedName;

public enum ActivityVerb {
    post, @SerializedName("make-friend") makefriend, @SerializedName("rsvp-yes") rsvpyes, share, follow, join, update
}
