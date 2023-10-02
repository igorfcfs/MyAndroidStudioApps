package com.example.rotine;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rotine.util.ConfiguraBd;
import com.google.android.material.snackbar.Snackbar;
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

public class NavigationHomeActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private ActivityNavigationDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavigationView navigationView = binding.navView;

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController);
//        findViewById(R.id.imgBtnRotinaMatinal).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(navigationView).navigate(R.id.nav_host_fragment_content_navigation_drawer/*nav_home*/);
//            }
//        });

//        NavController navController2 = Navigation.findNavController(this, R.id.nav_home);
//        NavigationUI.setupActionBarWithNavController(this, navController2);

        auth = ConfiguraBd.auth();

        //Preciso deste header view para obter uma referencia ao text view desejado
        View headerView = navigationView.getHeaderView(0); // Obtenha a referência para o layout do header
//    }
        // No seu código em NavigationHomeActivity.java


// ...

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        NavigationView navigationView = binding.navView;
//
//        // Obtenha o NavController
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
//
//        // Encontre a visualização (por exemplo, um botão) que desencadeará a transição
//        ImageButton button = findViewById(R.id.imgBtnRotinaMatinal);
//
//        // Configure o OnClickListener para iniciar a transição
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Navegue para o destino desejado usando o NavController
//                navController.navigate(R.id.nav_home);
//            }
//        });
//
//        // ...
//
//    }
//}
    }
}