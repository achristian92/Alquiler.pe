package apps.construyendo.alquilerpe.presentacion.view.fragments;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import apps.construyendo.alquilerpe.R;
import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;
import apps.construyendo.alquilerpe.presentacion.presenter.AlquilerDetallePresenter;
import apps.construyendo.alquilerpe.presentacion.view.AlquilerDetalleView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HabDetalleFragment extends Fragment implements AlquilerDetalleView,View.OnClickListener {

    private static final String ARG_NOTICIA = "fragment.NoticiaDetalleFragment.ARG_NOTICIA";

    private TextInputEditText nombre,apellidos,dni,celular,precio,num_hab;
    private EditText fecha_pago_mensual;
    private ImageButton imagen_fecha;
    private Toolbar toolbar_detalle;

    Button botton_guardar;
    ProgressBar progressBar;
    private AlquilerModel alquilerModel;
    private AlquilerDetallePresenter alquilerDetallePresenter;
    private int dia,mes,ano,hora,minutos;

    public static HabDetalleFragment newInstance(AlquilerModel alquilerModel) {
        HabDetalleFragment f = new HabDetalleFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTICIA, alquilerModel);
        f.setArguments(args);
        return f;
    }

    public HabDetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            alquilerModel = getArguments().getParcelable(ARG_NOTICIA);       }    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro_hab, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nombre=view.findViewById(R.id.edit_RI_nombre);
        apellidos=view.findViewById(R.id.edit_RI_apellidos);
        dni=view.findViewById(R.id.edit_RI_DNI);
        celular=view.findViewById(R.id.edit_RI_celular);
        num_hab=view.findViewById(R.id.edit_RI_num_room);
        precio=view.findViewById(R.id.edit_RI_precio);
        imagen_fecha=view.findViewById(R.id.imageButton);
        fecha_pago_mensual=view.findViewById(R.id.edit_RI_fecha_pago_mensual);
        toolbar_detalle=view.findViewById(R.id.toolbar);
        botton_guardar=view.findViewById(R.id.boton_guardar_alquiler);
        progressBar=view.findViewById(R.id.progressBar);

        showToolbar("Detalle de Alquiler",true);

        initUI();
        alquilerDetallePresenter = new AlquilerDetallePresenter(this);
        botton_guardar.setOnClickListener(this);
        imagen_fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                traerdialogfecha();
            }
        });

    }

    private void initUI() {
        if (alquilerModel != null) {
            nombre.setText(alquilerModel.getNombre_inqui().toString());
            apellidos.setText(alquilerModel.getApellidos_inqui().toString());
            dni.setText(alquilerModel.getDni()+"");
            precio.setText(alquilerModel.getPrecio()+"");
            fecha_pago_mensual.setText(alquilerModel.getFecha_pago_mensual().toString());
            celular.setText(alquilerModel.getCelular()+"");
            num_hab.setText(alquilerModel.getNum_hab()+"");
        }
    }

    public void setNoticia(AlquilerModel alquilerModel) {
        this.alquilerModel = alquilerModel;
        initUI();
    }
    public void showToolbar(String titulo, boolean upButton){

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_detalle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


    @Override
    public void onClick(View view) {
        if(view==botton_guardar){
            if(alquilerModel==null){
                alquilerModel=new AlquilerModel();
            }
        }

            alquilerModel.setNombre_inqui(nombre.getText().toString());
            alquilerModel.setApellidos_inqui(apellidos.getText().toString());
            alquilerModel.setDni(Integer.parseInt(dni.getText().toString()));
            alquilerModel.setPrecio(Double.parseDouble(precio.getText().toString()));
            alquilerModel.setFecha_pago_mensual(fecha_pago_mensual.getText().toString());
            alquilerModel.setCelular(Integer.parseInt(celular.getText().toString()));
            alquilerModel.setNum_hab(Integer.parseInt(num_hab.getText().toString()));

            validarcamposvacios();

          /*


            alquilerModel.setFecha_contrato(nombre.getText().toString());*/


    }

   private void validarcamposvacios() {
        String nombrecito=nombre.getText().toString();
        String apelliitos=apellidos.getText().toString();
        String dniss=dni.getText().toString();
        String celularr=celular.getText().toString();
        String num_habii=num_hab.getText().toString();
        String precioo=precio.getText().toString();
        String fechaa=fecha_pago_mensual.getText().toString();

        if (nombrecito.isEmpty() || apelliitos.isEmpty() || dniss.isEmpty() || celularr.isEmpty() || num_habii.isEmpty() || precioo.isEmpty() || fechaa.isEmpty()){
            Toast.makeText(getActivity(), "Llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            guardarAlquiler(alquilerModel);
        }

    }

    private void traerdialogfecha() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        ano = c.get(Calendar.YEAR);
        mes = c.get(Calendar.MONTH);
        dia = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        fecha_pago_mensual.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                    }
                }, dia, mes, ano);
        datePickerDialog.show();
    }

    @Override
    public void mostrarLoading() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void ocultarLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public Context context() {
        return getContext();
    }

    @Override
    public void guardarAlquiler(AlquilerModel alquilerModel) {
        alquilerDetallePresenter.guardarAlquiler(alquilerModel);
    }

    @Override
    public void notificarNoticiaGuardada() {
        getActivity().finish();
    }

    @Override
    public void actualizaNoticia(AlquilerModel alquilerModel) {

    }


}
