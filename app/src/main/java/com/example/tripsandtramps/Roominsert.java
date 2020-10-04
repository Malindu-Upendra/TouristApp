package com.example.tripsandtramps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Roominsert extends AppCompatActivity {

    EditText roomtype,rooms,amt;
    Button btnIns;
    DatabaseReference dbref;
    RoomType rm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roominsert);

        roomtype = findViewById(R.id.roomtype);
        rooms = findViewById(R.id.rooms);
        amt = findViewById(R.id.amount);

        btnIns = findViewById(R.id.insertrooms);

        btnIns.setOnClickListener((view) -> {

            dbref = FirebaseDatabase.getInstance().getReference().child("Room_types");
            rm = new RoomType();
            rm.setType(roomtype.getText().toString().trim());
            rm.setRooms(Integer.parseInt(rooms.getText().toString().trim()));
            rm.setAmt(Double.parseDouble(amt.getText().toString().trim()));

            dbref.child(rm.getType()).setValue(rm.getRooms(),rm.getAmt());

            Toast.makeText(Roominsert.this,"Data inserted succesfully",Toast.LENGTH_SHORT).show();

        });

    }
}