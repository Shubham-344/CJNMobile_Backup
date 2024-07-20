package com.bpsi.cjnnetwork.model;

import com.google.gson.annotations.SerializedName;

public class ResponseParameterLogin {

    @SerializedName("responseStatus")
    private String responseStatus;

    @SerializedName("responseMessage")
    private ResponseMessage responseMessage; // Use Object to handle both String and ResponseMessage

    public String getResponseStatus() {
        return responseStatus;
    }

    public ResponseMessage getResponseMessage() {
        return responseMessage;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public void setResponseMessage(ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
    }


}
