package com.hangman.verifEntry;

import java.util.ArrayList;

public class VerifEntry {

    private char Letter;
    private String entry;
    private ArrayList <Character> alreadyGivenCharacters;

    public VerifEntry(String entry, ArrayList <Character> alreadyGivenCharacters) {
        this.entry=entry;
        this.Letter=(!entry.isEmpty())?entry.charAt(0):'0';
        this.alreadyGivenCharacters=alreadyGivenCharacters;
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
        return (Letter>'z'||(Letter<'a'&&Letter>'Z')||Letter<'A');
    }

    /**
     * control entry
     * @return true if the letter has already been given by user, false if OK
     */
    public boolean letterAlreadyGiven(){
        return alreadyGivenCharacters.contains(this.Letter);
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
        return "Vous avez choisi la lettre :" + Letter;
    }


    public char getLetter() {
        return Letter;
    }
}
