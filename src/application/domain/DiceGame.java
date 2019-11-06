package application.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class DiceGame extends Observable {

    private ArrayList<Die> dice;
    private HashMap<Integer,Player> players;
    private int turn;
    private Player currentPlayer;
    private boolean turnFinished;


    public DiceGame(){
        dice = new ArrayList<>();
        players = new HashMap<>();
        turn = 1;
    }

    public ArrayList<Die> getDice() {
        return dice;
    }

    public void setDice(ArrayList<Die> dice) {
        this.dice = dice;
    }

    public HashMap<Integer, Player> getPlayers() {
        return players;
    }

    public void setPlayers(HashMap<Integer,Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        players.put(player.getId(),player);
    }

    public void addDie(Die die){
        dice.add(die);
    }

    public void playTurn(int playerID){
        turnFinished=false;
        currentPlayer = players.get(playerID);
        for(Die die:dice) {
            die.roll();
        }
        int dice1Result = dice.get(0).getNumberShowing();
        int dice2Result = dice.get(1).getNumberShowing();
        int result = dice1Result == dice2Result ? dice1Result * 4 : dice1Result + dice2Result;
        result = currentPlayer.getPreviousThrowResult() == result ? result + 5 : result;
        currentPlayer.setPreviousThrowResult(result);
        currentPlayer.setTotalResult(currentPlayer.getTotalResult() + result);

        if (playerID ==3) {
            turn++;
            turnFinished = true;
        }
        setChanged();
        notifyObservers();
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isTurnFinished() {
        return turnFinished;
    }
}
