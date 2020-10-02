package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
    }

    public void callSingUpScreen(View view){

        Intent intent = new Intent(getApplicationContext(),SignUp.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.create_acc_btn),"transition_signUp");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
            startActivity(intent,options.toBundle());
        }
        else{
            startActivity(intent);
        }
    }

    public void callAccountScreen(View view){

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.login_btn),"transition_accountScreen");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
            startActivity(intent,options.toBundle());
        }
        else{
            startActivity(intent);
        }
    }
}