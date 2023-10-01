package com.example.rotine.ui.contatos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.rotine.databinding.FragmentContatosBinding;

public class ContatosFragment extends Fragment {

    private FragmentContatosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContatosViewModel contatosViewModel =
                new ViewModelProvider(this).get(ContatosViewModel.class);

        binding = FragmentContatosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.txtContatosFragment;
        contatosViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}