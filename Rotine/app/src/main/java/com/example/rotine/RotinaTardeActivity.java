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

public class RotinaTardeActivity extends AppCompatActivity {

    private RecyclerView rotinasTardesRecView;
    private FloatingActionButton fabRotinaTarde;
    public static ArrayList<Rotina> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotina_tarde);

        //Falta add uma dependencia do CardView para funcionar
        rotinasTardesRecView = findViewById(R.id.rotinasTardesRecView);
        fabRotinaTarde = findViewById(R.id.fabRotinaTarde);


//        contacts.add(new Rotina("Acordar", "7:00"/*, "https://www.comboinfinito.com.br/principal/wp-content/uploads/2022/03/barbie-marot-robbie.jpg"*/));

        RotinasTardesRecViewAdapter adapter = new RotinasTardesRecViewAdapter(this);
        adapter.setContacts(contacts);

        rotinasTardesRecView.setAdapter(adapter);

//        rotinasMatinaisRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rotinasTardesRecView.setLayoutManager(new GridLayoutManager(this, 2));
        rotinasTardesRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onFabRotinaTardeClick(View view){
        Intent intent = new Intent(RotinaTardeActivity.this, AddNovaRotinaTardeActivity.class);
        startActivity(intent);
    }
}