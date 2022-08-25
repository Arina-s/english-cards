package com.arinahitech.englishcards.enums;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public enum CardStatus {
    CREATED("created.png"),
    IN_STUDYING("in_studying.png"),
    LEARNED("learned.png");

    private String imgUrl;
    private String imgName;

    CardStatus(String imgName) {
        this.imgName = imgName;
        this.imgUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/status/image/" + imgName).toUriString();
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl(String imgUrl) {
        return this.imgUrl;
    }
}
