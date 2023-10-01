package com.example.rotine.util;

import com.google.firebase.auth.FirebaseAuth;

public class ConfiguraBd {

    private static FirebaseAuth auth;

    public static FirebaseAuth auth(){
        if(auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }
}
