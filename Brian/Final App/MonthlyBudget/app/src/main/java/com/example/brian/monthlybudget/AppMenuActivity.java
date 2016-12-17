package com.example.brian.monthlybudget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* This class contains the main menu navigation links: Open budget, create new budget, and log out.
*  The view displays the email of the current user logged in above the main menu navigation links.
*  The open budget link only opens the existing budget in a new view since the user can only create
*  one budget which is editable.
*  The create budget link opens a new budget that allows the user to enter data, calculate the total
*  expenses and the total savings, and it also allows the user to save the budget.
*  The logout link logs the user out
*  */
public class AppMenuActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText emailAccount;
    private TextView openReportLink;
    private TextView createNewReportLink;
    private TextView logoutLink;

    // Create a variable for firebase authentication
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_menu);

        // Initializes the User Interface
        emailAccount = (EditText) findViewById(R.id.etAccount);
        openReportLink = (TextView) findViewById(R.id.tvOpenReport);
        createNewReportLink = (TextView) findViewById(R.id.tvCreateNewReport);
        logoutLink = (TextView) findViewById(R.id.tvLogout);

        // Initializes the firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        // Checks if the current user is already logged in, and if it is true;
        // it opens the app menu activity view
        if (firebaseAuth.getCurrentUser() == null) {
            startActivity(new Intent(this, MainActivity.class));
        }

        // Gets the current user logged in.
        FirebaseUser user = firebaseAuth.getCurrentUser();

        // Displays the email from the current user logged in in the app menu view
        // below the string "Logged in as"
        emailAccount.setText(user.getEmail());

        // Set OnClick listener for each menu link
        openReportLink.setOnClickListener(this);
        createNewReportLink.setOnClickListener(this);
        logoutLink.setOnClickListener(this);

    }

    // OnClick listener for the menu links
    @Override
    public void onClick(View view) {
        if (view == openReportLink) {
            // Opens the open report activity that reads the previously stored
            // data from firebase and the data is displayed
            startActivity(new Intent(this, OpenReportActivity.class));
        }
        if (view == createNewReportLink) {
            // Opens the create report activity when the create new report link is clicked
            startActivity(new Intent(this, CreateReportActivity.class));
        }
        if (view == logoutLink) {
            // Logs the user out of firebase
            firebaseAuth.signOut();
            finish();
            // The app displays the login view after the user is logged out.
            startActivity(new Intent(this, MainActivity.class));
        }else {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


}
