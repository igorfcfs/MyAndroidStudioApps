package com.example.somadedoisnumeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText editNumero1;
    private EditText editNumero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
        editNumero1 = findViewById(R.id.editNumero1);
        editNumero2 = findViewById(R.id.editNumero2);
    }

    public void soma(View view){
        int n1 = Integer.parseInt(editNumero1.getText().toString());
        int n2 = Integer.parseInt(editNumero2.getText().toString());
        int result = n1 + n2;
        textResultado.setText(Integer.toString(result));
    }
}