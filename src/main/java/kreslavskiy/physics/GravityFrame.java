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


        JPanel northPanel = new JPanel();

        JLabel xForce = new JLabel("ForceX:");
        northPanel.add(xForce);
        JTextField xField = new JTextField("37.0365");
        northPanel.add(xField);
        JLabel yForce = new JLabel("ForceY:");
        northPanel.add(yForce);
        JTextField yField = new JTextField("28.9360");
        northPanel.add(yField);
        JLabel timeLabel = new JLabel("Time:");
        northPanel.add(timeLabel);
        JTextField timeField = new JTextField("5");
        northPanel.add(timeField);
        JButton button = new JButton("Draw");
        northPanel.add(button);
        JLabel magLabel = new JLabel();
        northPanel.add(magLabel);
        JLabel angLabel = new JLabel();
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