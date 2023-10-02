package com.example.rotine.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.rotine.MainActivity;
import com.example.rotine.NavigationDrawerActivity;
import com.example.rotine.NavigationHomeActivity;
import com.example.rotine.R;
import com.example.rotine.databinding.FragmentHomeBinding;
import com.example.rotine.ui.manha.RotinaMatinalFragment;
import com.example.rotine.ui.tarde.RotinaTardeFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Encontre o ImageButton e defina o OnClickListener corretamente
        ImageButton imgBtnRotinaMatinal = binding.imgBtnRotinaMatinal;
        imgBtnRotinaMatinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.action_homeFragment_to_rotinaMatinalFragment/*nav_home*/);
            }
        });
//        imgBtnRotinaTarde.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_homeFragment_to_rotinaMatinalFragment/*nav_home*/);
//            }
//        });
//        imgBtnRotinaNoturna.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_homeFragment_to_rotinaMatinalFragment/*nav_home*/);
//            }
//        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}