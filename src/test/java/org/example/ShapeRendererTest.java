package org.example;

import org.junit.jupiter.api.Test;

class ShapeRendererTest {

    @Test
    void renderRectangle() {
        Rectangle rect = new Rectangle(5, 7);
        ShapeRenderer.render(rect);
    }

    @Test
    void renderTriangle() {
        Triangle tri = new Triangle(6, 8, 10);
        ShapeRenderer.render(tri);
    }

    @Test
    void renderColoredShape() {
        Rectangle rect = new Rectangle(4, 6, new Color(0, 0, 255, 0.8f));
        ShapeRenderer.render(rect);
    }
}
