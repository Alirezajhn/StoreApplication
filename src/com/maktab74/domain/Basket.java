package com.maktab74.domain;

public class Basket extends Base {
    private int productId;
    private String category;
//    private Radio radio;
//    private Tv tv;
//    private ReadableItems readableItems;
//    private Shoes shoes;

    private int userId;
//    private User user;

    private int numberItem;


    //basket to user: one to one
    //basket to product: one to many
    public Basket() {

    }

    public Basket(int id, int productId, int userId, int numberItem, String category) {
        super(id);
        this.productId = productId;
        this.userId = userId;
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
