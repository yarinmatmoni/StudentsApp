package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

import java.util.List;

public class NewStudentActivity extends AppCompatActivity {
    Button cancel_btn;
    Button saveStudent_btn;
    EditText nameStudent,idStudent,phoneStudent,addressStudent;
    CheckBox cbStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        cancel_btn=findViewById(R.id.newStudent_can_btn);
        saveStudent_btn=findViewById(R.id.newStudent_save_btn);

        nameStudent = findViewById(R.id.newStudent_name_pt);
        idStudent = findViewById(R.id.newStudent_id_pt);
        phoneStudent = findViewById(R.id.newStudent_phone_pt);
        addressStudent = findViewById(R.id.newStudent_address_pt);
        cbStudent = findViewById(R.id.newStudent_cb);


        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}