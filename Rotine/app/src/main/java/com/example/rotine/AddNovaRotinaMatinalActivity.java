package com.example.rotine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNovaRotinaMatinalActivity extends AppCompatActivity {


    //Adicionar checkboxes atraves do botao fab
//    private Button btnAddNovaRotina;
////    private Button buttonCreateCheckbox;
//    private LinearLayout checkboxContainer;
//
//    private EditText edtTxtNomeNovaRotina;

    private EditText nomeRotina;
    private EditText horarioRotina;
    private Button btnAddNovaRotina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nova_rotina_matinal);

        nomeRotina = findViewById(R.id.edtTxtNomeNovaRotinaMatinal);
        horarioRotina = findViewById(R.id.edtTxtHorarioRotinaMatinal);
        btnAddNovaRotina = findViewById(R.id.btnAddNovaRotinaMatinal);

        btnAddNovaRotina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNovaRotinaMatinalActivity.this, RotinaMatinalActivity.class);
                startActivity(intent);
                RotinaMatinalActivity.contacts.add(new Rotina(nomeRotina.getText().toString(), horarioRotina.getText().toString()/*, "https://www.comboinfinito.com.br/principal/wp-content/uploads/2022/03/barbie-marot-robbie.jpg"*/));
            }
        });

//        edtTxtNomeNovaRotina = findViewById(R.id.edtTxtNomeNovaRotina);
//        checkboxContainer = findViewById(R.id.checkboxContainer);
//
//        btnAddNovaRotina = findViewById(R.id.btnAddNovaRotina);
//        btnAddNovaRotina.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Criar um novo checkbox
//                CheckBox newCheckbox = new CheckBox(AddNovaRotinaActivity.this);
//                newCheckbox.setText(edtTxtNomeNovaRotina.getText().toString());
//
//                // Adicionar o checkbox ao layout
//                checkboxContainer.addView(newCheckbox);
//
//                Intent intent = new Intent(AddNovaRotinaActivity.this, NavigationDrawerActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}