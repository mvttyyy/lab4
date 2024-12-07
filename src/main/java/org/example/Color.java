package org.example;

import jakarta.persistence.*;

@Embeddable
public record Color(int red, int green, int blue, float alpha) {
    public Color {
        if (red < 0 || green < 0 || blue < 0){
            throw new IllegalArgumentException("Invalid color");
        } else if (red > 255 || green > 255 || blue > 255){
            throw new IllegalArgumentException("Invalid color");
        }
        if (alpha < 0 || alpha > 1){
            throw new IllegalArgumentException("Invalid alpha");
        }
    }

    public Color(int red, int green, int blue) {
        this(red, green, blue, 0.0f);
    }
}