package com.naren008.yummytummy;


public class ModelProduct {
    private String name;
    private String price;
    private String image;

    public ModelProduct() {
    }

    public ModelProduct(String foodName, String foodPrice, String image) {
        this.name = foodName;
        this.price = foodPrice;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFoodImg() {
        return image;
    }

    public void setFoodImg(String foodImg) {
        this.image = foodImg;
    }
}
