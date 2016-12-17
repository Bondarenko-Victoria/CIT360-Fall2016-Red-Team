package com.example.brian.monthlybudget;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/* This class displays the login view which also contains a sign up link to create a
*  new user account with email and password.
*  The user can login only with a registered account
*  The sign up link opens the user registration view and once the user is successfully
*  registered, the app displays the login view again
*  */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Create variables for input text fields, login button and sign up link
    private EditText etEmail;
    private EditText etPassword;
    private Button buttonLogin;
    private TextView signUpLink;

    // Create a variable for firebase authentication
    private FirebaseAuth firebaseAuth;

    // Create variable for progress dialog
    private ProgressDialog userLoginProgressDialog;

    // The onCreate method is called when the activity is created and it contains
    // the methods to create views and everything else
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializes the User Interface
        etEmail = (EditText) findViewById(R.id.etEmailRegister);
        etPassword = (EditText) findViewById(R.id.etPasswordRegister);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        signUpLink = (TextView) findViewById(R.id.tvRegister);

        // Initializes the firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), AppMenuActivity.class));
        }

        // Create a progress dialog
        userLoginProgressDialog = new ProgressDialog(this);

        // Set onClick listener to the login button
        buttonLogin.setOnClickListener(this);

        // Set onClick listener to the sign up link
        signUpLink.setOnClickListener(this);
    }

    // Logs the user into firebase using an existing account.
    private void userLogin() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        // Stops the execution if one or more edit text fields are left empty when the
        // login button is clicked.
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter an email address", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show();
            return;
        }
        // Set a message to the progress dialog
        userLoginProgressDialog.setMessage("Logging user...");
        // Progress dialog displays when the method is executing
        userLoginProgressDialog.show();

        // Sign into firebase database with user input email and password
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // Dismisses the progress dialog
                userLoginProgressDialog.dismiss();
                if (task.isSuccessful()) {
//                    Intent intent = new Intent(getApplicationContext(), AppMenuActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    // The AppMenuActivity will start so that the user will see it if the login
                    // was successful.
                    startActivity(new Intent(getApplicationContext(), AppMenuActivity.class));
                } else {
                }
            }
        });
    }

    // OnClick listener for the login button and the sign up link
    @Override
    public void onClick(View view) {
        if (view == buttonLogin) {
            // Call to the userLogin method when the login button is clicked
            userLogin();
        }
        if (view == signUpLink) {
            // Note: An intent is a messaging object that can be used to request an action to another
            // app component

            // Creates a new intent that opens the register activity when the sign up link is clicked
            startActivity(new Intent(this, UserRegistrationActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
