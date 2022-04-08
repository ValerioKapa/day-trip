package com.example.daytrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonAdd;
    private Button buttonSee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = (Button) findViewById(R.id.button_add);
        buttonSee = (Button) findViewById(R.id.button_see);

        buttonSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_see();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_add();
            }
        });
    }

    public void openActivity_see(){
        Intent intent = new Intent(this, activity_see.class);
        startActivity(intent);
    }

    public void openActivity_add(){
        Intent intent = new Intent(this, activity_add.class);
        startActivity(intent);
    }
}