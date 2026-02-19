package kreslavskiy.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    private Force force = new Force(37.0365, 28.9360);

    public void setForce(Force force) {
        this.force = force;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.translate(0, getHeight());                  //move origin to bottom left corner

        //g.drawLine(0, 0, getWidth(), getHeight());
        //g.drawOval(30, 45, 20, 20);                    //draws outline of oval
        //g.fillOval(0, 0, 20, 20);                      //draws filled oval


        Projectile p = new Projectile(0, 0, force);

        for (double i = 0; i < 5; i += 0.001) {
            p.apply(0.001);
            g.fillOval((int) (p.getX()), (int) (-p.getY()), 5, 5);
        }
    }
}
