package com.example.rotine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RotinaNoturnaActivity extends AppCompatActivity {

    private RecyclerView rotinasNoturnasRecView;
    private FloatingActionButton fabRotinaNoturna;
    public static ArrayList<Rotina> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotina_noturna);

        //Falta add uma dependencia do CardView para funcionar
        rotinasNoturnasRecView = findViewById(R.id.rotinasNoturnasRecView);
        fabRotinaNoturna = findViewById(R.id.fabRotinaNoturna);


//        contacts.add(new Rotina("Acordar", "7:00"/*, "https://www.comboinfinito.com.br/principal/wp-content/uploads/2022/03/barbie-marot-robbie.jpg"*/));

        RotinasNoturnasRecViewAdapter adapter = new RotinasNoturnasRecViewAdapter(this);
        adapter.setContacts(contacts);

        rotinasNoturnasRecView.setAdapter(adapter);

//        rotinasMatinaisRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rotinasNoturnasRecView.setLayoutManager(new GridLayoutManager(this, 2));
        rotinasNoturnasRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onFabRotinaNoturnaClick(View view){
        Intent intent = new Intent(RotinaNoturnaActivity.this, AddNovaRotinaNoturnaActivity.class);
        startActivity(intent);
    }
}