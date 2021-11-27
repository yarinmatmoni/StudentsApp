package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

import java.util.List;

public class EditStudentActivity extends AppCompatActivity {
    Button cancelEdit_btn,deleteEdit_btn,saveStudent_btn;
    EditText nameStudentET,idStudentET,phoneStudentET,addressStudentET;
    CheckBox cbStudent;
    List<Student> data;
    int posStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        data = Model.instance.getAllStudents();
        cancelEdit_btn = findViewById(R.id.editStudent_can_btn);
        deleteEdit_btn = findViewById(R.id.editStudent_del_btn);
        saveStudent_btn = findViewById(R.id.editStudent_save_btn);
        nameStudentET = findViewById(R.id.editStudent_name_pt);
        idStudentET = findViewById(R.id.editStudent_id_pt);
        phoneStudentET = findViewById(R.id.editStudent_phone_pt);
        addressStudentET = findViewById(R.id.editStudent_address_pt);
        cbStudent = findViewById(R.id.editStudent_cb);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            posStudent = extras.getInt("posS");
            nameStudentET.setText(data.get(posStudent).getName());
            idStudentET.setText(data.get(posStudent).getId());
            phoneStudentET.setText(data.get(posStudent).getPhone());
            addressStudentET.setText(data.get(posStudent).getAddress());
            cbStudent.setChecked(data.get(posStudent).isCheck());
        }

        saveStudent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.instance.getStudent(posStudent).setName(nameStudentET.getText().toString());
                Model.instance.getStudent(posStudent).setId(idStudentET.getText().toString());
                Model.instance.getStudent(posStudent).setPhone(phoneStudentET.getText().toString());
                Model.instance.getStudent(posStudent).setAddress(addressStudentET.getText().toString());
                Model.instance.getStudent(posStudent).setCheck(cbStudent.isChecked());
                finish();
            }
        });

        deleteEdit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posStudent == data.size()-1){
                    Log.d("TAG","Last item");
                }
                else {
                    Model.instance.deleteStudent(posStudent);
                    finish();
                }
            }
        });

        cancelEdit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}