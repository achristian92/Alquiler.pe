package apps.construyendo.alquilerpe.view.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import apps.construyendo.alquilerpe.R;
import apps.construyendo.alquilerpe.view.fragments.ReportmoneyFragment;
import apps.construyendo.alquilerpe.view.fragments.HomeFragment;
import apps.construyendo.alquilerpe.view.fragments.SearchFragment;

public class AddHabMainActivity extends AppCompatActivity {

    private Toolbar toolbar_RI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhab_main);
        toolbar_RI=(Toolbar) findViewById(R.id.toolbar);

        showToolbar(getResources().getString(R.string.registro_inqui),false);



    }
    public void showToolbar(String titulo, boolean upButton){
        //toolbar.setTitle(R.string.crear_usu);
        setSupportActionBar(toolbar_RI);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
