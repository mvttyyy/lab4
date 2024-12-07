package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void areaCalculation() {
        Rectangle rect = new Rectangle(4, 5);
        assertEquals(20, rect.getArea());
    }

    @Test
    void perimeterCalculation() {
        Rectangle rect = new Rectangle(4, 5);
        assertEquals(18, rect.getPerimeter());
    }

    @Test
    void colorAssignment() {
        Color color = new Color(0, 255, 0);
        Rectangle rect = new Rectangle(4, 5, color);
        assertEquals(color, rect.color);
    }
}
