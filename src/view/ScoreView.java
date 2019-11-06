package view;

import application.domain.DiceGame;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class ScoreView implements Observer {
	private Stage stage = new Stage();
	private Scene scoreScene;
	private Label scoreLabel;


	public ScoreView(DiceGame diceGame){
		diceGame.addObserver(this);
		scoreLabel = new Label();
		scoreLabel.setStyle("-fx-font-family: \"Courier new\"; -fx-font-size: 12; -fx-text-fill: darkred;");

		layoutComponents();
		stage.setScene(scoreScene);
		stage.setTitle("Score overview");
		stage.setResizable(false);		
		stage.setX(100);
		stage.setY(400);
		stage.show();
	}

	private void layoutComponents() {
		VBox root = new VBox();
		scoreScene = new Scene(root,400,200);
		root.getChildren().add(scoreLabel);
	}
	
	private void addScoreLine(String scoreLine){
		scoreLabel.setText(scoreLabel.getText()+"\n"+scoreLine);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof DiceGame && ((DiceGame) o).isTurnFinished()){
			DiceGame diceGame = (DiceGame)o;
				addScoreLine(String.format("Turn %d: pl1: %d pl2: %d pl3: %d",diceGame.getTurn()-1,
						diceGame.getPlayers().get(1).getTotalResult(), diceGame.getPlayers().get(2).getTotalResult(),
						diceGame.getPlayers().get(3).getTotalResult()));
		}
	}
}
