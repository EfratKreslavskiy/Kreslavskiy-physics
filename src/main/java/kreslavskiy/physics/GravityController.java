package kreslavskiy.physics;

import javax.swing.*;

public class GravityController
{
    private final GravityComponent gravityComponent;
    private JTextField xField;
    private JTextField yField;
    private JTextField timeField;
    private JLabel angLabel;
    private JLabel magLabel;

    public GravityController(GravityComponent gravityComponent, JTextField xField, JTextField yField, JTextField timeField, JLabel angLabel, JLabel magLabel)
    {
        this.gravityComponent = gravityComponent;
        this.xField = xField;
        this.yField = yField;
        this.timeField = timeField;
        this.angLabel = angLabel;
        this.magLabel = magLabel;
    }

    public GravityController(GravityComponent gravityComponent)
    {
        this.gravityComponent = gravityComponent;
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
    }
}
