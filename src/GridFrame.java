import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class GridFrame extends JFrame {
    private String[][] grid = new String[15][15];
    private JTextField[][] textFields = new JTextField[15][15];

    public String control[][] = new String[15][15];

    public Litery litery = new Litery();


    int points = PointsValue.pointsValue;

    Boolean przycisk = false;
    String wylosowaneLitery;


    TextDropTargetAdapter adapter = new TextDropTargetAdapter(textFields);

    JPanel gridPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel scorePanel = new JPanel();
    JLabel scoreLabel = new JLabel();

    JPanel corectPanel = new JPanel();

    JButton button = new JButton("Sprawdz słowo");
    HashSet set = new HashSet();



    public GridFrame() throws IOException {
        if(przycisk == false)
        {button.disable();}
        wylosowaneLitery = litery.wylosowaneLitery;
        wylosowaneLitery = wylosowaneLitery.substring(4);
        wylosowaneLitery = wylosowaneLitery.toLowerCase();

        if(points >0){scoreLabel.setText(String.valueOf(points));}
        corectPanel.setBounds(520,80,160,400);
        corectPanel.setBackground(new Color(169,169,169));
        corectPanel.setLayout(new FlowLayout());
        //add(corectPanel);
        scorePanel.add(scoreLabel);
        scorePanel.setBounds(500,30,200,30);
        scorePanel.setBackground(new Color(169,169,169));
        Slownik slownik = new Slownik();
        PointsCounter pointsCounter = new PointsCounter();
        pointsCounter.initLetterValues();
        buttonPanel.setSize(130,50);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setBounds(500,600,130, 50);
        gridPanel.setLayout(new GridLayout(15,15,2,2));
        gridPanel.setSize(518,518);
        setLayout(null);
        setPreferredSize(new Dimension(700, 700));
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                textFields[i][j] = new JTextField();
                control[i][j] = textFields[i][j].getText();
                textFields[i][j].setSize(new Dimension(32,32));
                textFields[i][j].setFont(new Font("Consolas",Font.PLAIN,30));
                textFields[i][j].setEditable(false);
                textFields[i][j].setDropMode(DropMode.INSERT);
                textFields[i][j].setDropTarget(new DropTarget(textFields[i][j],adapter));
                textFields[i][j].setColumns(1);
                int finalI = i;
                int finalJ = j;
                textFields[i][j].getDocument().addDocumentListener(new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {

                    }
                    public void removeUpdate(DocumentEvent e) {

                    }
                    public void insertUpdate(DocumentEvent e) {
                        for (int z = 0; z < 15; z++) {
                            for (int x = 0; x < 15; x++) {
                                if(textFields[z][x].getText().equals(control[z][x]) == true)
                                {

                                }
                                else
                                {

                                    for(int i =0; i<7; i++)
                                    {
                                        if(textFields[z][x].getText().toLowerCase().equals(litery.textFields[i].getText().toLowerCase()))
                                        {
                                            litery.wylosowaneLitery.replace(textFields[z][x].getText().toLowerCase(),"");
                                            litery.literyPanel.remove(litery.textFields[i]);
                                            break;
                                        }
                                    }
                                    repaint();
                                }
                            }
                        }

                    }

                });
                gridPanel.add(textFields[i][j]);

            }
        }


        button.setSize(130,50);
        buttonPanel.add(button);


        button.addActionListener(new ActionListener() {



            @Override
            public void actionPerformed(ActionEvent e) {
                corectPanel.removeAll();
                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 15; j++) {
                        grid[i][j] = textFields[i][j].getText();
                    }
                }
                ArrayReader arrayReader = new ArrayReader(grid);
                ArrayList<String> arr = new ArrayList<>(arrayReader.neighborFinder());
                points = PointsValue.pointsValue;
                for(String word: arr) {

                    if(slownik.sprawdzanieSlowa(word) == true)
                    {
                        String temp;
                        for (int i = 0; i < 15; i++) {
                            for (int j = 0; j < 15; j++) {
                                control[i][j] = textFields[i][j].getText();
                            }
                        }

                        points = points - pointsCounter.obliczanie(word);
                        temp = word + ": " + pointsCounter.obliczanie(word);
                        set.add(temp);
                        remove(litery.literyPanel);
                        litery = new Litery();
                        add(litery.literyPanel);
                        repaint();
                    }
                    else
                    {
                        for (int i = 0; i < 15; i++) {
                            for (int j = 0; j < 15; j++) {
                                textFields[i][j].setText(control[i][j]);
                            }
                        }
                        remove(litery.literyPanel);
                        litery = new Litery();
                        add(litery.literyPanel);
                        pack();

                    }

                }
                Iterator<String> iterator = set.iterator();
                    while(iterator.hasNext()) {
                        String element = iterator.next();
                        JLabel label = new JLabel(element);
                        label.setSize(160,20);
                        corectPanel.add(label);
                    }

                pack();
                repaint();
                scoreLabel.setText(String.valueOf(points));

            }


        });
        add(litery.literyPanel);
        add(gridPanel);
        add(buttonPanel);
        add(scorePanel);
    }
}


