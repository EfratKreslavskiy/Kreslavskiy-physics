package kreslavskiy.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GravityFrame extends JFrame
{
    private final JTextField xField;
    private final JTextField yField;
    private final JTextField timeField;
    private final JLabel angLabel;
    private final JLabel magLabel;
    private final JLabel timeLabel;
    private final JLabel apexLabel;


    public GravityFrame()
    {
        setSize(800, 600);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());


        GridBagConstraints constraints;

        JLabel xForce = new JLabel("ForceX:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(xForce, constraints);

        xField = new JTextField("37.0365");
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(xField, constraints);

        JLabel yForce = new JLabel("ForceY:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(yForce, constraints);

        yField = new JTextField("28.9360");
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(yField, constraints);


        timeLabel = new JLabel("Time:");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(timeLabel, constraints);


        timeField = new JTextField("5");
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(timeField, constraints);

        magLabel = new JLabel("Magnitude: 46.99994072602645");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        add(magLabel, constraints);

        angLabel = new JLabel("Angle: 37.99991824426307");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        add(angLabel, constraints);

        apexLabel = new JLabel("Apex: 42.718984489795915");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        add(apexLabel, constraints);

        JButton button = new JButton("Draw");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.NORTH;
        add(button, constraints);

        GravityComponent gravityComponent = new GravityComponent();
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 7;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(gravityComponent, constraints);

        GravityController gravityController = new GravityController(gravityComponent, xField, yField, timeField,
                angLabel, magLabel, apexLabel);

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
                gravityComponent.repaint();
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