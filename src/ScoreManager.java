/**This is the Score Manager Class. Creates a temporary file that saves the current player's stats
 * @author Kostas Oikonomou
 * @version Beta 2.1
 */

import java.io.*;

public class ScoreManager {
    private int currentScore;
    private int currentTopScore;
    private int moves;
    private int topMoves;
    private int wins;
    private int rows;
    private int columns;
    private String player;
    private Player p;
    private int[] board = new int[rows*columns];
    private String filepath;
    private String temp;
    private boolean newGame;

    public ScoreManager(Player p,int rows , int columns){
        this.p = p;
        this.rows = rows;
        this.columns = columns;
        filepath = new File("").getAbsolutePath();
        temp = "Player";
        player = p.getName();
        createFile();
    }

    /**
     * This function resets the file
     */

    public void reset(){
        File f = new File(filepath,temp);
        if(f.isFile()){
            f.delete();
        }
        newGame = true;
        moves = 0;
        currentScore = 0;
        wins = 0;
        player = "player";
        temp = "temp";
    }

    /**
     * This function creates a temporary file
     */

    private void createFile(){
        FileWriter output = null;
        newGame = true;

        try{
            File f = new File(filepath,temp);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);
            //currentScore
            writer.write(""+0);
            writer.newLine();
            //currentTopScore
            writer.write(""+0);
            writer.newLine();
            //moves
            writer.write(""+0);
            writer.newLine();
            //TopMoves
            writer.write(""+0);
            writer.newLine();
            //wins
            writer.write(""+0);
            writer.newLine();
            //Player Name
            writer.write(""+"player");
            writer.newLine();

            for(int row = 0; row < rows;row++){
                for(int col=0;col < columns;col++){
                    if(row == rows - 1 && col == columns -1){
                        writer.write(""+0);
                    }else{
                        writer.write(0+"-");
                    }
                }
            }
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This function saves the stats of the player
     */


    public void saveGame(){
        FileWriter output = null;
        if(newGame){newGame = false;}
        try{
            File f = new File(filepath,temp);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);
            //currentScore
            writer.write(""+currentScore);
            writer.newLine();
            //currentTopScore
            writer.write(""+currentTopScore);
            writer.newLine();
            //moves
            writer.write(""+moves);
            writer.newLine();
            //TopMoves
            writer.write(""+topMoves);
            writer.newLine();
            //wins
            writer.write(""+wins);
            writer.newLine();
            //Player Name
            writer.write(""+player);
            writer.newLine();

            for(int row = 0; row < rows;row++){
                for(int col=0;col < columns;col++){
                    int location = row*columns + col;
                    this.board[location] = p.getScore();
                    if(row == rows - 1 && col == columns -1){
                        writer.write(""+board[location]);
                    }else{
                        writer.write(board[location] + "-");
                    }
                }
            }
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This function loads the save data for the player(Not if he exits the game)
     */

    public void loadGame(){
        try{
            File f = new File(filepath,temp);
            if(!f.isFile()){
                createFile();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

            currentScore = Integer.parseInt(reader.readLine());
            currentTopScore = Integer.parseInt(reader.readLine());
            moves = Integer.parseInt(reader.readLine());
            topMoves = Integer.parseInt(reader.readLine());
            wins = Integer.parseInt(reader.readLine());
            player = reader.readLine();

            String[] board = reader.readLine().split("-");
            for(int i = 0; i<board.length;i++){
                this.board[i] = Integer.parseInt(board[i]);
            }

            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Theese are the setters and getters for all the parameters
     */

    public void setPlayerName(String name){
        this.player = player;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setCurrentTopScore(int currentTopScore) {
        this.currentTopScore = currentTopScore;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public void setTopMoves(int topMoves) {
        this.topMoves = topMoves;
    }

    public void setWins(int wins){
        this.wins = wins;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getCurrentTopScore() {
        return currentTopScore;
    }

    public int getWins(){
        return wins;
    }

    public int getMoves() {
        return moves;
    }

    public int getTopMoves() {
        return topMoves;
    }

    public String getPlayerName(){
        return player;
    }

    public int[] getBoard() {
        return board;
    }

    public boolean newGame() {
        return newGame;
    }
}
