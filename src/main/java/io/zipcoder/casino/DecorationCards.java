package io.zipcoder.casino;

import io.zipcoder.casino.Games.DiceGames;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Symbols;


public class DecorationCards {

    Console console ;
    private String containerT = "";
    private String container1 = "";
    private String container2 = "";
    private String container3 = "";
    private String container4 = "";
    private String container5 = "";

    public DecorationCards(){
        this.console = new Console(System.in, System.out);
    }

    public void drawHand( Hand hand ){
        Symbols sym = new Symbols();
        String suitOfCard , rankOfCard = "";
        for (int i = 0; i < hand.getNumberOfCards(); i++) {
            rankOfCard =  String.valueOf( hand.getACard(i).getRank() );
            suitOfCard =  String.valueOf( hand.getACard(i).getSuit() );
            container1 += sym.switchFrame("lU") + String.format( sym.gethL(5) ) + sym.switchFrame("rU") ;
            container2 += sym.switchFrame("vL") + String.format("%s", sym.switchRank(rankOfCard).length() == 2 ? sym.switchRank(rankOfCard) : sym.switchRank(rankOfCard) + " ") + "   "+ sym.switchFrame("vL");
            container3 += sym.switchFrame("vL") + String.format("  " + "%s"  + "  ", sym.switchSuit(suitOfCard) ) + sym.switchFrame("vL");
            container4 += sym.switchFrame("vL") + String.format("   %2.2s", sym.switchRank(rankOfCard).length() == 2 ? sym.switchRank(rankOfCard)  + "" : sym.switchRank(rankOfCard)) + sym.switchFrame("vL");
            container5 += sym.switchFrame("lD") + String.format( sym.gethL(5) + sym.switchFrame("rD") );
            fillContainer();
        }
        clearString();
        console.print(containerT);
    }

    public void drawDices(Integer[] dices){
        Symbols sym = new Symbols();
        for (int i = 0; i < dices.length; i++) {
            container1 += sym.switchDie(dices[i])[0];
            container2 += sym.switchDie(dices[i])[1];
            container3 += sym.switchDie(dices[i])[2];
            container4 += sym.switchDie(dices[i])[3];
            container5 += sym.switchDie(dices[i])[4];
            fillContainer();
        }
        clearString();
        console.print(containerT);
    }

    public void clearString(){
        this.container1 = "";
        this.container2 = "";
        this.container3 = "";
        this.container4 = "";
        this.container5 = "";
    }

    public void fillContainer(){
        this.containerT = this.container1 + "\n" + this.container2 + "\n"
                + this.container3 + "\n" + this.container4 + "\n" + this.container5;
    }

//    public static void main(String[] args) {
//        DecorationCards decoration = new DecorationCards();
//        DiceGames setDices = new DiceGames();
//        Die die = new Die();
//        Symbols sym = new Symbols();
//        Integer[] number = new Integer[]{3,3,3,4,5,6};
//        decoration.drawDices(number);
//    }


    public void setConsole(Console console){
        this.console = console;
    }

}
