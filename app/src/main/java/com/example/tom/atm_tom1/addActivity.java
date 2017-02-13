package com.example.tom.atm_tom1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class addActivity extends AppCompatActivity {
    private EditText edDate;
    private EditText edInfo;
    private EditText edAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edDate = (EditText)findViewById(R.id.ed_date);
        edInfo = (EditText)findViewById(R.id.ed_info);
        edAmount = (EditText)findViewById(R.id.ed_amount);
    }
}
