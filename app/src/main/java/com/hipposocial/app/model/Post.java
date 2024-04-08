package com.hipposocial.app.model;

public class Post {

    String tilte;
    int image;
    String id;
    int type;



    public Post( String tilte, int image,String id, int type) {
        this.tilte = tilte;
        this.image = image;
        this.id = id;
        this.type = type;
    }

    public String getTilte() {
        return tilte;
    }

    public int getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    public int getType() {
        return type;
    }
}
