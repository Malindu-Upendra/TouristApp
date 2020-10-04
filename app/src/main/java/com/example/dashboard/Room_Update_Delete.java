package com.example.dashboard;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;


public class Room_Update_Delete extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "Room_Confirm_2";

    Spinner NoAdults;
    Spinner NoKids;
    Spinner NoRooms;
    TextView checkI;
    TextView checkO;
    DatePickerDialog.OnDateSetListener IDate;
    DatePickerDialog.OnDateSetListener ODate;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room__update__delete);

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

        NoAdults = findViewById(R.id.NoAdults);
        NoKids = findViewById(R.id.NoKids);
        NoRooms = findViewById(R.id.NoRooms);
        checkI = (TextView) findViewById(R.id.dateI);
        checkO = (TextView) findViewById(R.id.dateO);

        String[] adult1 = getResources().getStringArray(R.array.Number);
        ArrayAdapter adapter5 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,adult1);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NoAdults.setAdapter(adapter5);

        String[] kids1 = getResources().getStringArray(R.array.Number);
        ArrayAdapter adapter3 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,kids1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NoKids.setAdapter(adapter3);

        String[] room1 = getResources().getStringArray(R.array.Number);
        ArrayAdapter adapter4 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,room1);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NoRooms.setAdapter(adapter4);

        checkI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Room_Update_Delete.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        IDate,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        checkO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Room_Update_Delete.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        ODate,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        IDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                checkI.setText(date);
            }
        };

        ODate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                checkO.setText(date);
            }
        };
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
                Intent intent = new Intent(Room_Update_Delete.this, Login.class);
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