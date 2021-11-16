import java.awt.*;

public class Rectangle extends Shape{
    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color, "Rectangle");
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }

    @Override
    public boolean contains(int x, int y) {
        return (this.x + width >= x && this.x <= x) && (this.y + height >= y && this.y <= y) ;
    }
}
