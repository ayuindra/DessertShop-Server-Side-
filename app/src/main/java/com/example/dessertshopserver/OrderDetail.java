package com.example.dessertshopserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.dessertshopserver.Common.Common;
import com.example.dessertshopserver.ViewHolder.OrderDetailAdapter;

import org.w3c.dom.Text;

public class OrderDetail extends AppCompatActivity {

    TextView order_id, order_phone, order_address, order_total, order_comment, order_name;
    String order_id_value = "";
    RecyclerView lstFoods;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        order_id = (TextView)findViewById(R.id.order_id);
        order_phone = (TextView)findViewById(R.id.order_phone);
        order_address = (TextView)findViewById(R.id.order_address);
        order_total = (TextView)findViewById(R.id.order_total);
        order_comment = (TextView)findViewById(R.id.order_comment);
        order_name = (TextView)findViewById(R.id.order_name);

        lstFoods = (RecyclerView)findViewById(R.id.lstFoods);
        lstFoods.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        lstFoods.setLayoutManager(layoutManager);

        if(getIntent() != null){
            order_id_value = getIntent().getStringExtra("OrderId");
        }

        //set value
        order_id.setText(order_id_value);
        order_phone.setText(Common.currentRequest.getPhone());
        order_total.setText(Common.currentRequest.getTotal());
        order_address.setText("Meja "+Common.currentRequest.getAlamat());
        order_comment.setText(Common.currentRequest.getComment());
        order_name.setText(Common.currentRequest.getName());

        OrderDetailAdapter adapter = new OrderDetailAdapter(Common.currentRequest.getDesserts());
        adapter.notifyDataSetChanged();
        lstFoods.setAdapter(adapter);
    }
}
