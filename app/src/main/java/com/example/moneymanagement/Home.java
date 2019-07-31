package com.example.moneymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    private SessionHandler session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();

        Button logout1Btn = findViewById(R.id.btnLogout1);
        logout1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
                Intent i = new Intent(Home.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
        Button btnchi = findViewById(R.id.btnchi);
        btnchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, ExpenseActivity.class);
                startActivity(i);
                finish();
            }
        });
        Button btnthu = findViewById(R.id.btnthu);
        btnthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, IncomeActivity.class);
                startActivity(i);
                finish();
            }
        });
        Button btnmeo = findViewById(R.id.btnmeo);
            btnmeo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Home.this, Tipsactivity.class);
                    startActivity(i);
                    finish();
                }
            });
        Button btnmanager = findViewById(R.id.btnmanager);
        btnmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Manager.class);
                startActivity(i);
                finish();
            }
        });
        }
        }


