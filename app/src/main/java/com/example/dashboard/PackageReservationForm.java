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


    }
}