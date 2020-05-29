package com.example.dessertshopserver.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dessertshopserver.Model.Order;
import com.example.dessertshopserver.R;

import java.util.List;

class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView name, harga, quantity, diskon;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        name = (TextView)itemView.findViewById(R.id.product_name);
        harga = (TextView)itemView.findViewById(R.id.product_harga);
        quantity = (TextView)itemView.findViewById(R.id.product_quantity);
        diskon = (TextView)itemView.findViewById(R.id.product_diskon);
    }
}

public class OrderDetailAdapter extends RecyclerView.Adapter<MyViewHolder>{

    List<Order> myOrders;

    public OrderDetailAdapter(List<Order> myOrders) {
        this.myOrders = myOrders;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_detail_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Order order = myOrders.get(position);
        holder.name.setText(String.format("Nama Dessert : %s",order.getProductName()));
        holder.quantity.setText(String.format("Jumlah Pesanan : %s",order.getQuantity()));
        holder.harga.setText(String.format("Harga : %s",order.getHarga()));
        holder.diskon.setText(String.format("Diskon : %s",order.getDiskon()));
    }

    @Override
    public int getItemCount() {
        return myOrders.size();
    }
}
