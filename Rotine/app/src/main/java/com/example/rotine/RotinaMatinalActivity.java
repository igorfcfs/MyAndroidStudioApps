package com.example.rotine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RotinaMatinalActivity extends AppCompatActivity {

    private RecyclerView rotinasMatinaisRecView;
    private FloatingActionButton fabRotinaMatinal;
    public static ArrayList<Rotina> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotina_matinal);

        //Falta add uma dependencia do CardView para funcionar
        rotinasMatinaisRecView = findViewById(R.id.rotinasMatinaisRecView);
        fabRotinaMatinal = findViewById(R.id.fabRotinaMatinal);


//        contacts.add(new Rotina("Acordar", "7:00"/*, "https://www.comboinfinito.com.br/principal/wp-content/uploads/2022/03/barbie-marot-robbie.jpg"*/));

        RotinasMatinaisRecViewAdapter adapter = new RotinasMatinaisRecViewAdapter(this);
        adapter.setContacts(contacts);

        rotinasMatinaisRecView.setAdapter(adapter);

//        rotinasMatinaisRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rotinasMatinaisRecView.setLayoutManager(new GridLayoutManager(this, 2));
        rotinasMatinaisRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onFabRotinaMatinalClick(View view){
        Intent intent = new Intent(RotinaMatinalActivity.this, AddNovaRotinaActivity.class);
        startActivity(intent);

        //os elementos abaixo nao estao presentes no que eu estou inflando no metodo onCreate no statment em que chamo a funcao setContentView passando como parametro o activiti_rotina_matinal
//        EditText nomeRotina = findViewById(R.id.edtTxtNomeNovaRotina);
//        EditText horarioRotina = findViewById(R.id.edtTxtHorarioRotina);
//        Button btnAddNovaRotina = findViewById(R.id.btnAddNovaRotina);
//        btnAddNovaRotina.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                contacts.add(new Rotina(nomeRotina.getText().toString(), horarioRotina.getText().toString()/*, "https://www.comboinfinito.com.br/principal/wp-content/uploads/2022/03/barbie-marot-robbie.jpg"*/));
//            }
//        });
    }

}