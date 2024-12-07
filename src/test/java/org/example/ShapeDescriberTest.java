package org.example;

import org.junit.jupiter.api.Test;

class ShapeDescriberTest {

    @Test
    void describeRectangle() {
        ShapeDescriber describer = new ShapeDescriber();
        Rectangle rect = new Rectangle(6.0, 8.0, new Color(255, 255, 0, 0.9f));
        describer.describe(rect);
    }

    @Test
    void describeTriangle() {
        ShapeDescriber describer = new ShapeDescriber();
        Triangle tri = new Triangle(5.0, 12.0, 13.0, new Color(0, 0, 255, 0.5f));
        describer.describe(tri);
    }
}
