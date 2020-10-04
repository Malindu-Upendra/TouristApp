package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class RoomSelection extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Spinner selection;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Spinner spin;
    Button confirmRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_room_selection);

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

        selection = findViewById(R.id.selection);

        String[] roomType = getResources().getStringArray(R.array.room_types);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,roomType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selection.setAdapter(adapter);

        spin = findViewById(R.id.selection);

        confirmRoom = findViewById(R.id.confirmRoom);

        confirmRoom.setOnClickListener((view)->{

            Log.d("Spinner = ",spin.getSelectedItem().toString());
            Intent intent = new Intent(RoomSelection.this,Room_Confirm_1.class);
            intent.putExtra("RoomType", spin.getSelectedItem().toString());
            startActivity(intent);

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
                Intent intent = new Intent(RoomSelection.this, Login.class);
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

