package com.liferay.support.screenstest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liferay.mobile.screens.context.SessionContext;
import com.liferay.mobile.screens.context.User;

public class UserActivity extends AppCompatActivity {

    Button showOpenTicketList;
    Intent createOpenLesaTicketListIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);



        TextView firstName = (TextView) findViewById(R.id.first_name);
        TextView lastName = (TextView) findViewById(R.id.last_name);
        //TextView emailAddress = (TextView) findViewById(R.id.email_address);
        User user = SessionContext.getCurrentUser();
        firstName.setText("Welcome " + user.getFirstName() + user.getLastName());
        //emailAddress.setText(user.getEmail());

        showOpenTicketList = (Button) findViewById(R.id.showOpenTicketList);
        showOpenTicketList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createOpenLesaTicketListIntent = new Intent(UserActivity.this, OpenLesaTicketList.class);
                startActivity(createOpenLesaTicketListIntent);
            }
        });
        

    }

}
