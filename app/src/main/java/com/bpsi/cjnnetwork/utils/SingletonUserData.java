package com.bpsi.cjnnetwork.utils;

import com.bpsi.cjnnetwork.model.LoginDataOutput;

public class SingletonUserData {
    private static SingletonUserData userData ;
    private LoginDataOutput loginDataOutput;

    public static SingletonUserData getInstance(){
        if(userData==null){
            userData = new SingletonUserData();
        }
        return userData;
    }

    public LoginDataOutput getLoginDataOutput() {
        return loginDataOutput;
    }

    public void setLoginDataOutput(LoginDataOutput loginDataOutput) {
        this.loginDataOutput = loginDataOutput;
    }
}
