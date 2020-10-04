package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPackages extends AppCompatActivity {

        Button add_package;
        EditText activityName,tourGuideName,amount,location;
        DatabaseReference dbref;
        Package aPackage;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_packages);

            activityName = findViewById(R.id.activity_name);
            tourGuideName = findViewById(R.id.tourguide_name);
            amount = findViewById(R.id.amount);
            location = findViewById(R.id.location);

            add_package = findViewById(R.id.add_package);


            add_package.setOnClickListener((view)->{

                dbref = FirebaseDatabase.getInstance().getReference().child("Package");

                aPackage = new Package();
                /*int numofseat = Integer.parseInt(numOfSeats.getText().toString().trim());*/
                int amountt = Integer.parseInt(amount.getText().toString().trim());
                aPackage.setActivityName(activityName.getText().toString().trim());
                aPackage.setTourGuideName(tourGuideName.getText().toString().trim());
                aPackage.setAmount(amountt);
                aPackage.setLocation(location.getText().toString().trim());
                dbref.push().setValue(aPackage);
                Toast.makeText(AddPackages.this,"Data inserted succesfully",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AddPackages.this, PackageReservation.class);
                startActivity(intent);
            });
        }

    }