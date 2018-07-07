package com.akoteng.pizzaapp.adapters;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akoteng.pizzaapp.R;
import com.akoteng.pizzaapp.classes.Pizza;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder> {

    private List<Pizza> pizzaList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView image_view;
        public TextView name_view;

        public MyViewHolder(View view) {
            super(view);
            image_view = (ImageView) view.findViewById(R.id.pizza_view_image);
            name_view = (TextView) view.findViewById(R.id.pizza_view_name);
        }
    }

    public PizzaAdapter(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    @NonNull
    @Override
    public PizzaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pizza_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaAdapter.MyViewHolder holder, int position) {
        Pizza pizza = pizzaList.get(position);
        holder.image_view.setImageResource(R.drawable.img3);
        holder.name_view.setText("Pizza name");

    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }
}
