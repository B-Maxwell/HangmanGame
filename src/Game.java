import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Ben Maxwell on 2/20/17.
 */
public class Game {

    String randomWord;
    String mysteryWord;
    Scanner input = new Scanner(System.in);
    Integer incorrectGuess = 0;
    Integer correctGuess = 0;


    public void loadWordListAndSelectWord() throws IOException {
        //load from word text file
        BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
        List<String> words = new ArrayList<>();
        String word = reader.readLine();

        while (word != null) {
            words.add(word);
            word = reader.readLine();
        }

        // Choose a random word from the list
        Random random = new Random();
        randomWord = words.get(random.nextInt(words.size()));

    }

    public void loadMysteryWord() {

        String underscore = "_";
        mysteryWord = new String(new char[randomWord.length()]).replace("\0", underscore);

        System.out.println("Your mystery word contains " + randomWord.length() + " letters.\n");
        System.out.println(mysteryWord);

        System.out.println(randomWord); //ToDo remove this in final version
    }

    public void promptUserForLetter() {


        do {
            System.out.println("\nPlease guess a letter in the mystery word:");
            String guess = input.next();
            checkMysteryWordForLetter(guess);
        }

        while (incorrectGuess < 8 && correctGuess < randomWord.length());
    }

    public void checkMysteryWordForLetter(String letter) {
        if (randomWord.contains(letter)) {
            System.out.println("Good guess!");
            updateMysteryWordDisplay(letter);
        } else {
            incorrectGuess++;
            updateHangmanDisplay(incorrectGuess);
        }
    }

    private void updateHangmanDisplay(Integer incorrectGuess) {

        switch (incorrectGuess) {

            case 1:
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        "(         |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------\n");
                System.out.println("Sorry, that guess is incorrect. " + (8 - incorrectGuess) + " guesses left!");
                break;

            case 2:
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        "( )       |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------\n");
                System.out.println("Sorry, that guess is incorrect. " + (8 - incorrectGuess) + " guesses left!");
                break;

            case 3:
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        "( )       |\n" +
                        " |        |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------\n");
                System.out.println("Sorry, that guess is incorrect. " + (8 - incorrectGuess) + " guesses left!");
                break;

            case 4:
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        "( )       |\n" +
                        "\\|        |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------\n");
                System.out.println("Sorry, that guess is incorrect. " + (8 - incorrectGuess) + " guesses left!");
                break;

            case 5:
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        "( )       |\n" +
                        "\\|/       |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------\n");
                System.out.println("Sorry, that guess is incorrect. " + (8 - incorrectGuess) + " guesses left!");
                break;

            case 6:
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        "( )       |\n" +
                        "\\|/       |\n" +
                        " |        |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------\n");
                System.out.println("Sorry, that guess is incorrect. " + (8 - incorrectGuess) + " guesses left!");
                break;
            case 7:
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        "( )       |\n" +
                        "\\|/       |\n" +
                        " |        |\n" +
                        "/         |\n" +
                        "          |\n" +
                        "------------------------\n");
                System.out.println("Sorry, that guess is incorrect. " + (8 - incorrectGuess) + " guess left!");
                break;

            case 8:

                System.out.println("\nOh no! The hangman has met his fate...");
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        "( )       |\n" +
                        "/|\\       |\n" +
                        " |        |\n" +
                        "/ \\       |\n" +
                        "          |\n" +
                        "------------------------\n");
                System.out.println("The word was " + randomWord);
                break;


        }


    }

    private void updateMysteryWordDisplay(String letter) {

        char c = letter.charAt(0);
        StringBuilder word = new StringBuilder(mysteryWord);

        for (int i = 0; i < randomWord.length(); i++) {
            if (c == randomWord.charAt(i)) {
                word.setCharAt(i, c);
                correctGuess++;
            }
        }

        System.out.println(word);
        mysteryWord = word.toString();

        if (correctGuess == randomWord.length()) {
            System.out.println("Congratulations!! You saved the hangman!!\nThe word was " + randomWord);
        }
    }

}





