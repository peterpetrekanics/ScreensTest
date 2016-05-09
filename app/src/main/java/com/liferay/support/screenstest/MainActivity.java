package com.liferay.support.screenstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.liferay.mobile.screens.auth.login.LoginListener;
import com.liferay.mobile.screens.auth.login.LoginScreenlet;
import com.liferay.mobile.screens.context.LiferayScreensContext;
import com.liferay.mobile.screens.context.SessionContext;
import com.liferay.mobile.screens.context.User;
import com.liferay.mobile.screens.context.storage.CredentialsStorageBuilder;

public class MainActivity extends AppCompatActivity implements LoginListener{

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginScreenlet loginScreenlet = (LoginScreenlet) findViewById(R.id.login_screenlet);
        loginScreenlet.setListener(this);
    }

    @Override
    public void onLoginSuccess(User user) {
        Log.d(TAG, "onLoginSuccess: User logged on: " + user.getAttributes());
        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginFailure(Exception e) {
        Log.d(TAG, "failed: ",e);

    }
}
