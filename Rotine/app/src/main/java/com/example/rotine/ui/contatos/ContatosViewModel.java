package com.example.rotine.ui.contatos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContatosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ContatosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Whatsapp: (11) 971322867");
    }

    public LiveData<String> getText() {
        return mText;
    }
}