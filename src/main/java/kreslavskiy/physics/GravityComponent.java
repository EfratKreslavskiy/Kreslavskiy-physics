package kreslavskiy.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(0, getHeight());

        //g.drawLine(0, 0, getWidth(), getHeight());
        //g.drawOval(30, 45, 20, 20);                    //draws outline of oval
        //g.fillOval(0, 0, 20, 20);                      //draws filled oval

        Force gravity = new Force(0, -9.8);
        Force scaledGravity = gravity.scale(0.001);

        double x = 0.0;
        double y = 0.0;
        Force f1 = new Force(37.0365, 28.9360);

        for (double i = 0; i < 5; i += 0.001) {
            f1 = f1.addForce(scaledGravity);
            Force scaledF1 = f1.scale(0.001);

            x += scaledF1.getX();
            y += scaledF1.getY();
            g.fillOval((int) (x), (int) (-y), 5, 5);

        }
    }
}
