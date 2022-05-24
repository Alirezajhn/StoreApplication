package com.maktab74.domain;

public class Basket extends Base{
    private int  userId;
    private int productId;
    private int numberItem;
    private String category;

    public Basket(int id, int userId, int productId, int numberItem, String category) {
        super(id);
        this.userId = userId;
        this.productId = productId;
        this.numberItem = numberItem;
        this.category = category;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNumberItem() {
        return numberItem;
    }

    public void setNumberItem(int numberItem) {
        this.numberItem = numberItem;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
