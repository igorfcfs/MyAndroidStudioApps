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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {

//    private static final String TAG =
    public static Usuario usuario;
    private FirebaseAuth autenticacao;

    private EditText edtTxtNomeCadastro, edtTxtEmailCadastro, edtTxtSenhaCadastro;

    private Button btnCadastrarCadastro, btnLoginCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnLoginCadastro = findViewById(R.id.btnLoginCadastro);
        btnLoginCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        initViews();
    }

    public void initViews(){
//        Log.d(TAG, "initViews: Started");
        edtTxtNomeCadastro = findViewById(R.id.edtTxtNomeCadastro);
        edtTxtEmailCadastro = findViewById(R.id.edtTxtEmailCadastro);
        edtTxtSenhaCadastro = findViewById(R.id.edtTxtSenhaCadastro);
        btnCadastrarCadastro = findViewById(R.id.btnCadastrarCadastro);
    }

    private void cadastrarUsuario(){

        autenticacao = ConfiguraBd.auth();
        autenticacao.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(CadastroActivity.this, "Sucesso ao cadastrar o usuário", Toast.LENGTH_SHORT).show();
                        } else {
//                            Toast.makeText(CadastroActivity.this, "Opa, ocorreu um erro", Toast.LENGTH_SHORT).show();
                            String excecao = "";
                            try{
                                throw task.getException();
                            } catch (FirebaseAuthWeakPasswordException e){
                                excecao = "Digite uma senha mais forte";
                            } catch (FirebaseAuthInvalidCredentialsException e){
                                excecao = "Digite um email válido";
                            } catch (FirebaseAuthUserCollisionException e){
                                excecao = "Esta conta já existe";
                            } catch (Exception e){
                                excecao = "Erro ao cadastrar usuário " + e.getMessage();
                                e.printStackTrace();
                            }
                            Toast.makeText(CadastroActivity.this, excecao, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void validarCampos(View view){
        String nome  = edtTxtNomeCadastro.getText().toString();
        String email = edtTxtEmailCadastro.getText().toString();
        String senha = edtTxtSenhaCadastro.getText().toString();

        if(!nome.isEmpty()){
            if(!email.isEmpty()){
                if (!senha.isEmpty()){
                    usuario = new Usuario();

                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setSenha(senha);

                    cadastrarUsuario();
                } else {
                    Toast.makeText(this, "Preencha a senha", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Preencha o email", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Preencha o nome", Toast.LENGTH_SHORT).show();
        }
    }
}