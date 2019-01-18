/**This is the test for the Player Class
 * @author Kostas Oikonomou
 * @version 2
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player p = new Player("Player",0,0,0);

    /**
     * This function tests the Get Name function
     */

    @Test
    public void testGetName(){
        String output = p.getName();
        assertEquals("Player",output);
    }

    /**
     * This function test the Get Score function
     */

    @Test
    public void testGetScore(){
        int output = p.getScore();
        assertEquals(0,output);
    }

    /**
     * This function tests the Get Moves function
     */

    @Test
    public void testGetMoves(){
        int output = p.getMoves();
        assertEquals(0,output);
    }

    /**
     * This function tests the Get Wins function
     */

    @Test
    public void testGetWins(){
        int output = p.getWins();
        assertEquals(0,output);
    }

    /**
     * This function tests the Set Score function
     */

    @Test
    public void testSetScore(){
        p.setScore(15);
        int output = p.getScore();
        assertEquals(15,output);
    }

    /**
     * This function tests the Set Moves function
     */

    @Test
    public void testSetMoves(){
        p.setMoves(15);
        int output = p.getMoves();
        assertEquals(15,output);
    }

    /**
     * This function tests the Set Wins function
     */

    @Test
    public void testSetWins(){
        p.setWins(15);
        int output = p.getWins();
        assertEquals(15,output);
    }

}
