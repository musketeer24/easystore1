package com.example.hp.easystore.LoginAndRegister;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.hp.easystore.R;
import com.example.hp.easystore.activity.MainActivity;
import com.example.hp.easystore.activity.NavigationDrawerHome;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {


    private AutoCompleteTextView mUsernameView;
    private EditText mPasswordView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        // Set up the login form.

        mUsernameView = (AutoCompleteTextView) findViewById(R.id.etUsername);
        mPasswordView = (EditText) findViewById(R.id.etPassword);

        final TextView registerlink = (TextView)findViewById(R.id.registerhere);

        registerlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });


        Button mUsernamelogin = (Button) findViewById(R.id.bLogin);
        mUsernamelogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsernameView.getText().toString();
                String pwd = mPasswordView.getText().toString();
                if (username.equalsIgnoreCase("easystore") && pwd.equalsIgnoreCase("ishangoel")) {

                    //Intent mainintent = new Intent(LoginActivity.this, MainActivity.class);
                    Intent mainintent = new Intent(LoginActivity.this, NavigationDrawerHome.class);
                    startActivity(mainintent);
                    Toast.makeText(getApplicationContext(), "Welcome!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }


            }
        });
        Button skip = (Button)findViewById(R.id.skip);
        skip.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainintent = new Intent(LoginActivity.this, NavigationDrawerHome.class);
                startActivity(mainintent);
            }
        });

    }





}
