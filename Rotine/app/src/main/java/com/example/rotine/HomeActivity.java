package com.example.rotine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rotine.model.Usuario;
import com.example.rotine.util.ConfiguraBd;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = ConfiguraBd.auth();

        txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText("Olá " + auth.getCurrentUser().getEmail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings_menu_dark:
                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
                break; //Need to change to the settings activity
            case R.id.logout_menu:
//                voltarParaPaginaPrincipal();
                deslogar();
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                break; //volta para a pagina inicial
        }
        return super.onOptionsItemSelected(item);
    }

    private void voltarParaPaginaPrincipal(){
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(intent);
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