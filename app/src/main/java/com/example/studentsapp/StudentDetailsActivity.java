package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentDetailsActivity extends AppCompatActivity {

    Button backToList_btn;
    Button editStudent_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Intent intent_edit = new Intent(this,EditStudentActivity.class);

        backToList_btn=findViewById(R.id.studentDetails_back_btn);
        editStudent_btn=findViewById(R.id.studentDetails_edit_btn);

        backToList_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editStudent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_edit);
            }
        });
    }
}