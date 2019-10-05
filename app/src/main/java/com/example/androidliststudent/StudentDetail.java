package com.example.androidliststudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentDetail extends AppCompatActivity {

    TextView tvName, tvAge, tvGalaxy;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        showInfoStudent();
    }

    //    Display the attribute value of the object when I click to view the information details of object.
    void showInfoStudent(){
        tvName = findViewById(R.id.tv_name);
        tvAge = findViewById(R.id.tv_age);
        tvGalaxy = findViewById(R.id.tv_galaxy);
        back = findViewById(R.id.btn_back);

        final Intent homeIntent = this.getIntent();
        String name = homeIntent.getStringExtra("name");
        String age = homeIntent.getStringExtra("age");
        String galaxy = homeIntent.getStringExtra("galaxy");

        tvName.setText(name);
        tvAge.setText(age);
        tvGalaxy.setText(galaxy);

        //  Return home page when I click button BACK
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK, homeIntent);
                finish();
            }
        });
    }
}
