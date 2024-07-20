package com.bpsi.cjnnetwork.BottomNavigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bpsi.cjnnetwork.JobDescription;
import com.bpsi.cjnnetwork.PdfViewverActivity;
import com.bpsi.cjnnetwork.databinding.FragmentJobOfferNavigationBinding;
import com.bpsi.cjnnetwork.model.InputParameterJobDec;
import com.bpsi.cjnnetwork.model.OutputJobDescription;
import com.bpsi.cjnnetwork.model.Recyclerview_qr_code;
import com.bpsi.cjnnetwork.network.ApiClient;
import com.bpsi.cjnnetwork.network.AuthenticationApi;
import com.bpsi.cjnnetwork.network.WebserviceConstants;
import com.bpsi.cjnnetwork.utils.qrcode;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobOfferNavigationFragment extends Fragment {
    private FragmentJobOfferNavigationBinding binding;
    String pdfName;
    Intent intent;
    Handler myHandler;
    private static final int REQUEST_VIDEO_PICK = 1;
    private static final int REQUEST_EXTERNAL_STORAGE = 101;
    private static final int READ_EXTERNAL_STORAGE_REQUEST = 1;

    Uri uri;
    private static final int REQUEST_VIDEO_PERMISSION = 100;
    ArrayList<qrcode> qr_codes_links=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentJobOfferNavigationBinding.inflate(inflater, container, false);
        RecyclerView recycler_view_qrcodes = binding.jobDescQRCodeRecyclerView;

        myHandler = new Handler();
        binding.jc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jobIDInput = binding.jobId.getText().toString();
                getJobDescription(jobIDInput);
                intent = new Intent(requireContext(), JobDescription.class);

                myHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        intent.putExtra("DocLink",pdfName);
                        Log.d("API_TAG", "URL : " + pdfName);
                        startActivity(intent);
                    }
                }, 2000);
            }
        });



        binding.tvUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(requireContext(), PdfViewverActivity.class));

            }
        });




        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://"+ WebserviceConstants.currentMode +".cjnnow.com/api/gettvshowinfo01", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("1onResponse: 12345", response.toString());
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(response).getAsJsonObject();
//                Log.d("Response_11111", jsonObject.get("responseMessage").getAsJsonObject().get("Display").getAsJsonObject().get("2").toString());

                try {
                    JsonArray qr_code5 = jsonObject.get("responseMessage").getAsJsonObject().get("Display").getAsJsonObject().get("7").getAsJsonArray();
                    for (int i = 0; i < qr_code5.size(); i++) {
                        qr_codes_links.add(new qrcode("jobDesc/"+qr_code5.get(i).getAsJsonObject().get("job_desc_qr_code").toString().replace("\"",""),qr_code5.get(i).getAsJsonObject().get("id").toString().replace("\"",""),qr_code5.get(i).getAsJsonObject().get("Job_desc_pdf_link").toString().replace("\"","")));
                        Log.d("CheckResponse", qr_codes_links.toString());
                    }
                    Recyclerview_qr_code trainingRecyclerviewQrCode=new Recyclerview_qr_code(qr_codes_links,getContext(),JobOfferNavigationFragment.this::onClick_dashboard_tapped);
                    recycler_view_qrcodes.setLayoutManager(new GridLayoutManager(getContext(),2));
                    recycler_view_qrcodes.setAdapter(trainingRecyclerviewQrCode);
                }catch (Exception e){
//                    Toast.makeText(getContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("1onResponse: 2", error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("apikey", "SYXMcLRzqq1VRby6xISkrn3ieu8kmkHVWW37sRWK2b831424");
                return params;
            }
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("show_id", "s501");
                return params;
            }
        };
        requestQueue.add(stringRequest);





        return binding.getRoot();
    }
    private void getJobDescription(final String jobid){
        String GetJobDescurl = WebserviceConstants.GET_JOBDESCRIPTION + jobid;
        AuthenticationApi authenticationApi = ApiClient.getDocs().create(AuthenticationApi.class);
        InputParameterJobDec d = new InputParameterJobDec();
        d.setJobid(jobid);
        Log.e("API_TAG", "Job Description Input : " + new Gson().toJson(d));
        Call<OutputJobDescription> call = authenticationApi.jobDescriptionPdf(GetJobDescurl);
        Log.e("request_api_url", "" + call.request().url());

        call.enqueue(new Callback<OutputJobDescription>() {
            @Override
            public void onResponse(Call<OutputJobDescription> call, Response<OutputJobDescription> response) {
                Log.d("API_TAG", "Job Description Response: " + new Gson().toJson(response.body().getId()));
                Log.d("API_TAG", response.body().getJobDescPdfName());
                pdfName = response.body().getJobDescPdfName();
                if (response.body() != null) {
                    Log.d("API_TAG", "Response true"+ response.body());
                } else {
                    Log.d("API_TAG", "Response null"+ response.body());
                }
            }

            @Override
            public void onFailure(Call<OutputJobDescription> call, Throwable t) {
                //validationDialog();
                Log.d("myResponse:", "MSG " + t.toString());
            }
        });
    }

    public String getDocURL(String id){
        String url;
        url = WebserviceConstants.GET_JOBDESCRIPTION + "/" + id;
        return url;
    }



    public void onClick_dashboard_tapped(int position, int tapped_on) {
        if (tapped_on==1){
            try {
//                Intent intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(qr_codes_links.get(position).assessment_test_link));
//                startActivity(intent);

                getJobDescription(qr_codes_links.get(position).assessment_name);
                intent = new Intent(requireContext(), JobDescription.class);

                myHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        intent.putExtra("DocLink",pdfName);
                        Log.d("API_TAG", "URL : " + pdfName);
                        startActivity(intent);
                    }
                }, 2000);
            }catch (Exception e){
                try {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://"+qr_codes_links.get(position).assessment_test_link));
                    startActivity(intent);
                }catch (Exception e1){
//                    Toast.makeText(getContext(), e1.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("onClick_dashboard_tapped:------------------",e1.toString());
                    Log.e("onClick_dashboard_tapped:------------------",qr_codes_links.get(position).assessment_test_link.replace("http","-->>"));
                }
            }
        }
//        Toast.makeText(getContext(), position+"-->>"+tapped_on, Toast.LENGTH_SHORT).show();
    }

}

