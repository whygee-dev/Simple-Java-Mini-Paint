import java.awt.*;

public class Cercle extends Shape{

    public Cercle(int x, int y, int r, Color color) {
        super(x, y, r, r, color, "Cercle");
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }

    public boolean contains(int x, int y) {
        return ((x - this.x - width / 2)*(x - this.x - width / 2)) + ((y - this.y - width / 2)*(y - this.y - width /2)) <= width*width/4;
    }
}
