package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditStudentActivity extends AppCompatActivity {
    Button cancelEdit_btn;
    Button deleteEdit_btn;
    Button saveStudent_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        cancelEdit_btn = findViewById(R.id.editStudent_can_btn);

        cancelEdit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}