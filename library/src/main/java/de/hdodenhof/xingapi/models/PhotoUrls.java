package de.hdodenhof.xingapi.models;

import com.google.gson.annotations.SerializedName;

public class PhotoUrls {

    private String thumb;
    private String large;
    private String miniThumb;
    private String maxiThumb;
    private String mediThumb;
    @SerializedName("size_32x32")
    private String size32;
    @SerializedName("size_48x48")
    private String size48;
    @SerializedName("size_64x64")
    private String size64;
    @SerializedName("size_96x96")
    private String size96;
    @SerializedName("size_128x128")
    private String size128;
    @SerializedName("size_192x192")
    private String size192;
    @SerializedName("size_256x256")
    private String size256;
    @SerializedName("size_1024x1024")
    private String size1024;
    private String sizeOriginal;

    @Deprecated
    public String getThumb() {
        return thumb;
    }

    @Deprecated
    public String getLarge() {
        return large;
    }

    @Deprecated
    public String getMiniThumb() {
        return miniThumb;
    }

    @Deprecated
    public String getMaxiThumb() {
        return maxiThumb;
    }

    @Deprecated
    public String getMediThumb() {
        return mediThumb;
    }

    public String getSize32() {
        return size32;
    }

    public String getSize48() {
        return size48;
    }

    public String getSize64() {
        return size64;
    }

    public String getSize96() {
        return size96;
    }

    public String getSize128() {
        return size128;
    }

    public String getSize192() {
        return size192;
    }

    public String getSize256() {
        return size256;
    }

    public String getSize1024() {
        return size1024;
    }

    public String getSizeOriginal() {
        return sizeOriginal;
    }
}
