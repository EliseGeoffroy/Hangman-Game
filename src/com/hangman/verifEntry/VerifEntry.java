package com.hangman.verifEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerifEntry {

    private char letter;
    private String entry;
    private List<Character> alreadyGivenCharacters= new ArrayList <Character>() ;

    public VerifEntry() {
    }

public char getNewLetter(){
    do {
        System.out.println("Veuillez renseigner une nouvelle lettre");
        var scanner = new Scanner(System.in);
        entry = scanner.nextLine();
        letter=(!entry.isEmpty())?entry.charAt(0):'0';
        System.out.println(this);
    }
    while (this.entryTooLong() || this.letterIsNotALetter() ||this.letterAlreadyGiven());

    alreadyGivenCharacters.add(letter);

    return letter;
}

    /**
     * Control entryLength (we want only one character)
     * @return true if entryTooLong, false if OK
     */
    public boolean entryTooLong (){
        return (entry.length()!=1);
    }

    /**
     * Control entry
     * @return true if character is not a letter (cap or min), false if OK
     */
    public boolean letterIsNotALetter(){
        return (letter>'z'||(letter<'a'&&letter>'Z')||letter<'A');
    }

    /**
     * control entry
     * @return true if the letter has already been given by user, false if OK
     */
    public boolean letterAlreadyGiven(){
        return alreadyGivenCharacters.contains(this.letter);
    }

    /**
     * toString method override to return errormessages depending on the entry
     * @return
     */
    @Override
    public String toString() {
        if (this.entryTooLong()){
            return "Nous avons bien dit \"UNE\" lettre et non \"plusieurs\" lettres, petit coquin!";
        }else if (this.letterIsNotALetter()){
            return "Nous avons bien dit \"LETTRE\", petit coquin!";
        } else if (this.letterAlreadyGiven()){
            return "Vous avez déjà donné cette lettre. Pour rappel, les lettres que vous avez déjà essayées sont : "+ alreadyGivenCharacters;
        }
        return "Vous avez choisi la lettre :" + letter;
    }


    public char getLetter() {
        return letter;
    }
}
