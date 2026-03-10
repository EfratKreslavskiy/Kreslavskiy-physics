package kreslavskiy.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent
{

    private Force force = new Force(37.0365, 28.9360);
    Projectile p = new Projectile(0, 0, force);
    private double time;

    public void setForce(Force force)
    {
        this.force = force;
        Projectile p = new Projectile(0, 0, force);
        repaint();
    }

    public Force getForce()
    {
        return force;
    }

    public void setTime(double time)
    {
        this.time = time;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.BLUE);                         //blue graph paper background
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

        p.apply(0.01);
        g.fillOval((int) (p.getX()), (int) (-p.getY()), 10, 10);

        double apxX = force.getX() * force.getY() / 9.8;
        double apxY = force.getY() * force.getY() / (-9.8 * 2);
        g.fillOval((int) apxX, (int) apxY, 10, 10);

        g.setColor(Color.GREEN);
        g.drawLine(0, 0, (int) force.getX(), (int) -force.getY());

    }
}
