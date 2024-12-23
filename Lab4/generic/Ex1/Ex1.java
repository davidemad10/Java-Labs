import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static <T extends Shape> void drawShapes(List<T> shapes) {
        for (T shape : shapes) {
            shape.draw();
        }
    }

    public static void main(String[] args) {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());
        circles.add(new Circle());

        System.out.println("Drawing Rectangles:");
        drawShapes(rectangles);

        System.out.println("Drawing Circles:");
        drawShapes(circles);
    }
}
