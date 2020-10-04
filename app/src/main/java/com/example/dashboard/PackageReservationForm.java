package com.example.dashboard;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class PackageReservationForm extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Package aPackage;
    EditText aa,bb,dd,cc;
    int ccc;
    TextView start_date;
    TextView end_date;
    DatePickerDialog.OnDateSetListener sDate;
    DatePickerDialog.OnDateSetListener eDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_package_reservation_form);

        start_date = findViewById(R.id.start_date);
        end_date = findViewById(R.id.end_date);

        start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PackageReservationForm.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        sDate,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        end_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PackageReservationForm.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        eDate,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        sDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                start_date.setText(date);
            }
        };

        eDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                end_date.setText(date);
            }
        };




        start_date = (TextView) findViewById(R.id.start_date);
        end_date = (TextView) findViewById(R.id.end_date);

       aPackage = (Package) getIntent().getSerializableExtra("Package");
        aa = findViewById(R.id.editTextTextPersonName);
        bb = findViewById(R.id.editTextTextPersonName2);
        dd = findViewById(R.id.editTextTextPersonName3);
        cc = findViewById(R.id.editTextTextPersonName4);

        aa.setText(aPackage.getActivityName());
        bb.setText(aPackage.getTourGuideName());
        cc.setText(aPackage.getAmount());

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

            dbref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){

                        num = snapshot.getChildrenCount();

                        Log.d("--number of children--",String.valueOf(num));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

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
}