package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

import java.util.List;

public class StudentDetailsActivity extends AppCompatActivity {
    List<Student> data;
    Button backToList_btn,editStudent_btn;
    TextView idStudent_d,nameStudent_d,phoneStudent_d,addressStudent_d;
    CheckBox cbStudent_d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        data = Model.instance.getAllStudents();
        Intent intent_edit = new Intent(this,EditStudentActivity.class);

        backToList_btn=findViewById(R.id.studentDetails_back_btn);
        editStudent_btn=findViewById(R.id.studentDetails_edit_btn);

        idStudent_d = findViewById(R.id.studentDatails_id_tv);
        nameStudent_d = findViewById(R.id.studentDatails_name_tv);
        phoneStudent_d = findViewById(R.id.studentDatails_phone_tv);
        addressStudent_d = findViewById(R.id.studentDatails_address_tv);
        cbStudent_d = findViewById(R.id.studentDetails_cb);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int posStudent = extras.getInt("posS");
            idStudent_d.setText("ID : " + data.get(posStudent).getId());
            nameStudent_d.setText("Name : " + data.get(posStudent).getName());
            phoneStudent_d.setText("Phone : " + data.get(posStudent).getPhone());
            addressStudent_d.setText("Address : " + data.get(posStudent).getAddress());
            cbStudent_d.setChecked(data.get(posStudent).isCheck());
        }

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