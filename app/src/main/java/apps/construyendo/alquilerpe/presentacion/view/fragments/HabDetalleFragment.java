package apps.construyendo.alquilerpe.presentacion.view.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import apps.construyendo.alquilerpe.R;
import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;
import apps.construyendo.alquilerpe.presentacion.presenter.AlquilerDetallePresenter;
import apps.construyendo.alquilerpe.presentacion.view.AlquilerDetalleView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.http.PUT;

/**
 * A simple {@link Fragment} subclass.
 */
public class HabDetalleFragment extends Fragment implements AlquilerDetalleView, View.OnClickListener{

    private static final String ARG_NOTICIA = "fragment.NoticiaDetalleFragment.ARG_NOTICIA";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edit_RI_nombre)
    TextInputEditText editRINombre;
    @BindView(R.id.edit_RI_apellidos)
    TextInputEditText editRIApellidos;
    @BindView(R.id.edit_RI_DNI)
    TextInputEditText editRIDNI;
    @BindView(R.id.edit_RI_celular)
    TextInputEditText editRICelular;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.radioButton)
    RadioButton radioButton;
    @BindView(R.id.edit_num_hab)
    EditText editNumHab;
    Unbinder unbinder;
    FloatingActionButton fb;
    private AlquilerModel alquilerModel;
    private AlquilerDetallePresenter alquilerDetallePresenter;

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
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            alquilerModel=getArguments().getParcelable(ARG_NOTICIA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro_hab, container, false);

        return view;
    }
    @Override
    public void onViewCreated(View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        fb=view.findViewById(R.id.btn_guardar);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {
        if (alquilerModel != null) {
            editRINombre.setText(alquilerModel.getNombre_inqui());

        }
    }
    public void setNoticia(AlquilerModel alquilerModel) {
        this.alquilerModel = alquilerModel;
        initUI();
    }


     @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
    if(alquilerModel==null){
        alquilerModel=new AlquilerModel();
    }else {
        alquilerModel.setNombre_inqui(editRINombre.getText().toString());
    }
    }

    @Override
    public void mostrarLoading() {

    }

    @Override
    public void ocultarLoading() {

    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void guardarAlquiler(AlquilerModel alquilerModel) {

    }

    @Override
    public void notificarNoticiaGuardada() {

    }

    @Override
    public void actualizaNoticia(AlquilerModel alquilerModel) {

    }
}
