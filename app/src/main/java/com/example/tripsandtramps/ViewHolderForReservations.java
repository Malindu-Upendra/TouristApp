package com.example.tripsandtramps;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewHolderForReservations extends RecyclerView.ViewHolder {

    DatabaseReference dbref;

    public ViewHolderForReservations(@NonNull View itemView) {
        super(itemView);
    }

    public void setdataaa(Context context, Vehicle_Reservation vr)
    {

        TextView Vnumber,Vbrand,Vtype,numofseats,amount,fromm,too;
        Button delete,update ;

        Vnumber = itemView.findViewById(R.id.Vnum);
        Vbrand = itemView.findViewById(R.id.Vbrand);
        Vtype = itemView.findViewById(R.id.Vtype);
        numofseats = itemView.findViewById(R.id.numofseats);
        amount = itemView.findViewById(R.id.amount);
        fromm = itemView.findViewById(R.id.fromm);
        too = itemView.findViewById(R.id.too);
        delete = itemView.findViewById(R.id.delete);
        update = itemView.findViewById(R.id.update);

        Vnumber.setText(vr.getVehicleNumber());
        Vbrand.setText(vr.getVehicleBrand());
        Vtype.setText(vr.getVehicleType());
       numofseats.setText(Integer.toString(vr.getNumOfSeats()));
       amount.setText(Double.toString(vr.getFinalAmount()));
        fromm.setText(String.valueOf(vr.getFromm()));
        too.setText(String.valueOf(vr.getToo()));

        delete.setOnClickListener((view)->{

            dbref = FirebaseDatabase.getInstance().getReference().child("Vehicle_Reservation").child(User.getUsername());
            dbref.child(vr.getKey()).removeValue();

        });

        update.setOnClickListener((view)->{



        });


    }
}
