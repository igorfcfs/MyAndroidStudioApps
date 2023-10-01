package com.example.rotine.util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UsuarioAutenticado {

    public static FirebaseUser usuarioLogado(){
        FirebaseAuth usuario = ConfiguraBd.auth();
        return usuario.getCurrentUser();
    }
}
