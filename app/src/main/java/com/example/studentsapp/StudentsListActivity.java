package com.example.studentsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

import java.util.List;

public class StudentsListActivity extends AppCompatActivity {
    RecyclerView studentsList;
    List<Student> data;
    Button newStudent_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        data = Model.instance.getAllStudents();
        Intent intent_details = new Intent(this ,StudentDetailsActivity.class);
        Intent intent_add = new Intent(this ,NewStudentActivity.class);

        newStudent_btn=findViewById(R.id.studentList_addNew_btn);
        studentsList = findViewById(R.id.studentslist_list_rv);
        studentsList.setHasFixedSize(true);
        studentsList.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter= new MyAdapter();
        studentsList.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("TAG" ,"row number :"+position);
                intent_details.putExtra("posS",position);
                startActivity(intent_details);
            }
        });
        newStudent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_add);
            }
        });
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameStudentTv;
        TextView idStudentTv;
        CheckBox cb;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameStudentTv = itemView.findViewById(R.id.studentrow_name);
            idStudentTv= itemView.findViewById(R.id.studentrow_id);
            cb = itemView.findViewById(R.id.studentrosw_cb);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=getAdapterPosition();
                    listener.onItemClick(pos);
                }
            });
            cb.setOnClickListener(new View.OnClickListener() { //???????????????????????
                @Override
                public void onClick(View v) {
                    int pos=getAdapterPosition();
                    Student s = data.get(pos);
                    s.setCheck(cb.isChecked());
                }
            });
        }
    }

    interface OnItemClickListener {
        void onItemClick(int position);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        OnItemClickListener listener;
        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener=listener;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row , parent,false);
            MyViewHolder holder= new MyViewHolder(view ,listener);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Student student = data.get(position);
            holder.nameStudentTv.setText(student.getName());
            holder.idStudentTv.setText(student.getId());
            holder.cb.setChecked(student.isCheck());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}