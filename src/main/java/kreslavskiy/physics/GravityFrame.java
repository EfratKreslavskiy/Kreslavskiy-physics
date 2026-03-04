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

        GravityComponent gravityComponent = new GravityComponent();
        GravityController gravityController = new GravityController(gravityComponent);


        gravityComponent.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                gravityController.updateForce(e.getX(), gravityComponent.getHeight() - e.getY());
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
                gravityController.updateForce(e.getX(), gravityComponent.getHeight() - e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {

            }
        });

        JButton button = new JButton("Draw");
        JTextField xField = new JTextField("37.0365");
        JTextField yField = new JTextField("28.9360");

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gravityController.updateForce(Double.parseDouble(xField.getText()),
                        Double.parseDouble(yField.getText()));

                gravityComponent.repaint();

            }
        });

        JTextField time = new JTextField("5");

        JLabel xForce = new JLabel("ForceX:");
        JLabel yForce = new JLabel("ForceY:");
        JLabel timeLabel = new JLabel("Time:");

        JPanel northPanel = new JPanel();
        JLabel angLabel = new JLabel();
        JLabel magLabel = new JLabel();
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