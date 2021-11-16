import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PaintPanel extends JPanel {
    protected int x, y;
    protected ArrayList<Shape> shapes;
    protected FreeHand freeHand;
    protected Shape selected;


    public PaintPanel(int x, int y) {
        super();
        shapes = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.freeHand = new FreeHand(TopBar.getColor());
    }

    public void addShape(Shape s) {
        shapes.add(s);
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape: shapes) {
            shape.draw(g);
        }

        freeHand.draw(g);
    }

    public void mouseClic(MouseEvent e) {
        //this.shapes.get(shapes.size() - 1).mouseClic(e);
        //this.repaint();
    }

    public void addFreeHand(int x, int y) {
        if (!freeHand.isActive()) return;

        if (!TopBar.getColor().equals(freeHand.getColor())) {
            this.freeHand.setColor(TopBar.getColor());
        }

        this.freeHand.addPoint(x, y);
        this.repaint();
    }

    public void enableFreehand() {
        freeHand.enable();
    }

    public void disableFreehand() {
        freeHand.disable();
    }

    public void mouseRelease() {
        System.out.println("mouse released");
        freeHand.markEnd();
        selected = null;
    }

    public void clear() {
        shapes.clear();
        freeHand.clear();
        this.repaint();
    }

    public void moveShape(int x, int y) {
        if (freeHand.isActive()) return;

        var found = findShapeAt(x, y);

        if (found != null) {
            if (selected == null) {
                selected = found;
            }
        }

        if (selected != null) {
            selected.move(x, y);
            this.repaint();
        }


    }

    private Shape findShapeAt(int x, int y) {
        for (Shape shape : shapes) {
            if (shape.contains(x,y)) return shape;
        }

        return null;
    }

}
