/**This is the class that creates the AI. It includes the following:
 * @author Konstantinos Oikonomou
 * @version 2
 */

import java.util.Random;

public class AIOpponent{


    private final Random random = new Random();
    private Game g ;
    private int Difficulty;
    private int memoryLength;
    private int memoryLimit;
    private int rows;
    private int columns;
    private int a1;
    private int a2;
    private int b1;
    private int b2;
    private int a3;
    private int b3;
    private int memory[][];
    private int memory2[][];

    /**This is a constructor with:
     * @param rows an int that represents the rows of the table.
     * @param columns an int that represents the columns of the table.
     * @param Difficulty an int that represents the difficulty of the game.
     * @param g an object that sets the current game.
     */

    public AIOpponent(int rows, int columns, int Difficulty, Game g) {

        this.rows = rows;
        this.columns = columns;
        this.Difficulty = Difficulty;
        this.memoryLength = (rows*columns);
        this.memoryLimit = (rows*columns)*Difficulty;
        this.g = g;
        memory = new int[rows][columns];
        memory2 = new int[rows][columns];
        cardMemory();
    }

    /**This function:
     * @return a random int for the rows.
     */

    public int getRandoma() {
        return random.nextInt(rows);
    }

    /**This function:
     * @return a random int for the columns.
     */

    public int getRandomb() {
        return random.nextInt(columns);
    }

    /**This function:
     * @return a random int that sets when kangaroo saves a card in memory.
     */

    public int getRandom(){return random.nextInt(2);}

    /**This function sets a1 equal to a randomA and b1 to a randomB.
     */

    public void gamePlay(){
            a1 = getRandoma();
            b1 = getRandomb();
    }

    /**This function fills the memory with 0.
     */

    public void cardMemory(){
        int m = memoryLength;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(m > 0) {
                    memory[i][j] = 0;
                    m--;
                }
            }
        }
    }

    /**This function adds a card to memory.
     * @param a1 an int that represents the rows.
     * @param a2 an int that represents the columns.
     */

    public void fillMemory(int a1 , int a2) {
        if (memoryLimit > 0) {
            if (memory[a1][a2] == 0) {
                if(Difficulty == 1 && getRandom() == 1){
                    //Nope
                }else {
                    memory[a1][a2] = g.getTable(a1, a2).getCardValue();
                    if (Difficulty == 1) {
                        memoryLimit--;
                    }
                }
            }
        }
    }

    /**This function adds a card to memory.
     * @param a1 an int that represents the rows.
     * @param a2 an int that represents the columns.
     * @param g an object that sets the current game.
     */

    public void fillMemory2(int a1 , int a2,Game g) {
        if (memoryLimit > 0) {
            if (memory2[a1][a2] == 0) {
                if(Difficulty == 1 && getRandom() == 1){
                    //Nope
                }else {
                    memory2[a1][a2] = g.getTable(a1, a2).getCardValue();
                    if (Difficulty == 1) {
                        memoryLimit--;
                    }
                }
            }
        }
    }

    /** This function:
     * @return a boolean that shows if there is the same card in memory.
     */

    public boolean getCardforBattle(){
        for (int i1 = 0;i1 < rows;i1++){
            for (int j1 = 0;j1 < columns;j1++) {
                for (int i2 = 0; i2 < rows; i2++) {
                    for (int j2 = 0; j2 < columns; j2++) {
                        if(i1 != i2 || j1 != j2) {
                            if( memory[i1][j1] != 0 && memory2[i2][j2] != 0) {
                                if (memory[i1][j1] == memory2[i2][j2]) {
                                    a1 = i2;
                                    b1 = j2;
                                    memory[i1][j1] = 0;
                                    memory[i2][j2] = 0;
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**This function:
     * @return a boolean that shows if there are 2 same cards in memory.
     */

    public boolean getCardFromMemory() {
        for (int i1 = 0;i1 < rows;i1++){
            for (int j1 = 0;j1 < columns;j1++) {
                for (int i2 = 0; i2 < rows; i2++) {
                    for (int j2 = 0; j2 < columns; j2++) {
                        if(i1 != i2 || j1 != j2) {
                            if( memory[i1][j1] != 0 && memory[i2][j2] != 0) {
                                if (memory[i1][j1] == memory[i2][j2]) {
                                    a1 = i1;
                                    b1 = j1;
                                    a2 = i2;
                                    b2 = j2;
                                    memory[i1][j1] = 0;
                                    memory[i2][j2] = 0;
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**This function:
     * @return a boolean that shows if there are 3 same cards in memory.
     */

    public boolean getCardFromMemoryT() {
        for (int i1 = 0;i1 < rows;i1++){
            for (int j1 = 0;j1 < columns;j1++) {
                for (int i2 = 0; i2 < rows; i2++) {
                    for (int j2 = 0; j2 < columns; j2++) {
                        for (int i3 = 0; i3 < rows;i3++) {
                            for (int j3 = 0; j3 < rows; j3++) {
                                if ((i1 != i2 || j1 != j2)&&(i1 != i3 || j1 != j3)&&(i3 != i2 || j3 != j2)){
                                    if((memory[i1][j1] != 0 && memory[i2][j2] != 0 && memory[i3][j3] != 0)) {
                                        if (memory[i1][j1] == memory[i2][j2] && memory[i3][j3] == memory[i2][j2]) {
                                            a1 = i1;
                                            b1 = j1;
                                            a2 = i2;
                                            b2 = j2;
                                            a3 = i3;
                                            b3 = j3;
                                            memory[i1][j1] = 0;
                                            memory[i2][j2] = 0;
                                            memory[i3][j3] = 0;
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**These are the Getters for all the parameters.
     * @param i that represents the rows.
     * @param j that represents teh columns.
     */

    public int getMemory(int i , int j){return memory[i][j];}

    public int getMemory2(int i , int j){return memory2[i][j];}

    public int getA1() {
        return a1;
    }
    public int getB1() {
        return b1;
    }

    public int getA2() {
        return a2;
    }
    public int getB2() {
        return b2;
    }

    public int getA3(){
        return a3;
    }
    public int getB3(){
        return b3;
    }
}