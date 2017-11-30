package apps.construyendo.alquilerpe.presentacion.view.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import apps.construyendo.alquilerpe.R;

public class HabDetalle_Activity extends AppCompatActivity {
    public static final  String EXTRA_ALQUILER="activity.noticiadetalle.EXTRA_NOTICIA";
    private Toolbar toolbar_RI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrohab_main);
        toolbar_RI=(Toolbar) findViewById(R.id.toolbar);

        showToolbar(getResources().getString(R.string.registro_inqui),false);



    }
    public void showToolbar(String titulo, boolean upButton){
        //toolbar.setTitle(R.string.crear_usu);
        setSupportActionBar(toolbar_RI);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_ri_toolbar,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.icon__ri_save:
                Toast.makeText(this, "Se guardo", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}