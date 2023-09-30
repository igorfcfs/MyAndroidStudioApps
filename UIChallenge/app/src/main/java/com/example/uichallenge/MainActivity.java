package com.example.uichallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText edtTxtName, edtTxtEmail, edtTxtPassword, edtTxtPassRepeat;
    private Button btnPickImage, btnRegister;
    private TextView txtWarnName, txtWarnEmail, txtWarnPassword, txtWarnPassRepeat;
    private Spinner countriesSpinner;
    private RadioGroup rgGender;
    private CheckBox agreementCheck;
    private ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Yet to talk about", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegister();
            }
        });
    }

    private void initRegister(){
        Log.d(TAG, "initRegister: Started");

        if(validateData()){
            if (agreementCheck.isChecked()){
                showSnackbar();
            } else {
                Toast.makeText(this, "You need to agree to the licence agreement", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showSnackbar(){
        Log.d(TAG, "showSnackBar: Started");
        txtWarnName.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnPassword.setVisibility(View.GONE);
        txtWarnPassRepeat.setVisibility(View.GONE);

        String name = edtTxtName.getText().toString();
        String email = edtTxtEmail.getText().toString();
        String country = countriesSpinner.getSelectedItem().toString();
        String gender = "";

        switch (rgGender.getCheckedRadioButtonId()){
            case R.id.rbMale:
                gender = "Male";
                break;
            case R.id.rbFemale:
                gender = "Female";
                break;
            case R.id.rbOther:
                gender = "Other";
                break;
            default:
                gender = "Unknown";
                break;
        }

        String snackText = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Gender: " + gender + "\n" +
                "Country: " + country;
        Log.d(TAG, snackText);

        Snackbar.make(parent, /*"User Registered"*/snackText, Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtTxtName.setText("");
                        edtTxtEmail.setText("");
                        edtTxtPassword.setText("");
                        edtTxtPassRepeat.setText("");
                    }
                }).show();
    }

    private boolean validateData(){
        Log.d(TAG, "validateData: Started");
        if(edtTxtName.getText().toString().equals("")){
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Enter your name");
            return false;
        }

        if(edtTxtEmail.getText().toString().equals("")){
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Enter your email");
            return false;
        }

        if(edtTxtPassword.getText().toString().equals("")){
            txtWarnPassword.setVisibility(View.VISIBLE);
            txtWarnPassword.setText("Enter your password");
            return false;
        }

        if(edtTxtPassRepeat.getText().toString().equals("")){
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Re Enter your password");
            return false;
        }

        if(!edtTxtPassword.getText().toString().equals(edtTxtPassRepeat.getText().toString())){
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Passwords doesn't match");
            return false;
        }

        return true;
    }

    private void initViews(){
        Log.d(TAG, "initViews: Started");
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
        edtTxtPassRepeat = findViewById(R.id.edtTxtPassRepeat);

        btnPickImage = findViewById(R.id.btnPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        txtWarnName = findViewById(R.id.txtWarnName);
        txtWarnEmail = findViewById(R.id.txtWarnEmail);
        txtWarnPassword = findViewById(R.id.txtWarnPassword);
        txtWarnPassRepeat = findViewById(R.id.txtWarnPassRepeat);

        agreementCheck = findViewById(R.id.agreementCheck);

        countriesSpinner = findViewById(R.id.spinnerCountry);
        rgGender = findViewById(R.id.rgGender);

        parent = findViewById(R.id.parent);
    }
}