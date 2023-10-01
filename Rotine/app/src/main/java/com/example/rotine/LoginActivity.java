package com.example.rotine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rotine.util.ConfiguraBd;
import com.example.rotine.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private Button btnCadastrarLogin, btnAcessarLogin;
    EditText edtTxtEmailLogin, edtTxtSenhaLogin;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnCadastrarLogin = findViewById(R.id.btnCadastrarLogin);
        btnCadastrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        auth = ConfiguraBd.auth();

        initViews();
    }

    public void validarAutenticacao(View view) {
        String email = edtTxtEmailLogin.getText().toString();
        String senha = edtTxtSenhaLogin.getText().toString();

        if(!email.isEmpty()){
            if (!senha.isEmpty()){
                Usuario usuario = new Usuario();

                usuario.setEmail(email);
                usuario.setSenha(senha);

                logarUsuario(usuario);
            } else {
                Toast.makeText(this, "Preencha a senha", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Preencha o email", Toast.LENGTH_SHORT).show();
        }
    }

    private void logarUsuario(Usuario usuario){
        auth.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            abrirHome();
                        } else {
                            String excecao = "";
                            try{
                                throw task.getException();
                            } catch (FirebaseAuthInvalidUserException e){
                                excecao = "Usuário não cadastrado";
                            } catch (FirebaseAuthInvalidCredentialsException e){
                                excecao = "Email ou senha incorreto";
                            } catch (Exception e){
                                excecao = "Erro ao logar usuário " + e.getMessage();
                                e.printStackTrace();
                            }
                            Toast.makeText(LoginActivity.this, excecao, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void abrirHome(){
//        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//        startActivity(intent);
        Intent intent = new Intent(LoginActivity.this, NavigationDrawerActivity.class);
        startActivity(intent);
    }

    protected void onStart(){
        super.onStart();
        FirebaseUser usuarioAuth = auth.getCurrentUser();
        if(usuarioAuth != null){
            abrirHome();
        }
    }

    private void initViews() {
        edtTxtEmailLogin = findViewById(R.id.edtTxtEmailLogin);
        edtTxtSenhaLogin = findViewById(R.id.edtTxtSenhaLogin);
        btnAcessarLogin = findViewById(R.id.btnAcessarLogin);
    }
}