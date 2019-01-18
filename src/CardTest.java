/**This is the test for the Card Class
 * @author Kostas Oikonomou
 * @version 2
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest{

    private Card c = new Card(5,false);

    /**
     * This function test the Get Card function
     */

    @Test
    public void testGetCardValue(){
        int output = c.getCardValue();
        assertEquals(5,output);
    }

    /**
     * This function test the Get Is Open function
     */

    @Test
    public void testGetIsOpen(){
        boolean output = c.getIsOpen();
        assertFalse(output);
    }

    /**
     * This function test the Set Card function
     */

   @Test
    public void testSetCardValue(){
        c.setCardValue(8);
        int output = c.getCardValue();
        assertEquals(8,output);
    }

    /**
     * This function test the Set Is Open function
     */

    @Test
    public void testSetIsOpen(){
        c.setIsOpen(true);
        boolean output = c.getIsOpen();
        assertTrue(output);
    }
}