import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

 class MoveShape extends JFrame {
    private List<Shape> shapes;

    public MoveShape(String title) throws HeadlessException {
        super(title);
        shapes = new ArrayList<Shape>();
        shapes.add(new Rectangle(0, 0, 50, 50));
        shapes.add(new Polygon(new int[]{0, 70, 140, 100, 90}, new int[]{50, 14, 80, 240, 270}, 5));

        JButton button = new JButton("move");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Shape shape : shapes) {
                    if (shape instanceof Polygon) {
                        ((Polygon) shape).translate(50, 80);
                    }
                    if (shape instanceof Rectangle) {
                        ((Rectangle) shape).translate(100, 100);
                    }
                }
                repaint();
            }
        });
        add(button, BorderLayout.SOUTH);
        setSize(800,800);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(Color.BLACK);
        for (Shape shape : shapes) {
            g2.draw(shape);
        }
    }

    public static void main(String[] args) {
        MoveShape moveShape = new MoveShape("move painted shape.");
    }
}