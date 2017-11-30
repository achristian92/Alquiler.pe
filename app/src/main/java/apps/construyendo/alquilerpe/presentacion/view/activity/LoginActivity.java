package apps.construyendo.alquilerpe.presentacion.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import apps.construyendo.alquilerpe.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.imagen_logo)
    ImageView imagenLogo;
    @BindView(R.id.edit_i_usu)
    TextInputEditText editIUsu;
    @BindView(R.id.edit_i_password)
    TextInputEditText editIPassword;
    @BindView(R.id.btn_ingresar_login)
    Button btnIngresarLogin;
    @BindView(R.id.txt_pregunta)
    TextView txtPregunta;
    @BindView(R.id.txt_link_creaaccond)
    TextView txtLinkCreaaccond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        txtLinkCreaaccond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, CrearUsuarioActivity.class);
                startActivity(intent);
            }
        });
        btnIngresarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
