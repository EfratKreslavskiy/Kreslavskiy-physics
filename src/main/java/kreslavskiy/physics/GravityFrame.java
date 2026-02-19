package kreslavskiy.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GravityFrame extends JFrame {
    public GravityFrame() {
        setSize(300, 400);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JTextField xField = new JTextField("37.0365");
        JTextField yField = new JTextField("28.9360");
        JTextField time = new JTextField("5");

        JLabel xForce = new JLabel("ForceX:");
        JLabel yForce = new JLabel("ForceY:");
        JLabel timeLabel = new JLabel("Time:");
        JLabel angleLabel = new JLabel("Angle:");
        JLabel magLabel = new JLabel("Magnitude:");

        JButton button = new JButton("Draw");

        GravityComponent gravityComponent = new GravityComponent();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravityComponent.setForce(
                        new Force(
                                Double.parseDouble(xField.getText()),
                                Double.parseDouble(yField.getText())
                        ));

            }
        });


        JPanel northPanel = new JPanel();               //only 1 per direction, so need panel that will hold many things
        northPanel.add(xForce);
        northPanel.add(xField);
        northPanel.add(yForce);
        northPanel.add(yField);
        northPanel.add(timeLabel);
        northPanel.add(time);
        northPanel.add(button);

        add(northPanel, BorderLayout.NORTH);

        add(gravityComponent, BorderLayout.CENTER);
    }

    static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}
