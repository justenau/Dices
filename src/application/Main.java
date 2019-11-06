package application;
	
import application.domain.DiceGame;
import application.domain.Die;
import application.domain.Player;
import javafx.application.Application;
import javafx.stage.Stage;
import view.PlayerView;
import view.ScoreView;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		DiceGame diceGame = new DiceGame();
		diceGame.addDie(new Die(6));
		diceGame.addDie(new Die(6));
		diceGame.addPlayer(player1);
		diceGame.addPlayer(player2);
		diceGame.addPlayer(player3);
		ScoreView scoreView  = new ScoreView(diceGame);
		PlayerView pv3 = new PlayerView(3,diceGame);
		PlayerView pv2 = new PlayerView(2,diceGame);
		PlayerView pv1 = new PlayerView(1,diceGame);
		pv1.isRolling(true);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
