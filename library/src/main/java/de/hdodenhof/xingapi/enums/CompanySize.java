package de.hdodenhof.xingapi.enums;

import com.google.gson.annotations.SerializedName;

public enum CompanySize {

    @SerializedName("1")
    SINGLE,
    @SerializedName("1-10")
    ONE_PLUS,
    @SerializedName("11-50")
    ELEVEN_PLUS,
    @SerializedName("51-200")
    FIFTYONE_PLUS,
    @SerializedName("201-500")
    TWOHUNDREDONE_PLUS,
    @SerializedName("501-1000")
    FIVEHUNDREDONE_PLUS,
    @SerializedName("1001-5000")
    ONETHOUSANDONE_PLUS,
    @SerializedName("5001-10000")
    FIVETHOUSANDONE_PLUS,
    @SerializedName("10001+")
    TENTHOUSANDONE_PLUS

}
