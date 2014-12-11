package de.hdodenhof.xingapi.internal.response;

import com.google.gson.annotations.SerializedName;

import de.hdodenhof.xingapi.models.IdCard;

public class IdCardWrapper implements ResponseWrapper<IdCard> {

    @SerializedName("id_card")
    IdCard idCard;

    @Override
    public IdCard unwrap() {
        return idCard;
    }

}
