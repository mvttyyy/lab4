package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void invalidRedThrows() {
        assertThrowsWithMessage(() -> new Color(-10, 0, 0), "Error");
    }

    @Test
    void invalidGreenThrows() {
        assertThrowsWithMessage(() -> new Color(0, -5, 0), "Error");
    }

    @Test
    void invalidBlueThrows() {
        assertThrowsWithMessage(() -> new Color(0, 0, -3), "Error");
    }

    @Test
    void redTooHighThrows() {
        assertThrowsWithMessage(() -> new Color(300, 0, 0), "Error");
    }

    @Test
    void greenTooHighThrows() {
        assertThrowsWithMessage(() -> new Color(0, 300, 0), "Error");
    }

    @Test
    void blueTooHighThrows() {
        assertThrowsWithMessage(() -> new Color(0, 0, 300), "Error");
    }

    @Test
    void invalidAlphaThrows() {
        assertThrowsWithMessage(() -> new Color(0, 0, 0, -0.5f), "Error");
        assertThrowsWithMessage(() -> new Color(0, 0, 0, 1.5f), "Error");
    }

    @Test
    void validColorsPass() {
        assertDoesNotThrow(() -> new Color(0, 0, 0));
        assertDoesNotThrow(() -> new Color(255, 255, 255));
        assertDoesNotThrow(() -> new Color(100, 150, 200, 0.8f));
    }

    private void assertThrowsWithMessage(Runnable action, String expectedMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action::run);
        assertEquals(expectedMessage, exception.getMessage());
    }
}
