package com.hipposocial.app.model;

public class Follow {
    String name;
    String profileImage;

    public Follow(String name, String profileImage) {
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
