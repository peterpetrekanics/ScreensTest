package com.liferay.support.screenstest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.liferay.mobile.screens.auth.login.LoginScreenlet;
import com.liferay.mobile.screens.context.LiferayScreensContext;
import com.liferay.mobile.screens.context.SessionContext;
import com.liferay.mobile.screens.context.storage.CredentialsStorageBuilder;

public class AutoLoginActivity extends AppCompatActivity {

    private static final String TAG = "AutoLoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_login);

        Intent intent = null;

        /*SharedPreferences preferences = getPreferences(1);
        SharedPreferences.Editor editor = preferences.edit();

        editor.clear();
        editor.commit();*/


        LiferayScreensContext.init(this);

        SessionContext.loadStoredCredentials(CredentialsStorageBuilder.StorageType.SHARED_PREFERENCES);
        if(SessionContext.hasUserInfo()){
            // For now, I will use MainActivity because there is a bug:
            // when using stored credentials, the user's portrait can not be loaded
            // see https://issues.liferay.com/browse/LSR-825
            intent = new Intent(this, UserActivity.class);
            //intent = new Intent(this, MainActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);



    }
}
