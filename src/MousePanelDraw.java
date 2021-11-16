import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MousePanelDraw implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("Drag");
        //System.out.println("x=" + e.getX() + " y="+ e.getY());

        if (e.getSource().getClass() == PaintPanel.class) {
            PaintPanel paintPanel = (PaintPanel) e.getSource();
            paintPanel.addFreeHand(e.getX(), e.getY());
            paintPanel.moveShape(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("Move");
        //System.out.println("x=" + e.getX() + " y="+ e.getY());
    }

}
