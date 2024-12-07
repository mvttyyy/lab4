package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main (String[]args){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        ShapeDAO shapeDAO = new ShapeDAO(sessionFactory);

        try {
            Rectangle rectangle1 = new Rectangle(5.0, 10.0);
            Rectangle rectangle2 = new Rectangle(3.0, 6.0);
            Rectangle rectangle3 = new Rectangle(7.0, 14.0);
            shapeDAO.saveShape(rectangle1);
            shapeDAO.saveShape(rectangle2);
            shapeDAO.saveShape(rectangle3);

            Triangle triangle1 = new Triangle(3.0, 4.0, 5.0);
            Triangle triangle2 = new Triangle(5.0, 12.0, 13.0);
            Triangle triangle3 = new Triangle(8.0, 15.0, 17.0);
            shapeDAO.saveShape(triangle1);
            shapeDAO.saveShape(triangle2);
            shapeDAO.saveShape(triangle3);

            List<Rectangle> rectangles = shapeDAO.getAllShapes(Rectangle.class);
            List<Triangle> triangles = shapeDAO.getAllShapes(Triangle.class);

            System.out.println("Rectangles:");
            rectangles.forEach(Rectangle::print);
            System.out.println("Triangles:");
            triangles.forEach(Triangle::print);
        } catch (Exception e) {
            logger.error("Error during database operations", e);
        } finally {
            shapeDAO.close();
        }
    }
}