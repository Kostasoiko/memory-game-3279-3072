/**This is the test for the Game Class
 * @author Kostas Oikonomou
 * @version 2
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class GameTest {
    private Game g = new Game(2,2);

    /**
     * This function tests the Set Card function
     */

    @Test
    public void testSetCard(){
        g.setCards(4,2);
        g.getCards();
        int output = g.getCards().size();
        assertEquals(4,output);
    }

    /**
     * This function tests the Fill Table With Cards function
     */

    @Test
    public void testFillTableWithCards(){
        g.setCards(4,2);
        g.fillTableWithCards();
        int output = g.getCards().size();
        assertEquals(0,output);
        System.out.println();

    }

    /**
     * This function test the Get Table function
     */

    @Test
    public void testGetTable(){
        g.setCards(4,2);
        g.fillTableWithCards();
        boolean output = g.getTable(0,0).getIsOpen();
        assertFalse(output);
    }

    /**
     * This function tests the Are The Same function
     */

    @Test
    public void testAreTheSame(){
        g.setCards(4,2);
        g.fillTableWithCards();
        boolean output = g.areTheSame(0,1);
        if(g.getTable(0,0).getCardValue() == g.getTable(0,1).getCardValue()){
            assertTrue(output);
        }else{
            assertFalse(output);
        }
    }

    /**
     * This function tests the Are The Same T function
     */

    @Test
    public void testAreTheSameT(){
        g.setCards(4,2);
        g.fillTableWithCards();
        boolean output = g.areTheSamet(0,1,2);
        if(g.getTable(0,0).getCardValue() == g.getTable(0,1).getCardValue() && g.getTable(0,1).getCardValue() == g.getTable(1,0).getCardValue()){
            assertTrue(output);
        }else{
            assertFalse(output);
        }
    }
}
