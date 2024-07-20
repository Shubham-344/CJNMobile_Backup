package com.bpsi.cjnnetwork.model;

import com.google.gson.annotations.SerializedName;

public class ResponseParameterRegister {

    @SerializedName("responseStatus")
    private String responseStatus;

    @SerializedName("responseMessage")
    private Object responseMessage; // Use Object to handle both String and ResponseMessage

    public String getResponseStatus() {
        return responseStatus;
    }

    public Object getResponseMessage() {
        return responseMessage;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public void setResponseMessage(Object responseMessage) {
        this.responseMessage = responseMessage;
    }

    public static class ResponseMessage {

        @SerializedName("access_token")
        private String accessToken;

        @SerializedName("data")
        private UserData data;

        @SerializedName("email")
        private String[] email;

        public String[] getEmail() {
            return email;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public UserData getData() {
            return data;
        }
    }

    public static class UserData {

        @SerializedName("fullname")
        private String fullname;

        @SerializedName("email")
        private String email;

        @SerializedName("mobile")
        private String mobile;

        @SerializedName("updated_at")
        private String updatedAt;

        @SerializedName("created_at")
        private String createdAt;

        @SerializedName("id")
        private int id;

        public String getFullname() {
            return fullname;
        }

        public String getEmail() {
            return email;
        }

        public String getMobile() {
            return mobile;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public int getId() {
            return id;
        }
    }
}
