package com.example.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateFeedback extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    EditText feedbackupdate;
    Button btnupdate, btndelete;
    DatabaseReference dbref;
    FeedbackInsert feedback;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_update_feedback);

        /*--------Hooks----------*/

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        /*--------Tool Bar----------*/

        setSupportActionBar(toolbar);

        /*--------Navigation Drawer Menu----------*/

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_fc);

        feedbackupdate = findViewById(R.id.textView7);

        btnupdate = findViewById(R.id.button4);
        btndelete = findViewById(R.id.button6);

        feedback = new FeedbackInsert();

        dbref = FirebaseDatabase.getInstance().getReference().child("Feedback");

        FeedbackInsert feedbackInsert = (FeedbackInsert) getIntent().getSerializableExtra("feedback");

        feedbackupdate.setText(feedbackInsert.getFeedback());

        btndelete.setOnClickListener((view) -> {
            dbref.child(feedback.getKey()).removeValue();
        });

        btndelete.setOnClickListener((view)->{
            dbref.child(feedback.getKey()).child("feedback").setValue(feedbackupdate.getText().toString().trim());
        });
    };

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_logout:
                Intent intent = new Intent(UpdateFeedback.this, Login.class);
                startActivity(intent);
                break;
            /*case R.id.nav_logout;
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                break;
            case R.id.nav_logout;
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                break;
            case R.id.nav_logout;
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                break;
            case R.id.nav_logout;
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                break;*/

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}









