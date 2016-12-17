package com.example.brian.monthlybudget;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/* This class displays the user registration view and allows the user to create a new
*  account with email and password. The account is registered in firebase and only
*  allows the user to create one account per email. Once the registration is successfully
*  completed, the app displays the login view.
* */
public class UserRegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    // Create variables for input text fields and the sign up button
    private EditText etEmailRegister;
    private EditText etPasswordRegister;
    private Button buttonRegister;

    // Create a variable for firebase authentication
    private FirebaseAuth firebaseAuth;

    // Create variable for progress dialog
    private ProgressDialog userRegistrationProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        // Assign private variables to edit text fields and the sign up button
        etEmailRegister = (EditText) findViewById(R.id.etEmailRegister);
        etPasswordRegister = (EditText) findViewById(R.id.etPasswordRegister);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        // Create a progress dialog
        userRegistrationProgressDialog = new ProgressDialog(this);

        // Initializes the firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        // Set onClick listener to the buttonRegister (Sign Up) button
        buttonRegister.setOnClickListener(this);
    }



    // This method signs up a new user with email and password.
    private void registerUser() {
        // Convert input values into String and assign the values to string variables
        String email = etEmailRegister.getText().toString();
        String password = etPasswordRegister.getText().toString();

        // Stops the execution if one or more edit text fields are left empty when the
        // sign up button is clicked.
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter an email address", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Set a message to the progress dialog
        userRegistrationProgressDialog.setMessage("Registering user...");
        // Progress dialog displays when the method is executing
        userRegistrationProgressDialog.show();

        // Creates a new user using email and password
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Display a message when the user registration was successful.
                    Toast.makeText(UserRegistrationActivity.this,
                            "User registration successul", Toast.LENGTH_SHORT).show();
                    // Create intent to open the main activity
                    Intent goToLoginViewIntent = new Intent(UserRegistrationActivity.this, MainActivity.class);
                    // Opens the main activity (login view) when the register is successful
                    UserRegistrationActivity.this.startActivity(goToLoginViewIntent);
                } else {
                    // Display a message when the user registration was unsuccessful
                    Toast.makeText(UserRegistrationActivity.this,
                            "Cannot register because this email is already registered. " +
                                    "Please try again with a different email.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    // OnClick listener for the buttonRegister (Sign Up) button
    @Override
    public void onClick(View view) {
        if (view == buttonRegister) {
            // Call to the registerUser method
            registerUser();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
