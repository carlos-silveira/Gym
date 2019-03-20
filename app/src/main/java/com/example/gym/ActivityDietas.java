package com.example.gym;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gym.lista.Datos;
import com.example.gym.lista.ModeloLista;
import com.example.gym.lista.CustomAdapter;

import java.util.ArrayList;

public class ActivityDietas extends Fragment {
  public static RecyclerView.Adapter adapter;
  public RecyclerView.LayoutManager layoutManager;
  public static RecyclerView recyclerView;
  public static ArrayList<ModeloLista> data;
  public static ArrayList<Integer> removedItems;
    public ActivityDietas(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dietas,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(getView().getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<ModeloLista>();
        for(int x = 0; x < Datos.descripciones.length; x++){
          data.add(new ModeloLista(
          Datos.nombres[x],
          Datos.descripciones[x],
          Datos.imagenes[x],
          Datos.ids[x]
          ));
        }
        removedItems=new ArrayList<>();
        adapter=new CustomAdapter(data);
        recyclerView.setAdapter(adapter);
    }


}
