import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to the Hangman Game! \n\nYou will be allowed 8 incorrect guesses before the Hangman meets his end." +
                "\nGuess wisely... his fate is in your hands!\n");

        System.out.printf("-----------\n" +
                " |        |\n" +
                "          |\n" +
                "          |\n" +
                "          |\n" +
                "          |\n" +
                "          |\n" +
                "------------------------\n");


        Game game = new Game();

        game.loadWordListAndSelectWord();
        game.loadMysteryWord();
        game.promptUserForLetter();

    }
}
