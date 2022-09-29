package com.naren008.yummytummy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView productRecView;
    FloatingActionButton floatingCart;
    List<ModelProduct> modelProducts;
    productAdapter productadapter;
    TextView cartCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productRecView = findViewById(R.id.productRecView);
        floatingCart = findViewById(R.id.floatingCart);
        productRecView.setHasFixedSize(true);
        cartCounter = findViewById(R.id.cartCounter);
        getCartCount();

        floatingCart.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Cart.class)));

        modelProducts = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        productRecView.setLayoutManager(linearLayoutManager);


        getProducts();
    }

    public void getCartCount() {
        CartCounter cartcounter = new CartCounter(MainActivity.this);
        int count = cartcounter.cartCount();
        cartCounter.setText(""+count);
    }

    private void getProducts() {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("product");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                modelProducts.clear();
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    ModelProduct modelProduct = snapshot1.getValue(ModelProduct.class);
                    modelProducts.add(modelProduct);
                    productadapter = new productAdapter(MainActivity.this, modelProducts,floatingCart);
                    productRecView.setAdapter(productadapter);

                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}