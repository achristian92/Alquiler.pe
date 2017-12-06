package apps.construyendo.alquilerpe.presentacion.view.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import apps.construyendo.alquilerpe.R;
import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;
import apps.construyendo.alquilerpe.presentacion.view.fragments.HabDetalleFragment;

public class HabDetalle_Activity extends AppCompatActivity {
    public static final  String EXTRA_ALQUILER="activity.noticiadetalle.EXTRA_NOTICIA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_registrohab_main);

        AlquilerModel alquilerModel=getIntent().getParcelableExtra(EXTRA_ALQUILER);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(android.R.id.content, HabDetalleFragment.newInstance(alquilerModel));
        ft.commit();


    }


}
