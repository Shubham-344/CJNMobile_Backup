package com.bpsi.cjnnetwork;

import android.content.Context;
import android.content.DialogInterface;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class UIHelper {


    private static UIHelper uiHelper = null;


    private UIHelper() {
        // No instance
    }

    public static UIHelper getInstance() {
        if (uiHelper == null) {
            uiHelper = new UIHelper();
        }
        return uiHelper;
    }


    /**
     * Show message in SnackBar
     *
     * @param context   Activity context
     * @param message   message to be shown on toast
      *                  current fragment only
     */
    public AlertDialog showMessage(Context context, String message) {

        AlertDialog alertDialog = null;
        if (TextUtils.isEmpty(message))
            return null;

        try {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("CJN");
            builder.setMessage(message);
            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog = builder.create();

            if (!alertDialog.isShowing() && alertDialog != null) {
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();

            }


        } catch (Exception e) {
        }

        return alertDialog;
    }


    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber);
    }

    public static void toast(Context context, String message) {
        if (context != null && message != null && !message.isEmpty()) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }
}
