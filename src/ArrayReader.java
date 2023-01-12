import java.util.ArrayList;
import java.util.List;

public class ArrayReader
{
    String [][] tablica;
    ArrayList<String> arrayList = new ArrayList<String>();
public ArrayReader(String [][] tablica)
{
    this.tablica = tablica;
}

public List neighborFinder()
{
    StringBuilder sb = new StringBuilder();
    StringBuilder currentWord = new StringBuilder();


    for (int i = 0; i < tablica.length; i++) {
        currentWord.setLength(0);
        for (int j = 0; j < tablica[i].length; j++) {
            if (tablica[i][j].isEmpty()) {
                if (currentWord.length() > 1) {
                    arrayList.add(currentWord.toString().toLowerCase());
                    currentWord.setLength(0);
                }
            } else if (j > 0 && areElementsAdjacent(tablica, i, j, i, j-1)) {
                currentWord.append(tablica[i][j]);
            } else if (currentWord.length() > 1) {
                arrayList.add(currentWord.toString().toLowerCase());
                currentWord.setLength(0);
            }
        }
        if (currentWord.length() > 1) {
           arrayList.add(currentWord.toString().toLowerCase());
        }
    }


    for (int j = 0; j < tablica[0].length; j++) {
        currentWord.setLength(0);
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i][j].isEmpty()) {
                if (currentWord.length() > 1) {
                    arrayList.add(currentWord.toString().toLowerCase());
                    currentWord.setLength(0);
                }
            } else if (i > 0 && areElementsAdjacent(tablica, i, j, i-1, j)) {
                currentWord.append(tablica[i][j]);
            } else if (currentWord.length() > 1) {
                arrayList.add(currentWord.toString().toLowerCase());
                currentWord.setLength(0);
            }
        }
        if (currentWord.length() > 1) {
            arrayList.add(currentWord.toString().toLowerCase());
        }
    }

return arrayList;

}

    boolean areElementsAdjacent(String[][] array, int row1, int col1, int row2, int col2) {
        if (row1 == row2 && Math.abs(col1 - col2) == 1) {
            // Elementy są obok siebie w tej samej linii
            return true;
        }
        if (col1 == col2 && Math.abs(row1 - row2) == 1) {
            // Elementy są obok siebie w tej samej kolumnie
            return true;
        }
        return false;
    }


}
