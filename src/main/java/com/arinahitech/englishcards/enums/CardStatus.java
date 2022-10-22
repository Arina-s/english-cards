package com.arinahitech.englishcards.enums;

public enum CardStatus {
    CREATED("created-icon.png"),
    IN_STUDYING("in-studying-icon.png"),
    LEARNED("learned-icon.png");

    private String imgName;

    CardStatus(String imgName) {
        this.imgName = imgName;
    }

    public String getImgName() {
        return this.imgName;
    }
}
