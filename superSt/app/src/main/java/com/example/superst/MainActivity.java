package com.example.superst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = findViewById(R.id.ed1);
        Button next =findViewById(R.id.button);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name =name.getText().toString();


                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", Name);

                startActivity(intent);
            }
        });








    }
}