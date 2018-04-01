package com.varunarl.myapplication.ui;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.varunarl.myapplication.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);

            Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmailView.getText().toString();
                String password = mPasswordView.getText().toString();
                if(email.equals("ctse@sliit.com") && password.equals("SLIIT")){
                    alertMessage("Login Successfully !");
                    loginPage();
                } else {
                    alertMessage("Login Fail !");
                }

            }
        });

    }

    /**
     * Alert method
     * @param message
     */
    public void alertMessage(String message){
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(LoginActivity.this);
        aBuilder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alert = aBuilder.create();
        alert.setTitle("Pin Insert Login");
        alert.show();
    }

    /**
     * redirecting to the another page
     */
    public void loginPage(){
        Intent regView = new Intent(this, RegisterActivity.class);
        startActivity(regView);
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
    }

}

