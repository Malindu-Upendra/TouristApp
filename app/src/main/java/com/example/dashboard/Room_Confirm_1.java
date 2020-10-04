package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Room_Confirm_1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Spinner NoOfAdults;
    Spinner NoOfKids;
    Spinner NoOfRooms;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_confirm_1);

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

        NoOfAdults = findViewById(R.id.NoOfAdults);
        NoOfKids = findViewById(R.id.NoOfKids);
        NoOfRooms = findViewById(R.id.NoOfRooms);

        String[] adults = getResources().getStringArray(R.array.Number);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,adults);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NoOfAdults.setAdapter(adapter);

        String[] kids = getResources().getStringArray(R.array.Number);
        ArrayAdapter adapter1 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,kids);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NoOfKids.setAdapter(adapter1);

        String[] room = getResources().getStringArray(R.array.Number);
        ArrayAdapter adapter2 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,room);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NoOfRooms.setAdapter(adapter2);

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
                Intent intent = new Intent(Room_Confirm_1.this, Login.class);
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




