package kreslavskiy.physics;

import javax.swing.*;

public class GravityController
{
    private final GravityComponent gravityComponent;
    private final JTextField xField;
    private final JTextField yField;
    private final JTextField timeField;
    private final JLabel angLabel;
    private final JLabel magLabel;
    private final JLabel apexLabel;

    public GravityController(GravityComponent gravityComponent, JTextField xField, JTextField yField,
                             JTextField timeField, JLabel angLabel, JLabel magLabel, JLabel apexLabel)
    {
        this.gravityComponent = gravityComponent;
        this.xField = xField;
        this.yField = yField;
        this.timeField = timeField;
        this.angLabel = angLabel;
        this.magLabel = magLabel;
        this.apexLabel = apexLabel;
    }

    public void updateForce(double x, double y)
    {
        Force force = new Force(x, y);
        gravityComponent.setForce(force);
        xField.setText(String.valueOf(x));
        yField.setText(String.valueOf(y));
        gravityComponent.setTime(Double.parseDouble(timeField.getText()));
        angLabel.setText("Angle: " + force.getDegrees());
        magLabel.setText("Magnitude: " + force.getMagnitude());
        double apx = y * y / (9.8 * 2);
        apexLabel.setText("Apex: " + apx);
        gravityComponent.repaint();
    }
}
