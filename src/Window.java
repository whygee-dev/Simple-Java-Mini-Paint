import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private TopBar topBar;
    private PaintPanel paintPanel;

    public Window() {
        super("Java Paint");
        paintPanel = new PaintPanel(50, 25);
        topBar = new TopBar(paintPanel);
        paintPanel.addMouseListener(new MousePanelnfo());
        paintPanel.addMouseMotionListener(new MousePanelDraw());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720,480);
        add(topBar, BorderLayout.NORTH);
        add(paintPanel);
        setVisible(true);
        addMouseMotionListener(new MousePanelDraw());
    }
}
