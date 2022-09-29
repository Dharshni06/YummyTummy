package com.naren008.yummytummy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import p32929.androideasysql_library.Column;
import p32929.androideasysql_library.EasyDB;

public class Cart extends AppCompatActivity {

    List<ModelCart> modelCarts;
    CartAdapter cartAdapter;
    RecyclerView cartrecview;

    Button cartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartrecview = findViewById(R.id.cartRecView);
        cartrecview.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Cart.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        cartrecview.setLayoutManager(linearLayoutManager);

        modelCarts = new ArrayList<>();

        cartBtn = findViewById(R.id.cartBtn);
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("product");
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });






        //getcartitems();


    }

    /*private void getcartitems() {
        EasyDB easyDB = EasyDB.init(Cart.this, "product")
                .setTableName("ITEM TABLE")
                .addColumn(new Column("item_id", "text", "unique"))
                .addColumn(new Column("item_name", "text","not null"))
                .addColumn(new Column("item_price", "text","not null"))
                .addColumn(new Column("item_image", "text","not null"))
                .doneTableColumn();

        Cursor res = easyDB.getAllData();
        while(res.moveToNext()){
            String name = res.getString(1);
            String price = res.getString(2);
            String image = res.getString(3);

            ModelCart cartProduct = new ModelCart(name,price,image);
            modelCarts.add(cartProduct);
            cartAdapter = new CartAdapter(Cart.this, modelCarts);
            cartrecview.setAdapter(cartAdapter);
        }
    }*/
}