import java.awt.*;
import java.util.ArrayList;

public class FreeHand extends Shape {
    class Point {
        public int x, y;
        public boolean end = false;
        public Color color;

        public Point(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    private boolean active;

    private ArrayList<Point> points = new ArrayList<>();

    public FreeHand(Color color) {
        super(0, 0, 0, 0, color, "FreeHand");
    }

    public void draw(Graphics g) {
        for (var i = 0; i < points.size() - 1; i++) {
            var first = points.get(i);
            var last = points.get(i + 1);

            if (first.end) continue;

            g.setColor(first.color);
            g.drawLine(first.x, first.y, last.x, last.y);
        }
    }

    public void addPoint(int x, int y) {
        points.add(new Point(x, y, this.color));
    }

    public void enable() {
        this.active = true;
    }

    public void disable() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public void markEnd() {
        if (points.size() == 0) return;

        points.get(points.size() - 1).end = true;
    }

    public void clear() {
        points.clear();
    }

    public boolean contains(int x, int y) {
        return false;
    }
}