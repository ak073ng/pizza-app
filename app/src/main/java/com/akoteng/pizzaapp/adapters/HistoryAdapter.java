package com.akoteng.pizzaapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.akoteng.pizzaapp.R;
import com.akoteng.pizzaapp.classes.Cart;
import com.akoteng.pizzaapp.classes.History;
import com.akoteng.pizzaapp.classes.Pizza;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private List<History> historyList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView pizza_name, pizza_info, pizza_date;

        public MyViewHolder(View view) {
            super(view);
            pizza_name = (TextView) view.findViewById(R.id.tv_pizza_name);
            pizza_info = (TextView) view.findViewById(R.id.tv_pizza_info);
            pizza_date = (TextView) view.findViewById(R.id.tv_pizza_date);
        }
    }

    public HistoryAdapter(List<History> historyList) {
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_list_item, parent, false);

        return new HistoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder holder, int position) {
        History history = historyList.get(position);
        holder.pizza_name.setText("Pizza name");
        holder.pizza_info.setText("x 1: includes extra cheese, thicker crust and added sauce");
        holder.pizza_date.setText("Ordered on 27 Feb 2018: 2:47pm");

    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }
}
