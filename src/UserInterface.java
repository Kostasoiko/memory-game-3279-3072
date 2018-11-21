/**This is the User Interface. It includes the following parameters:
 * @author Angelos Grigorakis
 * @version 1
 */

import java.util.Scanner;

public class UserInterface {

    /**
     * This function starts the game.
     */

    public void playGame() {
        Scanner s = new Scanner(System.in);
        int version, start;
        System.out.println("Welcome to the Memory Card Game!!");
        System.out.println("Press any Number to Start or 0 for Help!");
        start = s.nextInt();
        if (start == 0) {
            System.out.println("The numbers inside the cells ,[xx], represent the  position of the cards inside the Table");
            System.out.println("The numbers out of the cells represent the value of each card!!");
            System.out.println("To beat the Game simply collect all the Cards from the table");
        }
            System.out.println("Choose the version you want to play(1: Basic,2: Double,3: Triple): ");
            System.out.println("Any other Number to Exit: ");
            version = s.nextInt();
            switch (version) {

                /**
                 * This is the case of the player choosing to play the Basic Version.
                 * It creates the Game item with four rows and six columns for the table.
                 */

                case 1: {
                    Game g = new Game(4, 6);

                    /**
                     * int i represents the first card that the player picks.
                     * int j represents the second card that the player picks.
                     * int score represents how many pairs the player has found.
                     * int moves represents how many moves the player has done.
                     * int cardsLeft represents the cards that are still on the table.
                     */

                    int i, j, score = 0, moves = 0, cardsLeft = 24;
                    g.setCards(24, 2);
                    g.fillTableWithCards();
                    while (cardsLeft > 0) {
                        g.showTable();
                        System.out.println("\n Select two Cards: ");
                        i = s.nextInt();
                        j = s.nextInt();
                        if (i == j) {
                            System.out.println("You can't Pick the Same Card!");
                        }
                        else if (i < 0 || i > 23 || j < 0 || j > 23){
                            System.out.println("Number out of bounds!");
                        }
                        else {
                            g.showCards(i);
                            g.showCards(j);
                            g.showTable();
                            g.sleep(2500);
                            g.areTheSame(i, j);
                            if (g.areTheSame(i, j)) {
                                score++;
                                cardsLeft -= 2;
                            }
                            moves++;
                            System.out.println("\nMoves: " + moves);
                            System.out.println("Score: " + score);
                        }
                    }
                    System.out.println("Congratulation you completed the game with: ");
                    System.out.println("Moves: " + moves);
                    System.out.println("Score: " + score);
                    break;
                }

                /**
                 * This is the case of the player choosing to play the Double Version.
                 * It creates the Game item with six rows and eight columns for the table.
                 */

                case 2: {
                    Game g = new Game(6, 8);

                    /**
                     * int i represents the first card that the player picks.
                     * int j represents the second card that the player picks.
                     * int score represents how many pairs the player has found.
                     * int moves represents how many moves the player has done.
                     * int cardsLeft represents the cards that are still on the table.
                     */

                    int i, j, score = 0, moves = 0, cardsLeft = 48;
                    g.setCards(48, 2);
                    g.fillTableWithCards();
                    while (cardsLeft > 0) {
                        g.showTable();
                        System.out.println("\n Select two Cards: ");
                        i = s.nextInt();
                        j = s.nextInt();
                        if (i == j) {
                            System.out.println("You can't Pick the Same Card!");
                        }
                        else if (i < 0 || i > 47 || j < 0 || j > 47){
                            System.out.println("Number out of bounds!");
                        }
                        else {
                            g.showCards(i);
                            g.showCards(j);
                            g.showTable();
                            g.sleep(2500);
                            g.areTheSame(i, j);
                            if (g.areTheSame(i, j)) {
                                score++;
                                cardsLeft -= 2;
                            }
                            moves++;
                            System.out.println("Moves: " + moves);
                            System.out.println("Score: " + score);
                        }
                    }
                    System.out.println("Congratulation you completed the game with: ");
                    System.out.println("Moves: " + moves);
                    System.out.println("Score: " + score);
                    break;
                }

                /**
                 * This is the case of the player choosing to play the Triple Version.
                 * It creates the Game item with six rows and six columns for the table.
                 */

                case 3: {
                    TripleVersion t = new TripleVersion(6, 6);

                    /**
                     * int i represents the first card that the player picks.
                     * int j represents the second card that the player picks.
                     * int k represents the third card that the player picks.
                     * int score represents how many pairs the player has found.
                     * int moves represents how many moves the player has done.
                     * int cardsLeft represents the cards that are still on the table.
                     */

                    int i, j, k, score = 0, moves = 0, cardsLeft = 36;
                    t.setCards(36, 3);
                    t.fillTableWithCards();
                    while (cardsLeft > 0) {
                        t.showTable();
                        System.out.println("\n Select three Cards: ");
                        i = s.nextInt();
                        j = s.nextInt();
                        k = s.nextInt();
                        if ((i == j) || (i == k) || (j == k)) {
                            System.out.println("You can't Pick the Same Card!");
                        }
                        else if (i < 0 || i > 35 || j < 0 || j > 35 || k < 0 || k > 35){
                            System.out.println("Number out of bounds!");
                        }
                        else {
                            t.showCards(i);
                            t.showCards(j);
                            t.showCards(k);
                            t.showTable();
                            t.sleep(2500);
                            t.areTheSame(i, j, k);
                            if (t.areTheSame(i, j, k)) {
                                score++;
                                cardsLeft -= 3;
                            }
                            moves++;
                            System.out.println("\nMoves: " + moves);
                            System.out.println("Score: " + score);
                        }
                    }
                    System.out.println("Congratulation you completed the game with: ");
                    System.out.println("Moves: " + moves);
                    System.out.println("Score: " + score);
                    break;
                }

            }
            System.out.println("Thanks for playing!!!");

        }
}
