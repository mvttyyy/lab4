package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void calculatesAreaCorrectly() {
        Triangle tri = new Triangle(6, 8, 10);
        assertEquals(24, tri.getArea(), 0.001);
    }

    @Test
    void calculatesPerimeterCorrectly() {
        Triangle tri = new Triangle(6, 8, 10);
        assertEquals(24, tri.getPerimeter());
    }

    @Test
    void assignsCustomColor() {
        Color color = new Color(0, 255, 0);
        Triangle tri = new Triangle(6, 8, 10, color);
        assertEquals(color, tri.color);
    }
}
