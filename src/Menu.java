import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Menu {

    public Menu() {
        JFrame frame = new JFrame("Nowa Gra");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());
        frame.add(panel);



        JButton sayHelloButton = new JButton("Nowa gra");
        sayHelloButton.setBackground(Color.GREEN);
        sayHelloButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        sayHelloButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               LevelSelection levelSelection = new LevelSelection();
                frame.dispose();
            }
        });
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.RED);
        exitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(sayHelloButton);
        panel.add(exitButton);

        panel.add(Box.createVerticalGlue());


        frame.setVisible(true);

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setOpaque(true);
        backgroundLabel.setBackground(new Color(0, 0, 0, 0));
        backgroundLabel.setBounds(0, 0, 500, 500);
        panel.add(backgroundLabel);
    }
}
