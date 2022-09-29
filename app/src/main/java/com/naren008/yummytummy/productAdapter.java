package com.naren008.yummytummy;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.Random;

import p32929.androideasysql_library.Column;
import p32929.androideasysql_library.EasyDB;

public class productAdapter extends RecyclerView.Adapter<productAdapter.MyViewHolder> {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    Context context;
    List<ModelProduct> modelProducts;
    FloatingActionButton floatingCart;

    public productAdapter(Context context, List<ModelProduct> modelProducts, FloatingActionButton floatingCart) {
        this.context = context;
        this.modelProducts = modelProducts;
        this.floatingCart = floatingCart;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_container,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //ModelProduct modelProduct = modelProducts.get(position);

        String name = modelProducts.get(position).getName();
        String price = modelProducts.get(position).getPrice();
        String image = modelProducts.get(position).getFoodImg();

        holder.foodName.setText(name);
        holder.foodCash.setText(price);
        Glide.with(holder.foodImg.getContext())
                .load(image)
                .placeholder(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark)
                .error(R.drawable.ic_launcher_background)
                .into(holder.foodImg);

     /*   holder.cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("cartProduct");
                reference.setValue("cart");
                //addToCart(name,price,image);

//                new CircleAnimationUtil().attachActivity((Activity)context).setTargetView(holder.foodImg).setMoveDuration(700).setDestView(floatingCart).setAnimationListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animator) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animator) {
//                        ((MainActivity)context).getCartCount();
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animator) {
//
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animator) {
//
//                    }
//                }).startAnimation();

            }
        });*/
    }

    public int id = 1;
   /* private void addToCart(String name, String price, String image) {

        Random random = new Random();
        id = random.nextInt(200000);

        EasyDB easyDB = EasyDB.init(context, "product")
                .setTableName("ITEM TABLE")
                .addColumn(new Column("item_id", "text", "unique"))
                .addColumn(new Column("item_name", "text","not null"))
                .addColumn(new Column("item_price", "text","not null"))
                .addColumn(new Column("item_image", "text","not null"))
                .doneTableColumn();

        Boolean b = easyDB.addData("item_id", id)
                .addData("item_name",name)
                .addData("item_price", price)
                .addData("item_image", image)
                .doneDataAdding();

        Toast.makeText(context, "Added to cart successfully", Toast.LENGTH_SHORT).show();

    }*/

    @Override
    public int getItemCount() {
        return modelProducts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView foodName, foodCash;
        ImageView foodImg;
        Button cartBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            foodName = itemView.findViewById(R.id.foodName);
            foodCash = itemView.findViewById(R.id.foodPrice);
            foodImg = itemView.findViewById(R.id.foodImg);
            cartBtn = itemView.findViewById(R.id.cartBtn);
        }
    }
}
