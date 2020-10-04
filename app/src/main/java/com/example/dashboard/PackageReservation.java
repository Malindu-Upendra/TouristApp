package com.example.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PackageReservation extends AppCompatActivity {

    RecyclerView RC;
    FirebaseDatabase fbdb;
    DatabaseReference dbreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_reservation);

        RC = findViewById(R.id.recyclerview_main);
        RC.setHasFixedSize(true);
        RC.setLayoutManager(new LinearLayoutManager(this));

        dbreff = fbdb.getInstance().getReference().child("Package");

    }

    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Package> options =new FirebaseRecyclerOptions.Builder<Package>().setQuery(dbreff,Package.class).build();

        FirebaseRecyclerAdapter<Package,ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Package, ViewHolder>(options) {

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Package model) {


                holder.setdataaa(getApplicationContext(),model);

            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.package_row,parent,false);

                return new ViewHolder(view);
            }
        };

        firebaseRecyclerAdapter.startListening();
        RC.setAdapter(firebaseRecyclerAdapter);
    }
}