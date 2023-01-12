import java.util.HashMap;
import java.util.Map;

public class PointsCounter
{
   Map<Character, Integer> letterValues = new HashMap<>();

     void initLetterValues() {
        // Set the letter values
        letterValues.put('a', 10);
        letterValues.put('b', 30);
        letterValues.put('c', 30);
        letterValues.put('d', 20);
        letterValues.put('e', 10);
        letterValues.put('f', 40);
        letterValues.put('g', 20);
        letterValues.put('h', 40);
        letterValues.put('i', 10);
        letterValues.put('j', 80);
        letterValues.put('k', 50);
        letterValues.put('l', 10);
        letterValues.put('m', 30);
        letterValues.put('n', 10);
        letterValues.put('o', 10);
        letterValues.put('p', 30);
        letterValues.put('q', 10);
        letterValues.put('r', 10);
        letterValues.put('s', 10);
        letterValues.put('t', 10);
        letterValues.put('u', 10);
        letterValues.put('v', 40);
        letterValues.put('w', 40);
        letterValues.put('x', 80);
        letterValues.put('y', 40);
        letterValues.put('z', 10);
    }
    int obliczanie(String word)
    {
        int wynik = 0;
        for(int i = 0; i < word.length(); i++)
        {
             wynik = wynik + letterValues.get(word.charAt(i));
        }
        System.out.println(wynik);
        return wynik;
    }

}
