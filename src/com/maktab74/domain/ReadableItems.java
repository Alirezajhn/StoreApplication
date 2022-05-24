package com.maktab74.domain;

public  class ReadableItems extends Product{
    private String title;
    private String brief;
    private String content;
    private String publisher;
    private String typeItems;

    public ReadableItems(int id, int unit, int price, String title, String brief, String content, String publisher, String typeItems) {
        super(id, unit, price);
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.publisher = publisher;
        this.typeItems = typeItems;
    }

    public String getTypeItems() {
       return typeItems;
   }

    public void setTypeItems(String typeItems) {
        this.typeItems = typeItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
