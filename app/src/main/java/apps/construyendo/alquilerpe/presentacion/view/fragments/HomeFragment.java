package apps.construyendo.alquilerpe.presentacion.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import apps.construyendo.alquilerpe.R;
import apps.construyendo.alquilerpe.presentacion.view.activity.AddHabMainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {




    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        FloatingActionButton fab=(FloatingActionButton)view.findViewById(R.id.button_fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), AddHabMainActivity.class);
                startActivity(intent);
            }
        });

        return view;


    }



}
