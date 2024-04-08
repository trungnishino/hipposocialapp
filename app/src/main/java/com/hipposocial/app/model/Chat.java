package com.hipposocial.app.model;

public class Chat {

    String name;
    String image;
    String message;

    public Chat(String name, String image, String message) {
        this.name = name;
        this.image = image;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getMessage() {
        return message;
    }
}
