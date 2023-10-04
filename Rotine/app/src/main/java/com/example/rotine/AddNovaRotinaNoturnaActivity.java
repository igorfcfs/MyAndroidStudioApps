package com.example.rotine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddNovaRotinaNoturnaActivity extends AppCompatActivity {

    private EditText nomeRotina;
    private EditText horarioRotina;
    private Button btnAddNovaRotina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nova_rotina_noturna);

        nomeRotina = findViewById(R.id.edtTxtNomeNovaRotinaNoturna);
        horarioRotina = findViewById(R.id.edtTxtHorarioRotinaNoturna);
        btnAddNovaRotina = findViewById(R.id.btnAddNovaRotinaNoturna);

        btnAddNovaRotina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNovaRotinaNoturnaActivity.this, RotinaNoturnaActivity.class);
                startActivity(intent);
                RotinaNoturnaActivity.contacts.add(new Rotina(nomeRotina.getText().toString(), horarioRotina.getText().toString()/*, "https://www.comboinfinito.com.br/principal/wp-content/uploads/2022/03/barbie-marot-robbie.jpg"*/));
            }
        });
    }
}