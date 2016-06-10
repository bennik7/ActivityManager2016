package com.activitymanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import co.realtime.messagingandroidchat.R;

public class RegisterLoginActivity extends AppCompatActivity {


    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText firstNameEditText = null;
    private EditText lastNameEditText = null;

    private ImageButton registerButton;
    private TextView loginTextView = null;
    private Button loginButton = null;

    private boolean registerMode = true;



    private Context main = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.register_login_layout);




        this.loginTextView = (TextView)findViewById(R.id.loginTextview);

        //Input fields

        this.emailEditText = (EditText) findViewById(R.id.editText);
        this.passwordEditText = (EditText) findViewById(R.id.editText2);
        this.firstNameEditText = (EditText)findViewById(R.id.editText5);
        this.lastNameEditText = (EditText)findViewById(R.id.editText6);

        //

        this.registerButton = (ImageButton) findViewById(R.id.imageButton);


        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(registerMode)
                    new AddUserToDatabase(main).execute(emailEditText.getText().toString(), passwordEditText.getText().toString(), firstNameEditText.getText().toString(), lastNameEditText.getText().toString());
                else
                    new GetUserFromDatabase(main).execute(emailEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });




        this.loginTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(!registerMode){
                    firstNameEditText.setVisibility(View.VISIBLE);
                    lastNameEditText.setVisibility(View.VISIBLE);
                    registerButton.setBackgroundResource(R.drawable.white_register_button);
                    registerMode = true;
                    loginTextView.setText("Already a member? Login");

                }
                else {
                    firstNameEditText.setVisibility(View.INVISIBLE);
                    lastNameEditText.setVisibility(View.INVISIBLE);
                    registerButton.setBackgroundResource(R.drawable.loginbutton);
                    registerMode = false;
                    loginTextView.setText("Need an account? Sign up");

                }



            }
        });







    }


    public void openActivityOvervivew()
    {
        Intent intent = new Intent(this.main,NavigationDrawer.class);
        startActivity(intent);

    }
}
