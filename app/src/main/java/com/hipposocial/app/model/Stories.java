package com.hipposocial.app.model;

public class Stories {

    String imageUrl;
    String name;

    public Stories(String imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }
}
