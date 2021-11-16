import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePanelnfo implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Clicked");
        //System.out.println("x=" + e.getX() + " y="+ e.getY());

        if (e.getSource().getClass() == PaintPanel.class) {
            PaintPanel paintPanel = (PaintPanel) e.getSource();
            paintPanel.mouseClic(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("Pressed");
        //System.out.println("x=" + e.getX() + " y="+ e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource().getClass() == PaintPanel.class) {
            PaintPanel paintPanel = (PaintPanel) e.getSource();
            paintPanel.mouseRelease();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("Entered");
        //System.out.println("x=" + e.getX() + " y="+ e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("Exited");
        //System.out.println("x=" + e.getX() + " y="+ e.getY());
    }
}
