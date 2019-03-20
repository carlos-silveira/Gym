package com.example.gym.lista;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.gym.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    private ArrayList<ModeloLista> dataset;

    public CustomAdapter(ArrayList<ModeloLista> data){
        this.dataset = data;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dieta, parent, false);
        MyViewHolder  myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        //accedemos a los datos y se los enviamos a cada item;
        TextView tTitle = holder.itemtitle;
        TextView tDes = holder.itemDescription;
        ImageView imageView = holder.itemImage;
        tTitle.setText(dataset.get(position).getNombre());
        tDes.setText(dataset.get(position).getDescripcion());
        imageView.setImageResource(dataset.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView itemtitle, itemDescription;
        ImageView itemImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemtitle = itemView.findViewById(R.id.item_title);
            this.itemDescription = itemView.findViewById(R.id.item_description);
            this.itemImage = itemView.findViewById(R.id.item_image);
        }
    }
}
