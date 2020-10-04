package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateFeedback extends AppCompatActivity {

    EditText feedbackupdate;
    Button btnupdate,btndelete;
    DatabaseReference dbref;
    FeedbackInsert feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_feedback);

        feedbackupdate = findViewById(R.id.textView7);

        btnupdate = findViewById(R.id.button4);
        btndelete = findViewById(R.id.button6);

        feedback = new FeedbackInsert();

        dbref = FirebaseDatabase.getInstance().getReference().child("Feedback");

        FeedbackInsert feedbackInsert  = (FeedbackInsert) getIntent().getSerializableExtra("feedback");

        feedbackupdate.setText(feedbackInsert.getFeedback());
    }
}