package com.example.tripsandtramps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btnIns,btnUpd,btnDel,btnRet;
    EditText vehicleNumber,vehicleBrand,vehicleType,numOfSeats,Availability,amountForADay;
    DatabaseReference dbref;
    Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vehicleNumber = findViewById(R.id.inputVN);
        vehicleBrand = findViewById(R.id.inputVB);
        vehicleType = findViewById(R.id.inputVtype);
        Availability = findViewById(R.id.inputAvaila);
        numOfSeats = findViewById(R.id.inputnumOfseats);
        amountForADay = findViewById(R.id.inputamountForADay);

        btnIns = findViewById(R.id.buttonInsert);
        //btnUpd = findViewById(R.id.buttonUpdate);
        //btnDel = findViewById(R.id.buttonDelete);
        //btnRet = findViewById(R.id.buttonRetrieve);

        btnIns.setOnClickListener((view)->{

            dbref = FirebaseDatabase.getInstance().getReference().child("Vehicle");

            vehicle = new Vehicle();
            int numofseat = Integer.parseInt(numOfSeats.getText().toString().trim());
            double amt = Double.parseDouble(amountForADay.getText().toString().trim());
            vehicle.setVehicleNumber(vehicleNumber.getText().toString().trim());
            vehicle.setVehicleBrand(vehicleBrand.getText().toString().trim());
            vehicle.setVehicleType(vehicleType.getText().toString().trim());
            vehicle.setAvailability(Availability.getText().toString().trim());
            vehicle.setNumOfSeats(numofseat);
            vehicle.setAmountForADay(amt);
            dbref.child(vehicle.getVehicleNumber()).setValue(vehicle);
            Toast.makeText(MainActivity.this,"Data inserted succesfully",Toast.LENGTH_SHORT).show();
        });
    }

}