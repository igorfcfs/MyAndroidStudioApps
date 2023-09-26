package com.example.uibasicssection2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtTxtName;
    private TextView txtHello;

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnHello:
//                System.out.println("Hello");
//                Toast.makeText(this, "Hello Button Clicked", Toast.LENGTH_SHORT).show();
                txtHello.setText("Hello " + edtTxtName.getText().toString());
                break;
            case R.id.edtTxtName:
                Toast.makeText(this, "Attempting to type something", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        /*btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Hello")
            }
        });*/
        //btnHello.setOnClickListener(view -> System.out.println("Hello"));
        btnHello.setOnClickListener(this);

        btnHello.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Long Press", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtName.setOnClickListener(this);
        txtHello = findViewById(R.id.txtHello);
    }
}