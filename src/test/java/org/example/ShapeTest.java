package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void defaultColorIsWhite() {
        Shape shape = new Shape() {
            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };
        assertEquals(new Color(255, 255, 255, 0), shape.color);
    }

    @Test
    void customColorIsSet() {
        Shape shape = new Shape(new Color(100, 100, 100)) {
            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };
        assertEquals(new Color(100, 100, 100), shape.color);
    }

    @Test
    void printDoesNotThrow() {
        Shape shape = new Shape() {
            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };
        assertDoesNotThrow(shape::print);
    }

    @Test
    void colorDescriptionDoesNotThrow() {
        Shape shape = new Shape() {
            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };
        assertDoesNotThrow(shape::getColorDescription);
    }
}
