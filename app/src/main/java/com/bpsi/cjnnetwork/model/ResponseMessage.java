package com.bpsi.cjnnetwork.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseMessage {
    @SerializedName("data")
    @Expose
    private LoginDataOutput data;

    public LoginDataOutput getData() {
        return data;
    }

    public void setData(LoginDataOutput data) {
        this.data = data;
    }
}
