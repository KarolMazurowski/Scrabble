import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Litery
{

    String literyArray[] = {"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};

    JPanel literyPanel = new JPanel();

    JTextField[] textFields;

    String wylosowaneLitery;

    public Litery()
    {

        textFields = new JTextField[7];
        for(int i =0; i<7; i++)
        {
            textFields[i] = pobierzL();
            literyPanel.add(textFields[i]);
        }



        literyPanel.setBounds(20,570,230,34);
        literyPanel.setLayout(new GridLayout());
        wylosowaneLitery = wylosowaneLitery.substring(4);
        System.out.println(wylosowaneLitery);
    }

   public Litery(String pozostale)
    {
        textFields = new JTextField[7];
        wylosowaneLitery = pozostale;
        char charAt;
        int iloscPozostalych = pozostale.length();
        for(int i =0; i<7 ; i++)
        {
            textFields[i] = pobierzL(wylosowaneLitery.charAt(i));
            literyPanel.add(textFields[i]);
        }
        literyPanel.setBounds(20,500,230,34);
        literyPanel.setLayout(new BorderLayout());
        System.out.println(wylosowaneLitery);
    }



    public Litery(String pozostale, int x)
    {
        char charAt;
        int iloscPozostalych = wylosowaneLitery.length();
        for(int i =0; i< 7; i++)
        {

                charAt = wylosowaneLitery.charAt(i);
                literyPanel.add(pobierzL(charAt));
        }
        literyPanel.setBounds(20,500,230,34);
        literyPanel.setLayout(new BorderLayout());
    }

    public JTextField pobierzL() {
        Random random = new Random();
        int numerlitery = random.nextInt(25);
        JTextField field = new JTextField(literyArray[numerlitery]);
        wylosowaneLitery = wylosowaneLitery + literyArray[numerlitery];
        field.setSize(new Dimension(32, 32));
        field.setEditable(false);
        field.setFont(new Font("Consolas", Font.PLAIN, 30));
        field.setDragEnabled(true);
        field.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                field.setSelectionStart(0);
                field.setSelectionEnd(field.getText().length());
            }
        });
        return field;
    }

    public JTextField pobierzL(char litera) {

        JTextField field = new JTextField();
        field.setText(String.valueOf(litera));
        field.setSize(new Dimension(32, 32));
        field.setEditable(false);
        field.setFont(new Font("Consolas", Font.PLAIN, 30));
        field.setDragEnabled(true);
        return field;
    }

    public void noweLitery(String litery)
    {
        literyPanel.removeAll();
        for(int i =0; i<7; i++)
        {

            textFields[i].setText(String.valueOf(litery.charAt(i)));

                System.out.println(textFields[i].getText());
                literyPanel.add(textFields[i]);

        }
    }


}

