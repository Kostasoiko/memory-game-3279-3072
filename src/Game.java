/**This is the logic of the Basic and Double Version of the Card Game. It includes the following parameters:
 * @author Kostas Oikonomou
 * @version 2
 */

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private int rows;
    private int columns;
    private ArrayList<Card> cards;
    private Card[][] table;
    private final Random random = new Random();

    /**
     * This is a constructor with:
     * @param rows an int that represents the rows of the table.
     * @param columns an int that represents the columns of the table.
     */

    public Game(int rows,int columns)
    {
        cards = new ArrayList<>();
        table = new Card[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    /**
     * This function:
     * @return a random number for the card priority
     */

    public int getRandom() {return random.nextInt(cards.size());}

    public Card getTable(int i,int j){return table[i][j];}

    /**
     * This function creates the Card Items we need for this version of the game
     * and adds them to the cards list.
     */

    public void setCards(int numberOfCards,int sameCards)
    {
        int value = 1;
            for (int j = 0; j < (numberOfCards); j++)
            {
                if (value > (numberOfCards/sameCards)) {value = 1;}
                Card c = new Card(value,false);
                cards.add(c);
                value++;
            }
    }

    /**
     * This function fills the table with Card items from the cards list we created.
     */

    public void fillTableWithCards()
    {
        int a;
        for (int i = 0;i<table.length;i++){
            for (int j = 0;j<table[i].length;j++){
                a = getRandom();
                table[i][j] = cards.get(a);
                cards.remove(a);
            }
        }
    }


    /**
     * This function sets the cards' value to 0 if they have the same cardValue.
     * @param a is the player's first pick.
     * @param b is the player's second pick.
     * @return true is the cards have the same value or false if not.
     */

    public boolean areTheSame(int a,int b)
    {
        int a1=0,a2=0,b1=0,b2=0;
        for (int i = 0;i<table.length;i++) {
            for (int j = 0; j < table[i].length; j++)
            {
                if (i*columns + j == a){
                    a1 = i;
                    a2 = j;
                }
                if (i*columns + j == b){
                    b1 = i;
                    b2 = j;
                }
            }
        }
        if (table[a1][a2].getCardValue() == table[b1][b2].getCardValue()){
            table[a1][a2].setCardValue(0);
            table[b1][b2].setCardValue(0);
            table[a1][a2].setIsOpen(false);
            table[b1][b2].setIsOpen(false);
            return true;
        }
        return false;
    }

    /**
     * This function sets a delay.
     * @param time an int that represents the milliseconds of the delay.
     */
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception e) {}
    }

    /**
     * This function sets the cards' value to 0 if they have the same cardValue for the Triple Version.
     * @param a is the player's first pick.
     * @param b is the player's second pick.
     * @param c is the player's third pick.
     * @return true is the cards have the same value or false if not.
     */

    public boolean areTheSamet(int a,int b,int c)
    {
        int a1=0,a2=0,b1=0,b2=0,c1=0,c2=0;
        for (int i = 0;i<table.length;i++) {
            for (int j = 0; j < table[i].length; j++)
            {
                if (i*columns + j == a){
                    a1 = i;
                    a2 = j;
                }
                if (i*columns + j == b){
                    b1 = i;
                    b2 = j;
                }
                if (i*columns + j == c){
                    c1 = i;
                    c2 = j;
                }
            }
        }
        if (table[a1][a2].getCardValue() == table[b1][b2].getCardValue() && table[a1][a2].getCardValue() == table[c1][c2].getCardValue()){
            table[a1][a2].setCardValue(0);
            table[b1][b2].setCardValue(0);
            table[c1][c2].setCardValue(0);
            table[a1][a2].setIsOpen(false);
            table[b1][b2].setIsOpen(false);
            table[c1][c2].setIsOpen(false);
            return true;
        }
        table[a1][a2].setIsOpen(false);
        table[b1][b2].setIsOpen(false);
        table[c1][c2].setIsOpen(false);
        return false;
    }

    /** This is a getter for the arraylist of teh cards.
     * @return the cards.
     */
    public ArrayList<Card> getCards(){return cards;}
}
