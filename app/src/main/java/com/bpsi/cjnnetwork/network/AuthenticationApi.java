package com.bpsi.cjnnetwork.network;

import com.bpsi.cjnnetwork.BottomNavigation.JobOfferNavigationFragment;
import com.bpsi.cjnnetwork.Global.Jobid;
import com.bpsi.cjnnetwork.model.InputParamerLogin;
import com.bpsi.cjnnetwork.model.InputParameterJobDec;
import com.bpsi.cjnnetwork.model.InputRegisterParameters;
import com.bpsi.cjnnetwork.model.OutputJobDescription;
import com.bpsi.cjnnetwork.model.ResponseParameterLogin;
import com.bpsi.cjnnetwork.model.ResponseParameterRegister;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface AuthenticationApi {

    @POST(WebserviceConstants.LOGIN_API)
    Call<ResponseParameterLogin> login(@Body InputParamerLogin d);

    @POST(WebserviceConstants.REGISTER_API)
    Call<ResponseParameterRegister> register(@Body InputRegisterParameters d);

//    @GET(WebserviceConstants.GET_JOBDESCRIPTION)
//    Call<OutputJobDescription> jobDescriptionPdf();
    @GET
    Call<OutputJobDescription> jobDescriptionPdf(@Url String url);
//    @GET(WebserviceConstants.DOC_LINK)
}
