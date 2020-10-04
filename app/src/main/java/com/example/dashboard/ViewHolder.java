package com.example.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
        }



        public void setdataaa(Context context, Package packages)
        {

            TextView textview = itemView.findViewById(R.id.textview_row);
            Button btn = itemView.findViewById(R.id.button);

            textview.setText("\t\t\t\t\t" + packages.getActivityName() );

            btn.setOnClickListener((view)->{
                Intent intent = new Intent(context.getApplicationContext(), PackageReservationForm.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Package", packages);
                context.startActivity(intent);
            });

        }


    }
