package com.akoteng.pizzaapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akoteng.pizzaapp.PizzaActivity;
import com.akoteng.pizzaapp.R;
import com.akoteng.pizzaapp.classes.Pizza;
import com.bumptech.glide.Glide;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder> {

    private List<Pizza> pizzaList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView image_view;
        public TextView name_view, price_view;

        public MyViewHolder(View view) {
            super(view);
            image_view = (ImageView) view.findViewById(R.id.pizza_view_image);
            name_view = (TextView) view.findViewById(R.id.pizza_view_name);
            price_view = (TextView) view.findViewById(R.id.pizza_view_price);
        }
    }

    public PizzaAdapter(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    @NonNull
    @Override
    public PizzaAdapter.MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pizza_list_item, parent, false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_pizza_activity = new Intent(parent.getContext(), PizzaActivity.class);
                view.getContext().startActivity(to_pizza_activity);
            }
        });

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaAdapter.MyViewHolder holder, int position) {
        Pizza pizza = pizzaList.get(position);
        holder.name_view.setText("Pizza name");
        holder.price_view.setText("S: KES 500    M: KES 700  L: KES 1000");

        Glide.with(holder.image_view.getContext())
                .load("https://www.cicis.com/media/1176/pizza_trad_pepperonibeef.png")
                .placeholder(R.drawable.logo_vertical)
                .crossFade(1000)
                .into(holder.image_view);

    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

}
