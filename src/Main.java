

import com.hangman.guessgame.GuessGame;
import com.hangman.verifEntry.VerifEntry;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] wordsTable = {"cacahuete", "joli", "pirate", "exceptionnel", "fruit", "couteau", "poupee", "pastis", "hypermetrope", "mezzanine"};

        boolean newGame = true;

        while (newGame) {

            var random = new Random();
            String wordToWonder = wordsTable[random.nextInt(wordsTable.length)];

            var guessGame = new GuessGame(wordToWonder);
            var alreadyGivenCharacters = new ArrayList<Character>();

            while ((!guessGame.noMoreLifePoints()) && (!guessGame.sameWord())) {

                System.out.println(guessGame);


                var verifEntry = new VerifEntry("",alreadyGivenCharacters);

                do {
                    System.out.println("Veuillez renseigner une nouvelle lettre");
                    var scanner = new Scanner(System.in);
                    String entry = scanner.nextLine();
                    verifEntry = new VerifEntry(entry,alreadyGivenCharacters);
                    System.out.println(verifEntry);
                }
                while (verifEntry.entryTooLong() || verifEntry.letterIsNotALetter() || verifEntry.letterAlreadyGiven());

                alreadyGivenCharacters.add(verifEntry.getLetter());

                guessGame.guessALetter(verifEntry.getLetter());

            }
            if (guessGame.noMoreLifePoints()) {
                System.out.println("Oups, vous avez perdu!, le mot était : " + wordToWonder);
            } else {
                System.out.println("Quel champion! Bravo! ");
                System.out.println("Le mot était bien: " + wordToWonder);
            }


            System.out.println("Voulez-vous rejouer Y/N?");
            var scanner = new Scanner(System.in);
            boolean goodAnswer=false;
            do{

                switch (scanner.nextLine().charAt(0)){
                    case 'Y':
                    case 'y':
                        newGame=true;
                        goodAnswer=true;
                        break;
                    case 'N':
                    case 'n':
                        newGame=false;
                        goodAnswer=true;
                        break;
                    default:
                        goodAnswer=false;
                        System.out.println("Je n'ai pas compris, pouvez-vous répéter ? Répondez Y ou y pour oui et N ou n pour non.");
                }
            }while (!goodAnswer);
        }
    }
}