package com.bpsi.cjnnetwork.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.bpsi.cjnnetwork.utils.GlobalInterface;

public class CjnSharedPreferences {
    /**
     * Name of SharedPreferences file
     */
    public static final String PREFERENCE_NAME = "CjnNetworkSharedPreferences";
    public static final String PREFERENCE_NAME_REM = "CjnNetworkSharedPreferences_REM";

    /**
     * Key for default audio
     */

    private static final boolean EMPTY_BOOLEAN_DEFAULT_VALUE = false;
    private static final String EMPTY_STRING_DEFAULT_VALUE = "";
    private static final int EMPTY_INT_DEFAULT_VALUE = 0;
    /**
     * Key for offline login
     */
    private static final String IS_LOGIN = "IS_LOGIN";
    private static boolean EMAIL_EMPATY_BOOLEAN_VALUE = false;

    /**
     * SharedPreference Object
     */
    private static SharedPreferences _sharedPreferences;
    private static SharedPreferences _rememberpref;

    /**
     * Initialize public class SmartCookieSharedPreferences {
     * . This is one time initialization. It should be done from the
     * Application.onCreate().
     *
     * @param context - Application context
     */
    public static void init(Context context) {

        if (_sharedPreferences == null ) {
            /** Get the shared preferences object for RO. */
            _sharedPreferences =
                    context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        }

        if (_rememberpref == null ) {
            /** Get the shared preferences object for RO. */
            _rememberpref =
                    context.getSharedPreferences(PREFERENCE_NAME_REM, Context.MODE_PRIVATE);
        }
        //clear all from phone storage
    }
    public static void setAppType(String AppType) {
        SharedPreferences.Editor _editor = _sharedPreferences.edit();

        _editor.putString(GlobalInterface.APPTYPE, AppType);
        _editor.commit();
    }
    public static String getAppType() {
        String value = _sharedPreferences.getString(GlobalInterface.APPTYPE, GlobalInterface.PRODUCTION);
        return value;
    }
}
