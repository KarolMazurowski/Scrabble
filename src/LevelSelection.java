import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class LevelSelection {

    public LevelSelection() {
        JFrame frame = new JFrame("Łatwy");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());
        frame.add(panel);



        JButton sayHelloButton = new JButton("Łatwy");
        sayHelloButton.setBackground(Color.GREEN);
        sayHelloButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        sayHelloButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PointsValue.pointsValue = 300;
                GridFrame fra = null;
                try {
                    fra = new GridFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                fra.setTitle("Grid Frame");
                fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fra.pack();
                fra.setVisible(true);

                frame.dispose();
            }
        });
        JButton exitButton = new JButton("Trudny");
        exitButton.setBackground(Color.RED);
        exitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PointsValue.pointsValue = 600;
                GridFrame fra = null;
                try {
                    fra = new GridFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                fra.setTitle("Grid Frame");
                fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fra.pack();
                fra.setVisible(true);

                frame.dispose();
            }
        });

        JButton powrot = new JButton("Powrót");
        exitButton.setBackground(Color.RED);
        exitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Menu menu = new Menu();

            }
        });


        panel.add(sayHelloButton);
        panel.add(exitButton);
        panel.add(powrot);



        frame.setVisible(true);


    }
}