import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Абстрактный класс Shape
abstract class Shape {
    protected Color color;
    protected int x, y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    // Абстрактный метод для отрисовки фигуры
    public abstract void draw(Graphics g);
}

// Класс для круга
class Circle extends Shape {
    private int radius;

    public Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius, radius);
    }
}

// Класс для прямоугольника
class Rectangle extends Shape {
    private int width, height;

    public Rectangle(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

// Главное окно для отрисовки
public class RandomShapesWindow extends JFrame {
    private final Shape[] shapes = new Shape[20];

    public RandomShapesWindow() {
        setTitle("20 Random Shapes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Генерация случайных фигур
        Random random = new Random();
        for (int i = 0; i < shapes.length; i++) {
            int x = random.nextInt(750);
            int y = random.nextInt(550);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

            if (random.nextBoolean()) {
                int radius = random.nextInt(50) + 20;
                shapes[i] = new Circle(color, x, y, radius);
            } else {
                int width = random.nextInt(50) + 20;
                int height = random.nextInt(50) + 20;
                shapes[i] = new Rectangle(color, x, y, width, height);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RandomShapesWindow window = new RandomShapesWindow();
            window.setVisible(true);
        });
    }
}