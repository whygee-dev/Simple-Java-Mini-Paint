import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Shape {
    protected int x,y, width, height;
    protected String name;
    protected Color color;

    public Shape(int x, int y, int width, int height, Color color, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
        this.color = color;
    }

    public String toString() {
        return name + "(" + x + ", " + y + ")";
    }

    public abstract void draw(Graphics g);

    public void mouseClic(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }

    public abstract boolean contains(int x, int y);

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
