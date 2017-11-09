package apps.construyendo.alquilerpe.view.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import apps.construyendo.alquilerpe.R;
import apps.construyendo.alquilerpe.view.fragments.ReportmoneyFragment;
import apps.construyendo.alquilerpe.view.fragments.HomeFragment;
import apps.construyendo.alquilerpe.view.fragments.SearchFragment;

public class AddHabMainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener monnavegar=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            switch (item.getItemId()){
                case R.id.item_buscar:
                    transaction.replace(R.id.conteiner_fragments,new SearchFragment()).commit();
                    return true;
                case R.id.item_home:
                    transaction.replace(R.id.conteiner_fragments,new HomeFragment()).commit();
                    return true;
                case R.id.item_pagos:
                    transaction.replace(R.id.conteiner_fragments,new ReportmoneyFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhab_main);
       BottomNavigationView navigationView=findViewById(R.id.bottom_navigation);
       navigationView.setOnNavigationItemSelectedListener(monnavegar);



    }
}
