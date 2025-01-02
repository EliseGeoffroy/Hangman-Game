package com.hangman.guessgame;

import java.util.ArrayList;

public class GuessGame {

    private int nbErrors;
    private final  static String[] hangingGuy={"____","|","|","|      /\\","|      |","|     \\O/","|      |","_______"};
    private final static int lifePoints=GuessGame.handingGuy.length();
    private  ArrayList<Character> buildingWord = new ArrayList<Character>();
    private String wordToWonder;
    private ArrayList<Character> wordToWonderTable= new ArrayList<Character>();

    /**
     * class Constructor => builds a list for the building word (with the good number of '_' and a list for the wordToWonder (in order to compare both lists)
     * @param wordToWonder
     */
    public GuessGame(String wordToWonder) {

        this.wordToWonder=wordToWonder;

        for (int i=0;i<wordToWonder.length();i++) {
            this.buildingWord.add('_');
        }

        for (int i=0;i<wordToWonder.length();i++) {
            this.wordToWonderTable.add(wordToWonder.charAt(i));
        }
    }

    /**
     * searchs the letter into the word to wonder and feeds the buildingWord
     * @param Letter
     */
    public void guessALetter(char Letter){
        var indexLetter = wordToWonder.indexOf(Letter);

        if (indexLetter != -1) {
            while (indexLetter != -1) {
                buildingWord.set(indexLetter,Letter);
                indexLetter = wordToWonder.indexOf(Letter, indexLetter + 1);
            }
        } else {
            System.out.println("Oups, il n'y a pas cette lettre dans mon mot... Un nouveau morceau de la potence apparaît :");
            for (int i = nbErrors; i > -1; i--) {
                System.out.println(hangingGuy[i]);
            }
            nbErrors++;
        }

    }

    /**
     * endOfGame Control : if both words are equals, the user has won
     * @return true if words are same
     */
    public boolean sameWord(){
        for (int i =0;i<wordToWonderTable.size();i++){
            if (wordToWonderTable.get(i)!=buildingWord.get(i)){
                return false;
            }
        }
        return true;
    }

    /**
     * endOfGame Control : if errors number is equal to life points, the user has lost
     * @return true if too many errors
     */
    public boolean noMoreLifePoints(){
        return nbErrors >= lifePoints;
    }

    /**
     * display game status. buildingWord is cast into a String in order to have a prettier display
     * @return
     */
    @Override
    public String toString() {
        String buildingWordString="";
        for (char character : buildingWord){
            buildingWordString += character;
        }
        return "Voici le mot en cours de construction : " + buildingWordString + ". Il vous reste encore " + (lifePoints-nbErrors) + ((lifePoints-nbErrors>1)?" tentatives":" tentative");
    }
}
