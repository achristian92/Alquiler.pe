package apps.construyendo.alquilerpe.presentacion.view.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import apps.construyendo.alquilerpe.R;
import apps.construyendo.alquilerpe.presentacion.adapters.AlquileresAdapter;
import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;
import apps.construyendo.alquilerpe.presentacion.presenter.AlquilerPresenter;
import apps.construyendo.alquilerpe.presentacion.view.AlquilerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements AlquilerView{

    private AlquileresAdapter adapter;
    private List<AlquilerModel> tareasModelList=new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private FloatingActionButton fabAgregar;

    private AlquilerPresenter alquilerPresenter;


    private onAlquilerClickListener onAlquilerClickListener;
    private List<AlquilerModel> listaalquiler;

    public HomeFragment() {
        // Required empty public constructor
    }
    //debo haceguaserme que la activity mainactivity implemente este fragments --> para poder comunicarme con el activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onAlquilerClickListener = (onAlquilerClickListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"Debe implementar onnoticiaclicklistener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
               // super.onViewCreated(view,savedInstanceState);
        recyclerView=view.findViewById(R.id.reciclerview);
        fabAgregar=view.findViewById(R.id.button_fab_add);
        progressBar=view.findViewById(R.id.progressBar);

        if(savedInstanceState!=null){}

        fabAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarHab();
            }
        });

       // adapter=new AlquileresAdapter(tareasModelList);
        adapter=new AlquileresAdapter(tareasModelList);
        recyclerView.setAdapter(adapter);
        alquilerPresenter = new AlquilerPresenter(this);



    }



    @Override
    public void onStart(){
        super.onStart();
        alquilerPresenter.cargarAlquileres();
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
    public void verDetalle(AlquilerModel alquilerModel) {
    onAlquilerClickListener.onHabClick(alquilerModel);
    }

    @Override
    public void agregarHab() {
    onAlquilerClickListener.onAgregarHabclick();
    }


    @Override
    public void mostrarHabitaciones(final List<AlquilerModel> tareasModelList) {

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

       // adapter=new AlquileresAdapter(tareasModelList);
        adapter=new AlquileresAdapter(tareasModelList);
        recyclerView.setAdapter(adapter);



      adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   verDetalle(tareasModelList.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }



    public interface onAlquilerClickListener{
        void  onHabClick(AlquilerModel alquilerModel);

        void onAgregarHabclick();
    }
    //cuando tengo el activity todo creado ahora si llamo al metodo del activity
  /*  @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }*/
}
