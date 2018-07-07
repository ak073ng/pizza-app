package com.akoteng.pizzaapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akoteng.pizzaapp.R;
import com.akoteng.pizzaapp.classes.Cart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>{
    private List<Cart> cartList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView pizza_name, pizza_info;

        public MyViewHolder(View view) {
            super(view);
            pizza_name = (TextView) view.findViewById(R.id.tv_pizza_name);
            pizza_info = (TextView) view.findViewById(R.id.tv_pizza_info);
        }
    }

    public CartAdapter(List<Cart> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_list_item, parent, false);

        return new CartAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.MyViewHolder holder, int position) {
        Cart cart = cartList.get(position);
        holder.pizza_name.setText("Pizza name");
        holder.pizza_info.setText("x 1: includes extra cheese, thicker crust and added sauce");

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
}
