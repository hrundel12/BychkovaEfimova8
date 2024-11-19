import javax.swing.*;
import java.awt.*;

public class ImageDisplayWindow extends JFrame {
    private final ImageIcon imageIcon;

    public ImageDisplayWindow(String imagePath) {
        setTitle("Image Display");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Загрузка изображения
        imageIcon = new ImageIcon(imagePath);

        // Проверка загрузки изображения
        if (imageIcon.getIconWidth() == -1) {
            System.out.println("Failed to load image from: " + imagePath);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (imageIcon.getIconWidth() != -1) {
            // Рисуем изображение
            g.drawImage(imageIcon.getImage(), 50, 50, this.getWidth() - 100, this.getHeight() - 100, this);
        } else {
            g.drawString("Image not found or cannot be loaded.", 50, 50);
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the image path as a command-line argument.");
            return;
        }

        String imagePath = args[0];
        SwingUtilities.invokeLater(() -> {
            ImageDisplayWindow window = new ImageDisplayWindow(imagePath);
            window.setVisible(true);
        });
    }
}