package com.example.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickSend(View view){

        String name;
        String surname;
        int age;
        float salary;

        EditText nameText = findViewById(R.id.name);
        EditText surnameText = findViewById(R.id.surname);
        EditText ageText = findViewById(R.id.age);
        EditText salaryText = findViewById(R.id.salary);

        try {
            name = nameText.getText().toString();
            surname = surnameText.getText().toString();
            age = Integer.parseInt(ageText.getText().toString());
            salary = Float.parseFloat(salaryText.getText().toString());
        } catch (Exception ex){
            Log.e("MainActivityOnClickSendConvert", ex.getMessage());
            Toast.makeText(this, "Все значения должны быть заполнены", Toast.LENGTH_SHORT).show();
            return;
        }

        Gson gson = new Gson();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(User.class.getSimpleName(), gson.toJson(new User(name, surname, age, salary)));
        startActivity(intent);
    }

}