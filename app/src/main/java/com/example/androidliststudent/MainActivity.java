package com.example.androidliststudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentAdapter.OnItemClicked {
    RecyclerView recyclerViewStudents;
    Button btnAdd, btnDelete;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewStudents = findViewById(R.id.recycle_student);
        recyclerViewStudents.setLayoutManager(new LinearLayoutManager(this));

        students = new ArrayList<Student>();
        Student Benzema = new Student("Benzema", 27, "Moon");
        Student John = new Student("John", 29, "Sun");
        Student Bale = new Student("Bale", 31, "Mars");
        Student Ronaldo = new Student("Ronaldo", 34, "Earth");
        Student Kroos = new Student("Kroos", 25, "Mercury");
        students.add(Benzema);
        students.add(John);
        students.add(Bale);
        students.add(Ronaldo);
        students.add(Kroos);

        final  StudentAdapter studentAdapter = new StudentAdapter(this, students);
        recyclerViewStudents.setAdapter(studentAdapter);
        studentAdapter.setOnClick(MainActivity.this);

        btnAdd = findViewById(R.id.btn_add);
        btnDelete =findViewById(R.id.btn_delete);

        // When I click Button ADD to add Object
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.add(new Student("Lee Min Ho", 26, "Comet"));
                studentAdapter.notifyDataSetChanged();
            }
        });

        // When I click Button DELEDE to Revove Object
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.remove(students.size()-1);
                studentAdapter.notifyDataSetChanged();
            }
        });
    }

    // Show result of each item
    public void onItemClick(int position){
        Intent intent = new Intent(this, StudentDetail.class);
        intent.putExtra("name", students.get(position).getName());
        String age = String.valueOf(students.get(position).getAge());
        intent.putExtra("age",age);
        intent.putExtra("galaxy", students.get(position).getGalaxy());
        startActivityForResult(intent,0);


    }
}
