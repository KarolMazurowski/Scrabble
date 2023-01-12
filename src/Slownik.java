import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Slownik
{
    List<String> lines = new ArrayList<>();
    Set<String> set;

    public Slownik() throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader("Z:\\Scrabble\\src\\words.txt"));

        // Create an array list to store the lines of the file


        // Read the file line by line
        int i = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line.toLowerCase());
        }

        // Close the BufferedReader
        reader.close();

        set = new HashSet<>(lines);

    }

   synchronized public Boolean sprawdzanieSlowa(String slowo)
    {
        if (set.contains(slowo)) {
            System.out.println("Słowo znajduje się w zbiorze");
            return true;
        } else {
            System.out.println("Słowo nie znajduje się w zbiorze");
            return false;
        }

    }

}
