import java.awt.*;

public class Triangle extends Shape{
    private Polygon polygon = new Polygon();

    public Triangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color, "Triangle");
        polygon.xpoints = new int[] { x, x + width / 2, x + width };
        polygon.ypoints = new int[] { y + height, y, y + height };
        polygon.npoints = 3;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawPolygon(polygon);
    }

    @Override
    public boolean contains(int x, int y) {
        int nvert = polygon.npoints;
        var verty = polygon.ypoints;
        var vertx = polygon.xpoints;

        int i, j;
        boolean c = false;
        for (i = 0, j = nvert-1; i < nvert; j = i++) {
            if ( ((verty[i]>y) != (verty[j]>y)) &&
                    (x < (vertx[j]-vertx[i]) * (y-verty[i]) / (verty[j]-verty[i]) + vertx[i]) )
                c = !c;
        }

        return c;
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        polygon.xpoints = new int[] { x, x + width / 2, x + width };
        polygon.ypoints = new int[] { y + height, y, y + height };
    }
}
