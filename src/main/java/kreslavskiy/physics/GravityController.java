package kreslavskiy.physics;

import javax.swing.*;

public class GravityController
{
    GravityComponent gravityComponent;
    JLabel xField;
    JLabel yField;
    JLabel angLabel;
    JLabel magLabel;

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
        angLabel.setText("Angle: " + force.getDegrees());
        magLabel.setText("Magnitude: " + force.getMagnitude());
        gravityComponent.repaint();
    }
}
