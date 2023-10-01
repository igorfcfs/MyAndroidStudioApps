package com.example.rotine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rotine.databinding.ActivityNavigationDrawerBinding;
import com.example.rotine.util.ConfiguraBd;
import com.example.rotine.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.ListenerRegistration;

import javax.annotation.Nullable;

public class CadastroActivity extends AppCompatActivity {

//    private static final String TAG =
    public static Usuario usuario;
    private FirebaseAuth autenticacao;

    private EditText edtTxtNomeCadastro, edtTxtEmailCadastro, edtTxtSenhaCadastro;

    private Button btnCadastrarCadastro, btnLoginCadastro;

    private TextView nameNavDraw;

    private ActivityNavigationDrawerBinding binding;

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
//                            Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
//                            startActivity(intent);
//                            Toast.makeText(CadastroActivity.this, "Sucesso ao cadastrar o usuário", Toast.LENGTH_SHORT).show();
                            atualizarNomeUsuarioNoFirestore();
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

    private void atualizarNomeUsuarioNoFirestore(){
        // Obtenha o nome do usuário a partir do campo de nome.
        String nomeDoUsuario = edtTxtNomeCadastro.getText().toString();

        // Obtenha a instância do FirebaseFirestore.
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Obtenha o ID do usuário autenticado.
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // Crie uma referência ao documento do usuário usando o ID do usuário.
        DocumentReference userRef = db.collection("usuarios").document(userID);

        userRef.update("nome", nomeDoUsuario)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // O nome do usuário foi atualizado com sucesso no Firestore.
                        // Você pode adicionar qualquer ação que desejar aqui.
                        FirebaseFirestore db = FirebaseFirestore.getInstance();

                        // Obtenha o ID do usuário autenticado.
                        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

                        // Crie uma referência ao documento do usuário usando o ID do usuário.
                        DocumentReference userRef = db.collection("usuarios").document(userID);

                        // Adicione um ouvinte para obter os dados do documento do usuário.
                        ListenerRegistration registration = userRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                            @Override
                            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                                if (e != null) {
                                    // Ocorreu um erro ao obter os dados do documento.
                                    // Lidar com o erro de acordo com sua necessidade.
                                } else {
                                    if (documentSnapshot.exists()) {
                                        // O documento existe, você pode obter os dados dele.
                                        String nomeDoUsuario = documentSnapshot.getString("nome");
                                        NavigationView navigationView = binding.navView;
                                        View headerView = navigationView.getHeaderView(0);
                                        nameNavDraw = headerView.findViewById(R.id.nameNavDraw);
//                                        if(nameNavDraw != null){
                                            nameNavDraw.setText(nomeDoUsuario);
//                                        }
                                        // Faça o que quiser com o nome do usuário.
                                    } else {
                                        // O documento não existe.
                                        // Isso pode ocorrer se o usuário não tiver inserido seu nome ainda.
                                    }
                                }
                            }
                        });

                        // Agora, você pode redirecionar o usuário para a próxima tela ou fazer outras ações.
                        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(CadastroActivity.this, "Sucesso ao cadastrar o usuário", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Ocorreu um erro ao atualizar o nome do usuário no Firestore.
                        // Você pode lidar com o erro de acordo com sua necessidade.
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