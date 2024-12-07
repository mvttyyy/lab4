package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeDAOTest {
    private SessionFactory sessionFactory;
    private ShapeDAO shapeDAO;

    @BeforeEach
    public void initialize() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        shapeDAO = new ShapeDAO(sessionFactory);
    }

    @AfterEach
    public void cleanUp() {
        shapeDAO.close();
    }

    @Test
    public void saveAndFindRectangle() {
        Rectangle rectangle = new Rectangle(6.0, 12.0);
        shapeDAO.saveShape(rectangle);

        Shape retrievedShape = shapeDAO.getShapeById(Rectangle.class, rectangle.id);
        assertNotNull(retrievedShape);
        assertEquals(rectangle.getWidth(), ((Rectangle) retrievedShape).getWidth(), 0.01);
        assertEquals(rectangle.getHeight(), ((Rectangle) retrievedShape).getHeight(), 0.01);
    }

    @Test
    public void retrieveAllShapes() {
        Rectangle rectangle = new Rectangle(6.0, 12.0);
        Triangle triangle = new Triangle(5.0, 12.0, 13.0);
        shapeDAO.saveShape(rectangle);
        shapeDAO.saveShape(triangle);
        List<? extends Shape> rectangles = shapeDAO.getAllShapes(Rectangle.class);
        List<? extends Shape> triangles = shapeDAO.getAllShapes(Triangle.class);
    }

    @Test
    public void updateRectangleWidth() {
        Rectangle rectangle = new Rectangle(6.0, 12.0);
        shapeDAO.saveShape(rectangle);

        rectangle = new Rectangle(8.0, 12.0);
        shapeDAO.updateShape(rectangle);

        Shape updatedShape = shapeDAO.getShapeById(Rectangle.class, rectangle.id);
        assertEquals(8.0, ((Rectangle) updatedShape).getWidth(), 0.01);
    }

    @Test
    public void removeRectangle() {
        Rectangle rectangle = new Rectangle(6.0, 12.0);
        shapeDAO.saveShape(rectangle);

        shapeDAO.deleteShape(rectangle);

        Shape deletedShape = shapeDAO.getShapeById(Rectangle.class, rectangle.id);
        assertNull(deletedShape);
    }
}
