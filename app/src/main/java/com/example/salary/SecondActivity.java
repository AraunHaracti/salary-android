package com.example.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.texts);

        Bundle arguments = getIntent().getExtras();

        Gson gson = new Gson();

        User user;
        if(arguments!=null){
                user = gson.fromJson(arguments.getString(User.class.getSimpleName()), User.class);

            textView.setText(String.format("Name: %s \nSurname: %s \nAge: %s \nSalary: %s",
                    user.name, user.surname, user.age, user.salary));
        }
    }

    public void onClickBack(View view) {
        onBackPressed();
    }
}