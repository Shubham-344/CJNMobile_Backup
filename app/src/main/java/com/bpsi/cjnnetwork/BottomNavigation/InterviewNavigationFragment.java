package com.bpsi.cjnnetwork.BottomNavigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.bpsi.cjnnetwork.InterviewWebview;
import com.bpsi.cjnnetwork.WebsiteOpeningActivity;
import com.bpsi.cjnnetwork.databinding.FragmentInterviewNavigationBinding;
import com.bpsi.cjnnetwork.model.Recyclerview_qr_code;
import com.bpsi.cjnnetwork.network.WebserviceConstants;
import com.bpsi.cjnnetwork.utils.qrcode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class InterviewNavigationFragment extends Fragment {
    private FragmentInterviewNavigationBinding binding;
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
        binding = FragmentInterviewNavigationBinding.inflate(inflater, container, false);
        RecyclerView recycler_view_qrcodes = binding.interviewQRCodeRecyclerView;
//        binding.Interview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(requireContext(), InterviewWebview.class));
//            }
//        });

//        Log.d(TAG, "https://"+ WebserviceConstants.currentMode +".cjnnow.com/api/gettvshowinfo01");
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://"+ WebserviceConstants.currentMode +".cjnnow.com/api/gettvshowinfo01", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("1onResponse: 12345", response.toString());
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(response).getAsJsonObject();
                Log.d("Response_11111", jsonObject.get("responseMessage").getAsJsonObject().get("Display").getAsJsonObject().get("6").toString());

                try {
                    JsonArray qr_code5 = jsonObject.get("responseMessage").getAsJsonObject().get("Display").getAsJsonObject().get("6").getAsJsonArray();
                    for (int i = 0; i < qr_code5.size(); i++) {
                        qr_codes_links.add(new qrcode("interview/"+qr_code5.get(i).getAsJsonObject().get("interview_qr_code").toString().replace("\"",""),qr_code5.get(i).getAsJsonObject().get("conference_system_type").toString().replace("\"",""),qr_code5.get(i).getAsJsonObject().get("interview_room_link").toString().replace("\"","")));
                        Log.d("CheckResponse", qr_codes_links.toString());
                    }
                    Recyclerview_qr_code interviewRecyclerviewQrCode=new Recyclerview_qr_code(qr_codes_links,getContext(),InterviewNavigationFragment.this::onClick_dashboard_tapped);
//                    recycler_view_qrcodes.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                    recycler_view_qrcodes.setLayoutManager(new GridLayoutManager(getContext(),2));

                    recycler_view_qrcodes.setAdapter(interviewRecyclerviewQrCode);
                }catch (Exception e){
//                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("Response_11111", e.getMessage());
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
        //---just for testing, It is of no use
//        try{
//            binding.interview.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(getContext(), WebsiteOpeningActivity.class);
//                    intent.putExtra("UrlLink","https://www.google.com");
//                    startActivity(intent);
//                }
//            });
//        }
//        catch (Exception e){
//            Log.e("webView", e.getMessage() );
//        }


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onClick_dashboard_tapped(int position, int tapped_on) {
        if (tapped_on==1){
            try {
//                Intent intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(qr_codes_links.get(position).assessment_test_link));
//                startActivity(intent);
                Intent intent = new Intent(getContext(), WebsiteOpeningActivity.class);
                intent.putExtra("UrlLink",qr_codes_links.get(position).assessment_test_link);
                Log.d( "webCheck11111",qr_codes_links.get(position).assessment_test_link);
                startActivity(intent);
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