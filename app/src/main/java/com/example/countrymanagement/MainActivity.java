package com.example.countrymanagement;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.countrymanagement.databinding.ActivityMainBinding;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private HashMap<Integer, Fragment> kv = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fillHashMap();

        //FragmentToStart
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            replaceFragment(kv.get(item.getItemId()));
            return true;
        });
    }

    private void fillHashMap(){
        kv.put(R.id.navigation_home, new HomeFragment());
        kv.put(R.id.navigation_profile, new ProfileFragment());
        kv.put(R.id.navigation_settings, new SettingsFragment());
    }

    private void replaceFragment(Fragment fragment){
        var fragmentManager = getSupportFragmentManager();
        var fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}