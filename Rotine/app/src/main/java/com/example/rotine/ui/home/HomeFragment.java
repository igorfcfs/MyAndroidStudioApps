package com.example.rotine.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.rotine.databinding.FragmentHomeBinding;

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

//        NavigationView navigationView = binding.navView;

        // Encontre o ImageButton e defina o OnClickListener corretamente
//        ImageButton imgBtnRotinaMatinal = binding.imgBtnRotinaMatinal;
//        ImageButton imgBtnRotinaTarde = binding.imgBtnRotinaTarde;
//        ImageButton imgBtnRotinaNoturna = binding.imgBtnRotinaNoturna;

//        NavController navController = Navigation.findNavController(NavigationHomeActivity, R.id.nav_home);
//        NavigationUI.setupWithNavController(navigationView, navController);

        //a diferenca entre o NavigationDrawerActivity e o NavigationHomeActivity e que o primeiro consegue navegar entre as abas, ja o segundo nao, preciso descobrir o motivo
        //aqui nao sera possivel de colocar uma acao no image button, terei de fazer isso na NavigationHomeActivity

//        imgBtnRotinaMatinal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_homeFragment_to_rotinaMatinalFragment);
//            }
//        });
//        imgBtnRotinaTarde.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_homeFragment_to_rotinaTardeFragment);
//            }
//        });
//        imgBtnRotinaNoturna.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_homeFragment_to_rotinaNoturnaFragment);
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