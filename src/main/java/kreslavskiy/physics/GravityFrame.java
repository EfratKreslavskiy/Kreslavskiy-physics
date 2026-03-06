package kreslavskiy.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GravityFrame extends JFrame
{
    private JTextField xField;
    private JTextField yField;
    private JTextField timeField;
    private JLabel angLabel;
    private JLabel magLabel;

    public GravityFrame()
    {
        setSize(300, 400);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        GravityComponent gravityComponent = new GravityComponent();

        JButton button = new JButton("Draw");
        JTextField xField = new JTextField("37.0365");
        JTextField yField = new JTextField("28.9360");
        JTextField timeField = new JTextField("5");

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
        northPanel.add(timeField);
        northPanel.add(button);
        northPanel.add(magLabel);
        northPanel.add(angLabel);

        add(northPanel, BorderLayout.NORTH);
        add(gravityComponent, BorderLayout.CENTER);

        GravityController gravityController = new GravityController(gravityComponent, xField, yField, timeField,
                angLabel, magLabel);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gravityController.updateForce(Double.parseDouble(xField.getText()),
                        Double.parseDouble(yField.getText()));
            }

        });

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

        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    gravityComponent.repaint();
                    try
                    {
                        Thread.sleep(16);
                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    static void main(String[] args)
    {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}