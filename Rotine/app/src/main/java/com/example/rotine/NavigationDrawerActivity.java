package com.example.rotine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rotine.util.ConfiguraBd;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rotine.databinding.ActivityNavigationDrawerBinding;
import com.google.firebase.auth.FirebaseAuth;

public class NavigationDrawerActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationDrawerBinding binding;

    private TextView nomeNavDraw, emailNavDraw;

    private ImageButton imgBtnRotinaMatinal, imgBtnRotinaTarde, imgBtnRotinaNoturna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar);
        binding.appBarNavigationDrawer.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(NavigationDrawerActivity.this, AddNovaRotinaMatinalActivity.class);
                startActivity(intent);
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_contatos, R.id.nav_sobre_nos)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        imgBtnRotinaMatinal = findViewById(R.id.imgBtnRotinaMatinal);
        imgBtnRotinaMatinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationDrawerActivity.this, RotinaMatinalActivity.class);
                startActivity(intent);
            }
        });

        imgBtnRotinaTarde = findViewById(R.id.imgBtnRotinaTarde);
        imgBtnRotinaTarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationDrawerActivity.this, RotinaTardeActivity.class);
                startActivity(intent);
            }
        });

        imgBtnRotinaNoturna = findViewById(R.id.imgBtnRotinaNoturna);
        imgBtnRotinaNoturna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationDrawerActivity.this, RotinaNoturnaActivity.class);
                startActivity(intent);
            }
        });

//        NavController navController = Navigation.findNavController(this, R.id.nav_home);
//        NavigationUI.setupActionBarWithNavController(this, navController);

//        NavController navController2 = Navigation.findNavController(this, R.id.nav_home);
//        NavigationUI.setupWithNavController(navigationView, navController);

        auth = ConfiguraBd.auth();

        //Preciso deste header view para obter uma referencia ao text view desejado
        View headerView = navigationView.getHeaderView(0); // Obtenha a referência para o layout do header

        // Encontre o elemento desejado dentro do layout do header
        /*preciso fazer a mesma coisa com o nome do usuario, para isso preciso:
        -pegar o nome do plain text quando fizer o cadastro;
        -armazenar em uma coleção usuario do firestorm database;
        -dar um get no nome deste usuario;
        -e por fim dar um set no nameNavDraw passando o nome deste usuário como parâmetro
         */



        nomeNavDraw = headerView.findViewById(R.id.nomeNavDraw);
        emailNavDraw = headerView.findViewById(R.id.emailNavDraw);

//        if(emailNavDraw != null){
//            emailNavDraw.setText(auth.getCurrentUser().getEmail());
//        }
        recuperarDados();
    }

    private void recuperarDados(){
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
//        int defaultValue = getResources().getInteger(R.integer.);
        String nome = sharedPref.getString("nome", "Sem nome");
        String email = sharedPref.getString("email", "Sem email");
        nomeNavDraw.setText(nome);
        emailNavDraw.setText(email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NavigationDrawerActivity.this, SettingsActivity.class);
                startActivity(intent);
                break; //Need to change to the settings activity
            case R.id.logout_menu_navdraw:
//                voltarParaPaginaPrincipal();
                deslogar();
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                break; //volta para a pagina inicial
        }
        return super.onOptionsItemSelected(item);
    }

    public void deslogar(){
        try{
            auth.signOut();
            finish();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}