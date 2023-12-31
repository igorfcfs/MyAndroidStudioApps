package com.example.rotine.ui.sobrenos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.rotine.databinding.FragmentSobrenosBinding;

public class SobreNosFragment extends Fragment {

    private FragmentSobrenosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SobreNosViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SobreNosViewModel.class);

        binding = FragmentSobrenosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}