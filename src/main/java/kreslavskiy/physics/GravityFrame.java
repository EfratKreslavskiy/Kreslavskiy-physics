package kreslavskiy.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        GravityComponent gravityComponent = new GravityComponent();

        JPanel northPanel = new JPanel();
        JLabel angleLabel = new JLabel("Angle:");
        JLabel magLabel = new JLabel("Magnitude:");
        JTextField angleField = new JTextField();
        JTextField magField = new JTextField();

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gravityComponent.setForce(
                        new Force(
                                Double.parseDouble(xField.getText()),
                                Double.parseDouble(yField.getText())
                        ));

                String mag = String.valueOf(gravityComponent.getForce().getMagnitude());
                String ang = String.valueOf(gravityComponent.getForce().getDegrees());

                magField.setText(mag);
                angleField.setText(ang);

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
        northPanel.add(magField);
        northPanel.add(angleLabel);
        northPanel.add(angleField);

        add(northPanel, BorderLayout.NORTH);

        add(gravityComponent, BorderLayout.CENTER);
    }

    static void main(String[] args)
    {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}
