package apps.construyendo.alquilerpe.presentacion.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import apps.construyendo.alquilerpe.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CrearUsuarioActivity extends AppCompatActivity {


    @BindView(R.id.edit_c_nombre)
    TextInputEditText editCNombre;
    @BindView(R.id.edit_c_apellidos)
    TextInputEditText editCApellidos;
    @BindView(R.id.edit_c_correo)
    TextInputEditText editCCorreo;
    @BindView(R.id.edit_c_password)
    TextInputEditText editCPassword;
    @BindView(R.id.btn_crear_cuenta)
    Button btnCrearCuenta;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);
        ButterKnife.bind(this);
        showToolbar(getResources().getString(R.string.crear_usu),true);
        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CrearUsuarioActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    public void showToolbar(String titulo, boolean upButton){
        //toolbar.setTitle(R.string.crear_usu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
