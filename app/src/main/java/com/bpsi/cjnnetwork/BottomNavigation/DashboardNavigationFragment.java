package com.bpsi.cjnnetwork.BottomNavigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bpsi.cjnnetwork.AssessmentWebView;
import com.bpsi.cjnnetwork.DashboardActivity;
import com.bpsi.cjnnetwork.R;
import com.bpsi.cjnnetwork.databinding.FragmentAssesmentNavigationBinding;
import com.bpsi.cjnnetwork.databinding.FragmentDashboardNavigationBinding;
import com.bpsi.cjnnetwork.databinding.FragmentInterviewNavigationBinding;
import com.bpsi.cjnnetwork.network.WebserviceConstants;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.HashMap;
import java.util.Map;


public class DashboardNavigationFragment extends Fragment {
    private FragmentDashboardNavigationBinding binding;
    private SimpleExoPlayer player;
    private PlayerView playerView;
    String videourl = "myResponse";
    private YouTubePlayerView yt_player;
    String url="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDashboardNavigationBinding.inflate(inflater, container, false);
        yt_player = binding.ytPlayer;
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://"+ WebserviceConstants.currentMode +".cjnnow.com/api/gettvshowinfo01", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("1onResponse: 1", response.toString());
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(response).getAsJsonObject();

                try {
                    String string = jsonObject.get("responseMessage").getAsJsonObject().get("Display").getAsJsonObject().get("0").getAsJsonObject().get("0").getAsJsonArray().get(0).getAsJsonObject().get("video_url").toString();
                    Log.e("1onResponse: 123>>>>>>>>", "--" + string.replace("https://www.youtube.com/embed/", "").charAt(12) + "--");
                    url = "";
                    url = string.replace("https://www.youtube.com/embed/", "").replace("\"","");
                    getLifecycle().addObserver((LifecycleObserver) yt_player);
//                    Toast.makeText(getContext(),url, Toast.LENGTH_SHORT).show();
                    yt_player.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                        @Override
                        public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                            youTubePlayer.loadVideo(url, 0);
                            Log.e("1onReady:!!!!!!!!!!!!!", "ready");
                        }

                        @Override
                        public void onError(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerError error) {
                            super.onError(youTubePlayer, error);
                            Log.e("1onError:!!!!!!!!!!", error.toString());
                        }
                    });
                    Log.e("1onResponse: 123>>>>>>>>", "--" + url + "--");
                    System.out.println(string);
                    StringBuilder stringBuilder = new StringBuilder(string);

                } catch (Exception e) {
//                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("1onResponse: 123<<<<<<<<<<<", e.toString());
                }
                Log.e("1onResponse: 1.2", "-------------------------" + jsonObject.toString() + "-------------------------");
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


        StringRequest yt_video_desc = new StringRequest(Request.Method.POST, "https://"+"dev"+".cjnnow.com/api/listFeedback", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("1onResponse: 1", response.toString());
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(response).getAsJsonObject();
                Log.e("1onResponse: 1.2", "-------------------------" + jsonObject.toString() + "-------------------------");
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
        };
        requestQueue.add(yt_video_desc);


//region Buttons on Dashboard
        binding.trainingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              changeFragment(new TrainingNavigationFragment());
            }
        });
        binding.assessmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new AssesmentNavigationFragment());
            }
        });

        binding.interviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new InterviewNavigationFragment());
            }
        });

        binding.jobOfferBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new JobOfferNavigationFragment());
            }
        });
//endregion


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void changeFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
