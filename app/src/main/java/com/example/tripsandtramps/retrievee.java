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
import com.google.firebase.database.Query;

public class retrievee extends AppCompatActivity {

    RecyclerView RC;
    FirebaseDatabase fbdb;
    DatabaseReference dbreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrievee);

        RC = findViewById(R.id.recycler_view);
        RC.setHasFixedSize(true);
        RC.setLayoutManager(new LinearLayoutManager(this));

        dbreff = fbdb.getInstance().getReference().child("Vehicle");

    }

    protected void onStart() {
        super.onStart();

        //Query setquery = dbreff.orderByChild("vehicleType").equalTo("CAR");

        FirebaseRecyclerOptions<Vehicle> options = new FirebaseRecyclerOptions.Builder<Vehicle>().setQuery(/*setquery*/dbreff,Vehicle.class).build();

          FirebaseRecyclerAdapter<Vehicle,ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Vehicle, ViewHolder>(options) {

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Vehicle model) {

                holder.setdataaa(getApplicationContext(),model);

            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

                return new ViewHolder(view);
            }
          };

        firebaseRecyclerAdapter.startListening();
        RC.setAdapter(firebaseRecyclerAdapter);
    }
}