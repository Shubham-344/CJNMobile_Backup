package com.bpsi.cjnnetwork.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.logging.HttpLoggingInterceptor;


public class ApiClient {
    private static Retrofit retrofit = null;
    private static final String API_KEY = "SYXMcLRzqq1VRby6xISkrn3ieu8kmkHVWW37sRWK2b831424";
    public static final int ID = 10;

    /*Gson gson = new GsonBuilder()
            .setLenient()
            .create();*/


    public static Retrofit getClient() {
        if (retrofit==null) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Interceptor apiKeyInterceptor = chain -> {
                Request originalRequest = chain.request();
                Request newRequest = originalRequest.newBuilder()
                        .header("apikey", API_KEY)
                        .build();
                Log.d("API_TAG", "key"+API_KEY);
                return chain.proceed(newRequest);
            };

            // Build OkHttpClient with the Interceptor
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(apiKeyInterceptor)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(WebserviceConstants.HTTP_BASE_URL+WebserviceConstants.SMART_COOKIE_STUDNET_BASE_URL)
                   // .baseUrl("https://dev.smartcookie.in/")
                    //.baseUrl("https://test.smartcookie.in/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }
        Log.i("BAseUrl", WebserviceConstants.HTTP_BASE_URL+WebserviceConstants.SMART_COOKIE_STUDNET_BASE_URL);
        return retrofit;
    }

    public static Retrofit getDocs(){
        if (retrofit==null) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Interceptor apiKeyInterceptor = chain -> {
                Request originalRequest = chain.request();
                Request newRequest = originalRequest.newBuilder()
                        .header("apikey", API_KEY)
                        .build();
                Log.d("API_TAG", "key"+API_KEY);
                return chain.proceed(newRequest);
            };

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            // Build OkHttpClient with the Interceptor
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(apiKeyInterceptor)
                    .addInterceptor(loggingInterceptor)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(WebserviceConstants.GET_JOBDESCRIPTION)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }
        Log.i("BAseUrl",WebserviceConstants.GET_JOBDESCRIPTION);
        return retrofit;
    }
}
