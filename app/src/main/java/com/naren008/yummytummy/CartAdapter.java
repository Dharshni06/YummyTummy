package com.naren008.yummytummy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    Context context;
    List<ModelCart> modelCartList;

    public CartAdapter(Context context, List<ModelCart> modelCartList) {
        this.context = context;
        this.modelCartList = modelCartList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_container,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String image = modelCartList.get(position).getImage();
        String price = modelCartList.get(position).getPrice();
        String name = modelCartList.get(position).getName();
        holder.cartFoodCash.setText(price);
        holder.cartFoodName.setText(name);

        Glide.with(holder.cartFoodImg.getContext())
                .load(image)
                .placeholder(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark)
                .error(R.drawable.ic_launcher_background)
                .into(holder.cartFoodImg);

    }

    @Override
    public int getItemCount() {
        return modelCartList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cartFoodImg;
        TextView cartFoodName, cartFoodCash;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cartFoodImg = itemView.findViewById(R.id.cartFoodImg);
            cartFoodName = itemView.findViewById(R.id.cartFoodName);
            cartFoodCash = itemView.findViewById(R.id.cartFoodCash);
        }
    }
}
