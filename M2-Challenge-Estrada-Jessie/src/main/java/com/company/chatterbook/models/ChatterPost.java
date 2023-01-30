package com.company.chatterbook.models;

// ChatterPost Model Object
public class ChatterPost {
    private String text;

    public ChatterPost(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
