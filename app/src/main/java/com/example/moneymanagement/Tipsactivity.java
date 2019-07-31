package com.example.moneymanagement;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

public class Tipsactivity extends AppCompatActivity {
    private ListView lvTips;
    private String[] listData;
    private ArrayAdapter<String> adapter;
    private Context context;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipsactivity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tipsactivity.this, Home.class);
                startActivity(i);
                finish();
            }
        });
        context = this;
        connectView();
        loadData();
    }


    private void connectView() {
        lvTips = (ListView) findViewById(R.id.lvtips);
    }

    private void loadData() {
        // get data (string array) from xml file
        listData = context.getResources().getStringArray(R.array.tut_android);

        // create adapter with listData and layout item
        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listData);
        lvTips.setAdapter(adapter);
    }

}
