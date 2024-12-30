

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] wordsTable={"cacahuete","joli","pirate","exceptionnel","fruit","couteau","poupee","pastis","hypermetrope","mezzanine"};
        String[] hangingGuy={"____","|","|","|      /\\","|      |","|     \\O/","|      |","_______"};

        var random=new Random();
        String wordToWonder=wordsTable[random.nextInt(wordsTable.length)];
        char[] buildingWord= new char[wordToWonder.length()];
        for (int i=0;i<wordToWonder.length();i++){
            buildingWord[i]='_';
        }
        
        int errorsNumber=0;
        

        while ((errorsNumber< hangingGuy.length)&&(!new String(buildingWord).equals(wordToWonder))) {

            System.out.println(buildingWord);

            char newLetter='0';
            String entry="bebe";

            while(((newLetter>'z')||(newLetter<'a'&&newLetter>'Z')||newLetter<'A')||(entry.length()!=1)) {

                System.out.println("Veuillez renseigner une nouvelle lettre");
                var scanner = new Scanner(System.in);
                entry=scanner.nextLine();
                newLetter=entry.charAt(0);

                if ((newLetter>'z')||(newLetter<'a')){
                    System.out.println("Nous avons bien dit \"LETTRE\" et non \"chiffre\", petit coquin!");
                }else if (entry.length()!=1){
                    System.out.println("Nous avons bien dit \"UNE\" lettre et non \"plusieurs\" lettres, petit coquin!");
                }
            }
            var indexLetter = wordToWonder.indexOf(newLetter);

            if (indexLetter != -1) {
                while (indexLetter != -1) {
                    buildingWord[indexLetter] = newLetter;
                    indexLetter = wordToWonder.indexOf(newLetter, indexLetter + 1);
                }
            } else {
                System.out.println("Oups, il n'y a pas cette lettre dans mon mot... Un nouveau morceau de la potence apparaît :");
                for (int i = errorsNumber; i > -1; i--) {
                    System.out.println(hangingGuy[i]);
                }
                errorsNumber++;
            }
        }
        if (errorsNumber== hangingGuy.length){
            System.out.println("Oups, vous avez perdu!, le mot était : "+wordToWonder);
        }else {
            System.out.println("Quel champion! Bravo! ");
            System.out.println("Le mot était bien: "+wordToWonder);
        }
    }
}