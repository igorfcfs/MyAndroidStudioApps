package com.example.rotine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.rotine.databinding.ActivityNavigationDrawerBinding;
import com.google.android.material.navigation.NavigationView;

public class AddNovaRotinaActivity extends AppCompatActivity {


    //Adicionar checkboxes atraves do botao fab
//    private Button btnAddNovaRotina;
////    private Button buttonCreateCheckbox;
//    private LinearLayout checkboxContainer;
//
//    private EditText edtTxtNomeNovaRotina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nova_rotina);




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