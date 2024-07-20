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
import com.bpsi.cjnnetwork.AssessmentWebView;
import com.bpsi.cjnnetwork.databinding.FragmentAssesmentNavigationBinding;
import com.bpsi.cjnnetwork.model.Recyclerview_qr_code;
import com.bpsi.cjnnetwork.network.WebserviceConstants;
import com.bpsi.cjnnetwork.utils.qrcode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AssesmentNavigationFragment extends Fragment {
    private FragmentAssesmentNavigationBinding binding;
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
        binding = FragmentAssesmentNavigationBinding.inflate(inflater, container, false);
        RecyclerView recycler_view_qrcodes = binding.assessmentQRCodeRecyclerView;
//        binding.assessment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(requireActivity(), AssessmentWebView.class));
//            }
//        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://"+ WebserviceConstants.currentMode +".cjnnow.com/api/gettvshowinfo01", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("1onResponse: 12345", response.toString());
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(response).getAsJsonObject();
                Log.d("Response_11111", jsonObject.get("responseMessage").getAsJsonObject().get("Display").getAsJsonObject().get("7").toString());

                try {
                    JsonArray qr_code5 = jsonObject.get("responseMessage").getAsJsonObject().get("Display").getAsJsonObject().get("5").getAsJsonArray();
                    for (int i = 0; i < qr_code5.size(); i++) {
                        qr_codes_links.add(new qrcode("assessment/"+qr_code5.get(i).getAsJsonObject().get("assessment_qrcode_filename").toString().replace("\"",""),qr_code5.get(i).getAsJsonObject().get("assessment_system").toString().replace("\"",""),qr_code5.get(i).getAsJsonObject().get("assessment_test_link").toString().replace("\"","")));
                        Log.d("CheckResponse", qr_codes_links.toString());
                    }
                    Recyclerview_qr_code recyclerviewQrCode=new Recyclerview_qr_code(qr_codes_links,getContext(),AssesmentNavigationFragment.this::onClick_dashboard_tapped);
//                    recycler_view_qrcodes.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                    recycler_view_qrcodes.setLayoutManager(new GridLayoutManager(getContext(),2));

                    recycler_view_qrcodes.setAdapter(recyclerviewQrCode);
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
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(qr_codes_links.get(position).assessment_test_link));
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