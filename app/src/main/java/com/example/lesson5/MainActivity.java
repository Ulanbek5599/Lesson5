package com.example.lesson5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.lesson5.fragment.ListFragment;
import com.example.lesson5.fragment.MainFragment;
import com.example.lesson5.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);]
        // add
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_contn,MainFragment.class,null)
                    .commit();
        }
        bottomNavigationView = findViewById(R.id.bottom_navigeite);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.btn_home:
                        fragmentTransaction.replace(R.id.fragment_contn, MainFragment.newInstance(" "," ")).commit();
                        item.setChecked(true);
                        break;
                    case R.id.btn_list:
                        fragmentTransaction.replace(R.id.fragment_contn, ListFragment.newInstance(" "," ")).commit();
                        item.setChecked(true);
                        break;
                    case R.id.btn_person:
                        fragmentTransaction.replace(R.id.fragment_contn, ProfileFragment.newInstance(" "," ")).commit();
                        item.setChecked(true);
                        break;
                }

                return false;
            }
        });
    }
}