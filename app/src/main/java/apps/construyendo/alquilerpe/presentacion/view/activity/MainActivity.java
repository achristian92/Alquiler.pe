package apps.construyendo.alquilerpe.presentacion.view.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import apps.construyendo.alquilerpe.R;
import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;
import apps.construyendo.alquilerpe.presentacion.view.fragments.ReportmoneyFragment;
import apps.construyendo.alquilerpe.presentacion.view.fragments.HomeFragment;
import apps.construyendo.alquilerpe.presentacion.view.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements HomeFragment.onAlquilerClickListener {
    //si es tablet
    private boolean isDualPane;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
      // navigationView.setOnNavigationItemSelectedListener(monnavegar);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction2=fragmentManager.beginTransaction();
        transaction2.replace(R.id.conteiner_fragments,new HomeFragment()).commit();
        showToolbar("Principal",false);

        Fragment tareadetallefragment=getSupportFragmentManager().findFragmentById(R.id.frag_agregar_habitacion);
        isDualPane=tareadetallefragment!=null;

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                switch (item.getItemId()){
                    case R.id.item_buscar:
                        showToolbar("Buscar",false);
                        transaction.replace(R.id.conteiner_fragments,new SearchFragment()).commit();
                        return true;
                    case R.id.item_home:
                        showToolbar("Principal",false);
                        transaction.replace(R.id.conteiner_fragments,new HomeFragment()).commit();
                        return true;
                    case R.id.item_pagos:
                        showToolbar("Reporte Pagos",false);
                        transaction.replace(R.id.conteiner_fragments,new ReportmoneyFragment()).commit();
                        return true;
                }
                return false;
            }
        });

    }
    public void showToolbar(String titulo, boolean upButton){
        //toolbar.setTitle(R.string.crear_usu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public void onHabClick(AlquilerModel alquilerModel) {
        if(!isDualPane) {
            //si es telefono
            Intent intent = new Intent(MainActivity.this, HabDetalle_Activity.class);
            intent.putExtra(HabDetalle_Activity.EXTRA_ALQUILER, alquilerModel);
            startActivity(intent);
        }else{
            //si es tablet
      //      NoticiaDetalleFragment noticiaDetalleFragment= (NoticiaDetalleFragment) getSupportFragmentManager().findFragmentById(R.id.frag_detalle);
       //     noticiaDetalleFragment.setNoticia(noticia);
        }
    }

    @Override
    public void onAgregarHabclick() {
        Intent intent=new Intent(MainActivity.this,HabDetalle_Activity.class);
        startActivity(intent);
    }
}
