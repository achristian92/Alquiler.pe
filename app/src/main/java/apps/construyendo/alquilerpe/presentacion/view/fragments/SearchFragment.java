package apps.construyendo.alquilerpe.presentacion.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import apps.construyendo.alquilerpe.R;
import apps.construyendo.alquilerpe.presentacion.adapters.AlquileresAdapter;
import apps.construyendo.alquilerpe.presentacion.model.AlquilerModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    ArrayList<AlquilerModel> listaalquiler;
    RecyclerView recyclerView;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView=view.findViewById(R.id.reciber);
        listaalquiler=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        llenarAlquilares();

        AlquileresAdapter adapter=new AlquileresAdapter(listaalquiler);
        recyclerView.setAdapter(adapter);
        return view;
    }
    private void llenarAlquilares() {
        listaalquiler.add(new AlquilerModel("ALAN","RUIZ",1,123,"12/12/2017",true));
        listaalquiler.add(new AlquilerModel("ALAN2","RUIZ3",11,123,"12/12/2017",false));
        listaalquiler.add(new AlquilerModel("ALAN2","RUIZ3",11,123,"12/12/2017",true));

    }

}
