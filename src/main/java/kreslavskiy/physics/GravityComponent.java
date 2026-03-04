package kreslavskiy.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent
{
    private Force force = new Force(37.0365, 28.9360);

    public void setForce(Force force)
    {
        this.force = force;
        repaint();
    }

    public Force getForce()
    {
        return force;
    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Projectile p = new Projectile(0, 0, force);

        g.setColor(Color.BLUE);
        for (int y = 0; y < getHeight(); y += 20)
        {
            g.drawLine(0, y, getWidth(), y);
        }
        for (int x = 0; x < getWidth(); x += 20)
        {
            g.drawLine(x, 0, x, getHeight());
        }

        g.setColor(Color.BLACK);
        g.translate(0, getHeight());                  //move origin to bottom left corner
        for (double i = 0; i < 5; i += 0.001)
        {
            p.apply(0.001);
            g.fillOval((int) (p.getX()), (int) (-p.getY()), 5, 5);
        }

        g.setColor(Color.GREEN);
        g.drawLine(0, 0, (int) force.getX(), (int) -force.getY());

    }
}
