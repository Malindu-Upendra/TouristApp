package com.example.dashboard;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Room_Confirm_2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "Room_Confirm_2";

    TextView checkIn;
    TextView checkOut;
    DatePickerDialog.OnDateSetListener ciDate;
    DatePickerDialog.OnDateSetListener coDate;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    RoomReservation roomReservation;
    Room roomm;
    Button button;
    Date fromm,too;
    int diff;
    double amount;
    DatabaseReference dbreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_room__confirm_2);

        roomReservation = (RoomReservation) getIntent().getSerializableExtra("RoomReservation");
        roomm = (Room) getIntent().getSerializableExtra("roomm");

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

        navigationView.setCheckedItem(R.id.nav_roomreserve);

        checkIn = (TextView) findViewById(R.id.dateIn);
        checkOut = (TextView) findViewById(R.id.dateOut);

        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Room_Confirm_2.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        ciDate,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Room_Confirm_2.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        coDate,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        ciDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                checkIn.setText(date);
            }
        };

        coDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                checkOut.setText(date);
            }
        };


        button = findViewById(R.id.button);

        button.setOnClickListener((view)->{

            checkIn = findViewById(R.id.dateIn);;
            checkOut = findViewById(R.id.dateOut);;

            try {
                fromm = new SimpleDateFormat("mm/dd/yyyy").parse(checkIn.getText().toString());
                too = new SimpleDateFormat("mm/dd/yyyy").parse(checkOut.getText().toString());
            } catch (ParseException e) {
                Toast.makeText(Room_Confirm_2.this,"Invalid Type",Toast.LENGTH_SHORT).show();
            }

            diff = too.getDate()-fromm.getDate();
            amount = diff * Double.parseDouble(roomm.getAmount()) * roomReservation.getRooms();

            roomReservation.setAmount(amount);
            roomReservation.setFrom(fromm);
            roomReservation.setTo(too);

            dbreff = FirebaseDatabase.getInstance().getReference().child("Room_Reservation");
            String temp = dbreff.push().getKey();
            roomReservation.setReservationid(temp);
            dbreff.child(roomReservation.getReservationid()).setValue(roomReservation);

        });

    }

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
            case R.id.nav_roomreserve:
                break;
            case R.id.nav_logout:
                Intent intent = new Intent(Room_Confirm_2.this, Login.class);
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