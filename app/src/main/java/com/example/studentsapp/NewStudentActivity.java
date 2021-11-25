package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewStudentActivity extends AppCompatActivity {
    Button cancel_btn;
    Button saveStudent_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        cancel_btn=findViewById(R.id.newStudent_can_btn);
        saveStudent_btn=findViewById(R.id.newStudent_save_btn);

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}