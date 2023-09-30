package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button btnAllBooks, btnAlreadyReady, btnCurrentlyReading, btnFavorite, btnWantToRead, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews(){
        Log.d(TAG, "initViews: Started");

        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnAlreadyReady = findViewById(R.id.btnAlreadyReady);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnFavorite = findViewById(R.id.btnFavorite);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnAbout = findViewById(R.id.btnAbout);
    }
}