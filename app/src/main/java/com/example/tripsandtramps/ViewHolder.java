package com.example.tripsandtramps;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;

public class ViewHolder extends RecyclerView.ViewHolder {

    public ViewHolder(@NonNull View itemView)
    {
        super(itemView);
    }




    public void setdataaa(Context context, Vehicle vehi)
    {

        TextView textview = itemView.findViewById(R.id.vehicleBrand);
        Button btn = itemView.findViewById(R.id.button);

        textview.setText("\t\t\t\t\t" + vehi.getVehicleBrand() + "\t\t\t\t\t\t\t\t\t" + vehi.getAmountForADay());

       btn.setOnClickListener((view)->{
            Intent intent = new Intent(context.getApplicationContext(),AvailableVehicles.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("vehicle", vehi);
            context.startActivity(intent);
        });

    }


    }


