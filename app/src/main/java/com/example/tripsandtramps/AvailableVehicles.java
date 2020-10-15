package com.example.tripsandtramps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AvailableVehicles extends AppCompatActivity {

    Vehicle vehicle;
    TextView tt,ta,nos,amt;
    Button btnconfirm,btnback;
    int diff;
    double amount;
    Date frommm,tooo;
    Vehicle_Reservation vehicle_reservation;
    DatabaseReference dbref;
    User uhg = new User();
    String reservationID;
    long num = 0;

    static final String TAG = "AvailableVehicles";
    TextView mDisplayToo,mDisplayFrom;
    DatePickerDialog.OnDateSetListener onDateSetListenerForFrom,onDateSetListenerForToo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_vehicles);


        vehicle = (Vehicle) getIntent().getSerializableExtra("vehicle");
        tt = findViewById(R.id.vehiclename);
        ta = findViewById(R.id.availability);
        nos = findViewById(R.id.numofseats);
        amt = findViewById(R.id.amount);
        //-----------------------------------------------------------

        mDisplayFrom = findViewById(R.id.fromm);
        mDisplayFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int mon = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AvailableVehicles.this,
                        android.R.style.Theme_Translucent,
                        onDateSetListenerForFrom,
                        year,
                        mon,
                        day
                );

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDisplayToo = findViewById(R.id.too);
        mDisplayToo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int mon = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AvailableVehicles.this,
                        android.R.style.Theme_Translucent,
                        onDateSetListenerForToo,
                        year,
                        mon,
                        day
                );

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        onDateSetListenerForFrom = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mon, int day) {
                mon = mon + 1;
                Log.d(TAG, "onDataSet: yyyy/mm/dd" + year + "/" + mon + "/" + day);

                String date = mon + "/" + day + "/" + year;
                mDisplayFrom.setText(date);

            }
        };

        onDateSetListenerForToo = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mon, int day) {
                mon = mon + 1;
                Log.d(TAG, "onDataSet: yyyy/mm/dd" + year + "/" + mon + "/" + day);

                String date = mon + "/" + day + "/" + year;
                mDisplayToo.setText(date);

            }
        };

        //------------------------------------------------------------

        tt.setText(vehicle.getVehicleBrand());
        ta.setText(vehicle.getAvailability());
        nos.setText(String.valueOf(vehicle.getNumOfSeats()));
        amt.setText(String.valueOf(vehicle.getAmountForADay()));


        btnback = findViewById(R.id.back);
        btnconfirm = findViewById(R.id.confirmm);

        btnback.setOnClickListener((view)->{
            Intent intent = new Intent(AvailableVehicles.this,retrievee.class);
            startActivity(intent);
        });

        btnconfirm.setOnClickListener((view)->{

            mDisplayFrom = findViewById(R.id.fromm);
            mDisplayToo = findViewById(R.id.too);
            try {
                frommm = new SimpleDateFormat("mm/dd/yyyy").parse(mDisplayFrom.getText().toString());
                tooo = new SimpleDateFormat("mm/dd/yyyy").parse(mDisplayToo.getText().toString());
            } catch (ParseException e) {
                Toast.makeText(AvailableVehicles.this,"invalid type",Toast.LENGTH_SHORT).show();
            }
            diff = tooo.getDate()-frommm.getDate();
            amount = diff * vehicle.getAmountForADay();

            vehicle_reservation = new Vehicle_Reservation(vehicle.getVehicleNumber(),vehicle.getVehicleBrand(),vehicle.getVehicleType(),vehicle.getNumOfSeats(),amount,frommm,tooo);

            dbref = FirebaseDatabase.getInstance().getReference().child("Vehicle_Reservation").child(User.getUsername());

            String ReservationID = dbref.push().getKey();
            Log.d("number children outside",ReservationID);
            vehicle_reservation.setKey(ReservationID);
            dbref.child(vehicle_reservation.getKey()).setValue(vehicle_reservation);
            Toast.makeText(AvailableVehicles.this,"Data inserted succesfully",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AvailableVehicles.this,finalReservationpage.class);
            intent.putExtra("vehicle_reservation", vehicle_reservation);
            startActivity(intent);
        });
    }
}