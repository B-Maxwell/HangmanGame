import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.*;

/**
 * Created by Ben Maxwell on 2/20/17.
 */
public class GameTest {

    @Test

    public void loadWordListAndSelectRandomWord() throws IOException {
        //load from word text file
        BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
        List<String> words = new ArrayList<>();
        String word = reader.readLine();

        while (word != null) {
            words.add(word);
            word = reader.readLine();
        }

        Random random = new Random();
        String randomWord = words.get(random.nextInt(words.size()));
        assertTrue(randomWord != null);

    }
}
