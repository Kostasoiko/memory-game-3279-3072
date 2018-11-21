/**This is the class that initializes the game. It includes the following:
 * @author Angelos Grigorakis
 * @version 1
 */

public class CardGameApp {

    /**
     * This is the main function of the game.
     * It creates a UserInterface item that starts the game.
     */
    public static void main(String[] args){
        UserInterface u = new UserInterface();
        u.playGame();
    }
}
