import javax.swing.*;
import java.awt.*;

public class TopBar extends JPanel {
    private JButton rectangle, triangle, cercle, freehand, clear, chooseColor;
    private JLabel currentShape, currentColor;
    private PaintPanel paintPanel;
    private static Color color = Color.black;
    private ColorUtils colorUtils = new ColorUtils();

    public TopBar(PaintPanel paintPanel) {
        this.paintPanel = paintPanel;
        setLayout(new FlowLayout());
        rectangle = new JButton("Rectangle");
        triangle = new JButton("Triangle");
        cercle = new JButton("Cercle");
        freehand = new JButton("Freehand");
        clear = new JButton("Clear");
        chooseColor = new JButton("Choose Color");

        currentShape = new JLabel("");
        currentColor = new JLabel(colorUtils.getColorNameFromColor(color));

        add(rectangle); add(triangle); add(cercle); add(freehand); add(clear); add(chooseColor); add(currentShape);
        add(currentColor);

        rectangle.addActionListener(new ButtonAction(currentShape));
        triangle.addActionListener(new ButtonAction(currentShape));
        cercle.addActionListener(new ButtonAction(currentShape));
        freehand.addActionListener(new ButtonAction(currentShape));

        rectangle.addActionListener((e) -> {
            paintPanel.disableFreehand();
            paintPanel.addShape(new Rectangle(100, 100, 100, 100, color));
        });

        triangle.addActionListener((event) -> {
            paintPanel.disableFreehand();
            paintPanel.addShape(new Triangle(100, 100, 100, 100, color));
        });

        cercle.addActionListener((event) -> {
            paintPanel.disableFreehand();
            paintPanel.addShape(new Cercle(100, 100, 100, color));
        });

        freehand.addActionListener((event) -> {
            paintPanel.enableFreehand();
        });

        clear.addActionListener((event) -> {
            paintPanel.clear();
        });

        chooseColor.addActionListener((event) -> {
            var chosen  = JColorChooser.showDialog(null, "Choose a color", color);
            if (chosen != null) {
                color = chosen;
                currentColor.setText(colorUtils.getColorNameFromColor(color));
            }

        });

    }

    public static Color getColor() {
        return color;
    }
}
