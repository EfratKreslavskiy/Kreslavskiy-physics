package kreslavskiy.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GravityFrame extends JFrame
{
    public GravityFrame()
    {
        setSize(300, 400);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JTextField xField = new JTextField("37.0365");
        JTextField yField = new JTextField("28.9360");

        JButton button = new JButton("Draw");

        JPanel northPanel = new JPanel();
        JLabel angLabel = new JLabel();
        JLabel magLabel = new JLabel();


        GravityComponent gravityComponent = new GravityComponent();

        gravityComponent.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Force force = new Force(e.getX(), gravityComponent.getHeight() - e.getY());
                gravityComponent.setForce(force);


                magLabel.setText("Magnitude: " + force.getMagnitude());
                angLabel.setText("Angle: " + force.getDegrees());

                gravityComponent.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });

        gravityComponent.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                Force force = new Force(e.getX(), gravityComponent.getHeight() - e.getY());
                gravityComponent.setForce(force);
                xField.setText(String.valueOf(force.getX()));
                yField.setText(String.valueOf(force.getY()));
                magLabel.setText("Magnitude: " + force.getMagnitude());
                angLabel.setText("Angle: " + force.getDegrees());

                gravityComponent.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {

            }
        });
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Force force = new Force(Double.parseDouble(xField.getText()), Double.parseDouble(yField.getText()));
                gravityComponent.setForce(force);
                xField.setText(String.valueOf(force.getX()));
                yField.setText(String.valueOf(force.getY()));
                magLabel.setText("Magnitude: " + force.getMagnitude());
                angLabel.setText("Angle: " + force.getDegrees());

                gravityComponent.repaint();

            }
        });

        JTextField time = new JTextField("5");

        JLabel xForce = new JLabel("ForceX:");
        JLabel yForce = new JLabel("ForceY:");
        JLabel timeLabel = new JLabel("Time:");

        northPanel.add(xForce);
        northPanel.add(xField);
        northPanel.add(yForce);
        northPanel.add(yField);
        northPanel.add(timeLabel);
        northPanel.add(time);
        northPanel.add(button);
        northPanel.add(magLabel);
        northPanel.add(angLabel);

        add(northPanel, BorderLayout.NORTH);
        add(gravityComponent, BorderLayout.CENTER);
    }

    static void main(String[] args)
    {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}