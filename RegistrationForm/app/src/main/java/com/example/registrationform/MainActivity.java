package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View view){
        EditText edtTxtFirstName = findViewById(R.id.edtTxtFirstName);
        EditText edtTxtLastName = findViewById(R.id.edtTxtLastName);
        EditText edtTxtEmail = findViewById(R.id.edtTxtEmail);
        TextView txtViewFirstName = findViewById(R.id.txtViewFirstName);
        TextView txtViewLastName = findViewById(R.id.txtViewLastName);
        TextView txtViewEmail = findViewById(R.id.txtViewEmail);

        txtViewFirstName.setText(edtTxtFirstName.getText().toString());
        txtViewLastName.setText(edtTxtLastName.getText().toString());
        txtViewEmail.setText(edtTxtEmail.getText().toString());
    }
}