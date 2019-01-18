/**This is the Leader Board Class. It manages the files for the Leader Board
 * @author Kostas Oikonomou
 * @version 2
 */

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class LeaderBoard {

    private static LeaderBoard lBoard;
    private String filepath;
    private String highScores;

    private ArrayList<Integer> topScores;
    private ArrayList<Integer> topMoves;
    private ArrayList<Integer> topWins;
    private ArrayList<String> topPlayers;

    public LeaderBoard(){

        filepath = new File("").getAbsolutePath();
        highScores = "Scores";
        topScores = new ArrayList<>();
        topMoves = new ArrayList<>();
        topWins = new ArrayList<>();
        topPlayers = new ArrayList<>();
    }

    public static LeaderBoard getInstance(){
        if(lBoard == null){
            lBoard = new LeaderBoard();
        }
        return lBoard;

        /**This function adds a player to the leader board if his score is high enough
         *
         */


    }
    public void addPlayer(String name,int score,int moves,int wins){
        for(int i = 0; i < topPlayers.size();i++){
            if(score >= topScores.get(i)){
                topPlayers.add(i,name);
                //topPlayers.remove(topPlayers.size() -1);
                topScores.add(i,score);
                //topScores.remove(topScores.size() - 1);
                topMoves.add(i,moves);
                //topMoves.remove(topMoves.size() - 1);
                topWins.add(i,wins);
                //topWins.remove(topWins.size() - 1);
                return;
            }
        }
    }

    /**
     * This function loads the leader board scores
     */

    public void loadScores(){
        try{
            File f = new File(filepath,highScores);
            if(!f.isFile()){
               createSaveData();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

            topScores.clear();
            topMoves.clear();
            topWins.clear();
            topPlayers.clear();

            String[] scores = reader.readLine().split("-");
            String[] moves = reader.readLine().split("-");
            String[] wins = reader.readLine().split("-");
            String[] players = reader.readLine().split("-");

            for(int i =0;i<scores.length;i++){
                topScores.add(Integer.parseInt(scores[i]));
            }
            for(int i =0;i<moves.length;i++){
                topMoves.add(Integer.parseInt(moves[i]));
            }
            for(int i =0;i<wins.length;i++){
                topWins.add(Integer.parseInt(wins[i]));
            }
            for(int i =0;i<players.length;i++){
                topPlayers.add(players[i]);
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This function saves the scores to the file
     */

    public void saveScores(){
        FileWriter output = null;
        try{
            File f = new File(filepath,highScores);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);

            writer.write(topScores.get(0)+"-"+topScores.get(1)+"-"+topScores.get(2)+"-"+topScores.get(3)+"-"+topScores.get(4)+"-");
            writer.newLine();
            writer.write(topMoves.get(0)+"-"+topMoves.get(1)+"-"+topMoves.get(2)+"-"+topMoves.get(3)+"-"+topMoves.get(4)+"-");
            writer.newLine();
            writer.write(topWins.get(0)+"-"+topWins.get(1)+"-"+topWins.get(2)+"-"+topWins.get(3)+"-"+topWins.get(4)+"-");
            writer.newLine();
            writer.write(topPlayers.get(0)+"-"+topPlayers.get(1)+"-"+topPlayers.get(2)+"-"+topPlayers.get(3)+"-"+topPlayers.get(4)+"-");
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This function creates an empty file of the saved data if it doesn't exist
     */

    private void createSaveData(){
        FileWriter output = null;
        try{
            File f = new File(filepath,highScores);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);

            writer.write("0-0-0-0-0");
            writer.newLine();
            writer.write("0-0-0-0-0");
            writer.newLine();
            writer.write("0-0-0-0-0");
            writer.newLine();
            writer.write("Player-Player-Player-Player-Player");
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Theese are the getters for all the parameters
     */

    public int getHighScore(){
        return topScores.get(0);
    }
    public int getLessMoves(){
        return topMoves.get(0);
    }
    public int getMostWins(){
        return topWins.get(0);
    }
    public String getTopPlayer(){
        return topPlayers.get(0);
    }
    public ArrayList<Integer> getTopScores(){
        return topScores;
    }
    public ArrayList<Integer> getTopMoves(){
        return topMoves;
    }
    public ArrayList<Integer> getTopWins(){
        return topWins;
    }
    public ArrayList<String> getTopPlayers(){
        return topPlayers;
    }

}
