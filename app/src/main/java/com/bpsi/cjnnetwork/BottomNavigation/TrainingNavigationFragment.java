package com.bpsi.cjnnetwork.BottomNavigation;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.loader.content.CursorLoader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
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
import com.bpsi.cjnnetwork.TainingWebView;
import com.bpsi.cjnnetwork.WebsiteOpeningActivity;
import com.bpsi.cjnnetwork.databinding.FragmentTrainingNavigationBinding;
import com.bpsi.cjnnetwork.model.Recyclerview_qr_code;
import com.bpsi.cjnnetwork.network.WebserviceConstants;
import com.bpsi.cjnnetwork.utils.qrcode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TrainingNavigationFragment extends Fragment {
    private FragmentTrainingNavigationBinding binding;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTrainingNavigationBinding.inflate(inflater, container, false);
        RecyclerView recycler_view_qrcodes = binding.trainingQRCodeRecyclerView;
//        binding.training.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(requireActivity(), TainingWebView.class));
//            }
//        });


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://"+ WebserviceConstants.currentMode +".cjnnow.com/api/gettvshowinfo01", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("1onResponse: 12345", response.toString());
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(response).getAsJsonObject();
                Log.d("Response_11111", jsonObject.get("responseMessage").getAsJsonObject().get("Display").getAsJsonObject().get("2").toString());

                try {
                    JsonArray qr_code5 = jsonObject.get("responseMessage").getAsJsonObject().get("Display").getAsJsonObject().get("4").getAsJsonArray();
                    for (int i = 0; i < qr_code5.size(); i++) {
                        qr_codes_links.add(new qrcode("training/"+qr_code5.get(i).getAsJsonObject().get("training_qrcode_id").toString().replace("\"",""),qr_code5.get(i).getAsJsonObject().get("training_institute_id").toString().replace("\"",""),qr_code5.get(i).getAsJsonObject().get("web_link").toString().replace("\"","")));
                        Log.d("CheckResponse", qr_codes_links.toString());
                    }
                    Recyclerview_qr_code trainingRecyclerviewQrCode=new Recyclerview_qr_code(qr_codes_links,getContext(),TrainingNavigationFragment.this::onClick_dashboard_tapped);
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






//
//        binding.vidume.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                UIHelper.getInstance().showMessage(requireContext(),"Coming Soon ");
//                pickVideo();
//
//            }
//        });
//        binding.sendEmailResume.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (checkPermission()) {
//                    openPdfFile();
//                }
//            }
//        });
//
//        binding.sendEmailButton.setOnClickListener(view -> sendEmail());
//

        return binding.getRoot();
    }

//    private void pickVideo() {
//
//        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//        intent.setType("video/*");
//        startActivityForResult(intent, REQUEST_VIDEO_PICK);
//
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_VIDEO_PICK && resultCode == Activity.RESULT_OK && data != null) {
//            uri = data.getData();
//            Toast.makeText(requireContext(), "Video picked successfully", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(requireContext(), "Error picking video", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private static String getRealPathFromUri(Uri uri, Context context) {
//        if (uri == null) {
//            return null;
//        }
//
//        String[] projection = {MediaStore.Video.Media.DATA};
//        CursorLoader loader = new CursorLoader(context, uri, projection, null, null, null);
//        Cursor cursor = loader.loadInBackground();
//
//        if (cursor != null && cursor.moveToFirst()) {
//            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
//            String path = cursor.getString(column_index);
//            cursor.close();
//            return path;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_EXTERNAL_STORAGE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                pickVideo();
//            } else {
//                Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private void sendEmail() {
//        // Replace these values with your email configuration
//        String senderEmail = "waghmodeajinkya80@gmail.com";
//        String senderPassword = "Ajink@7242";
//        String recipientEmail = "waghmodeajinkya72@gmail.co";
//        String emailTitle = "Video Email Title";
//        String emailBody = "Video Email Body";
//
//        new SendEmailTask(requireContext(), senderEmail, senderPassword, recipientEmail, emailTitle, emailBody, uri).execute();
//    }
//
//    public static class SendEmailTask extends AsyncTask<Void, Void, Boolean> {
//        private final String senderEmail;
//        private final String senderPassword;
//        private final String recipientEmail;
//        private final String emailTitle;
//        private final String emailBody;
//        private final Uri uri;
//        private final Context context;
//
//        public SendEmailTask(Context context, String senderEmail, String senderPassword, String recipientEmail, String emailTitle, String emailBody, Uri uri) {
//            this.senderEmail = senderEmail;
//            this.senderPassword = senderPassword;
//            this.recipientEmail = recipientEmail;
//            this.emailTitle = emailTitle;
//            this.emailBody = emailBody;
//            this.uri = uri;
//            this.context = context;
//        }
//
//        @Override
//        protected Boolean doInBackground(Void... params) {
//            try {
//
//                return true; // Email sent successfully
//            } catch (Exception e) {
//                e.printStackTrace();
//                return false; // Error sending email
//            }
//        }
//
//        @Override
//        protected void onPostExecute(Boolean success) {
//            Activity activity = (Activity) context;
//
//            if (success) {
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(context, "Email sent successfully", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            } else {
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(context, "Error sending email or no video selected", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        }
//
//    }
//
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
//
//
//    private boolean checkPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
//                    != PackageManager.PERMISSION_GRANTED) {
//                // Permission is not granted
//                ActivityCompat.requestPermissions(requireActivity(),
//                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                        READ_EXTERNAL_STORAGE_REQUEST);
//                return false;
//            }
//        }
//        // Permission is granted
//        return true;
//    }
//
////    @Override
////    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
////                                           @NonNull int[] grantResults) {
////        if (requestCode == READ_EXTERNAL_STORAGE_REQUEST) {
////            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
////                // Permission granted, proceed with opening the PDF file
////                openPdfFile();
////            } else {
////                // Permission denied, show a message or handle accordingly
////                Toast.makeText(requireContext(), "Permission denied. Unable to open PDF.", Toast.LENGTH_SHORT).show();
////            }
////        }
////    }
//
//    private void openPdfFile() {
//        // Your existing code for opening the PDF file
//        // ...
//    }

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