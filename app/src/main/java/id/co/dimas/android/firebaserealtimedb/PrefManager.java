package id.co.dimas.android.firebaserealtimedb;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sidiq on 09/11/2017.
 */

public class PrefManager {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context mContext;

    private static final String PREF_NAME = "intro";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {

        this.mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, 0);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
