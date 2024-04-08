package com.hipposocial.app.model;

public class Search {
    String name;
    String profileImage;

    public Search(String name, String profileImage) {
        this.name = name;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public String getProfileImage() {
        return profileImage;
    }
}
