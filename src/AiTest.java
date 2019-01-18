/**This is the test for the AiOponent class
 * @author Kostas Oikonomou
 * @version Beta 2.1
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AiTest {
    private Game g = new Game(4,4);
    private AIOpponent ai = new AIOpponent(4,4,1,g);

    /**
     * This function tests the Card Memory Function
     */

    @Test
    public void testCardMemory(){
        ai.cardMemory();
        int output = ai.getMemory(0,0);
        assertEquals(0,output);
    }

    /**
     * This function tests the Fill Memory Function
     */

    @Test
    public void testFillMemory(){
        g.setCards(16,2);
        g.fillTableWithCards();
        ai.fillMemory(1,1);
        int a = ai.getMemory(1,1);
        boolean output = true;
        if (a == 0) {
            output = false;
        }
        assertTrue(output);
    }

    /**
     * This function tests the Fill Memory 2 Function
     */

    @Test
    public void testFillMemory2(){
        g.setCards(16,2);
        g.fillTableWithCards();
        ai.fillMemory2(1,1,g);
        int a = ai.getMemory2(1,1);
        boolean output = true;
        if (a == 0) {
            output = false;
        }
        assertTrue(output);
    }

    /**
     * This function test the Get Card For Battle function
     */

    @Test
    public void testGetCardForBattle(){
        g.setCards(16,2);
        g.fillTableWithCards();
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 4;j++){
                ai.fillMemory(i,j);
                ai.fillMemory2(i,j,g);
            }
        }
        ai.getCardforBattle();
        boolean out = ai.getCardforBattle();
        assertTrue(out);
    }

    /**
     * This function tests the Get Card From Memory function
     */

    @Test
    public void testGetCardFromMemory(){
        g.setCards(16,2);
        g.fillTableWithCards();
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 4;j++){
                ai.fillMemory(i,j);
            }
        }
        boolean output = ai.getCardFromMemory();
        assertTrue(output);
    }

    /**
     * This function tests the Get Card From Memory T function
     */

    @Test
    public void testGetCardFromMemoryT(){
        g.setCards(36,3);
        g.fillTableWithCards();
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 4;j++){
                ai.fillMemory(i,j);
            }
        }
        boolean output = ai.getCardFromMemory();
        assertTrue(output);
    }
}
