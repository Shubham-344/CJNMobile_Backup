package com.bpsi.cjnnetwork.model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InputParameterJobDec {

    @SerializedName("id")
    @Expose
    private String jobid;

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;

    }
}
