package com.example.tripsandtramps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class finalReservationpage extends AppCompatActivity {

    RecyclerView RC;
    FirebaseDatabase fbdb;
    DatabaseReference dbreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_reservationpage);

        RC = findViewById(R.id.recycler_view);
        RC.setHasFixedSize(true);
        RC.setLayoutManager(new LinearLayoutManager(this));

        dbreff = fbdb.getInstance().getReference().child("Vehicle_Reservation").child(User.getUsername());

    }

    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Vehicle_Reservation> options = new FirebaseRecyclerOptions.Builder<Vehicle_Reservation>().setQuery(dbreff,Vehicle_Reservation.class).build();

        FirebaseRecyclerAdapter<Vehicle_Reservation,ViewHolderForReservations> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Vehicle_Reservation, ViewHolderForReservations>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolderForReservations holder, int position, @NonNull Vehicle_Reservation model) {

                holder.setdataaa(getApplicationContext(),model);

            }

            @NonNull
            @Override
            public ViewHolderForReservations onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_reservationdetails,parent,false);

                return new ViewHolderForReservations(view);
            }
        };

        firebaseRecyclerAdapter.startListening();
        RC.setAdapter(firebaseRecyclerAdapter);
    }
}