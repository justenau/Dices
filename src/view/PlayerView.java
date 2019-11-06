package view;

import application.domain.DiceGame;
import application.domain.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class PlayerView implements Observer {
	private DiceGame diceGame;
	private Scene playerScene;
	private Label diceLabel; 
	private Button playButton; 
	private Label messageLabel; 
	
	private int playerID;
	
	public PlayerView(int playerID, DiceGame diceGame){
		this.playerID = playerID;
		this.diceGame = diceGame;
		diceGame.addObserver(this);
		diceLabel = new Label("Turn 1: ");
		playButton = new Button("Throw dice");
		playButton.setOnAction(new ThrowDicesHandler());
		playButton.setDisable(true);
		messageLabel = new Label("Game not yet started");
		layoutComponents();
		Stage stage = new Stage();
		stage.setScene(playerScene);
		stage.setTitle("Player "+playerID);
		stage.setResizable(false);		
		stage.setX(100+(playerID-1) * 350);
		stage.setY(200);
		stage.show();
	}

	private void layoutComponents() {
		VBox root = new VBox(10);
		playerScene = new Scene(root,250,100);
		root.getChildren().add(playButton);
		root.getChildren().add(diceLabel);
		root.getChildren().add(messageLabel);			
	}
	
	public void isRolling(boolean isRolling){
		playButton.setDisable(!isRolling);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof DiceGame){
			if (diceGame.getTurn()==5){
				diceLabel.setText("");
				messageLabel.setText("Game ended");
				isRolling(false);
				return;
			}
			messageLabel.setText("");
			if(diceGame.getCurrentPlayer().getId() == playerID) {
				diceLabel.setText(String.format("Turn %d: %d and %d - score: %d", diceGame.getTurn(),
						diceGame.getDice().get(0).getNumberShowing(), diceGame.getDice().get(1).getNumberShowing(),
						diceGame.getCurrentPlayer().getPreviousThrowResult()));
				isRolling(false);
			}
			else{
				diceLabel.setText(String.format("Player %d throws: %d and %d - score: %d",
						diceGame.getCurrentPlayer().getId(),diceGame.getDice().get(0).getNumberShowing(),
						diceGame.getDice().get(1).getNumberShowing(), diceGame.getCurrentPlayer().getPreviousThrowResult()));

				if(playerID - diceGame.getCurrentPlayer().getId() == 1){
					isRolling(true);
				} else if(playerID == 1){
					isRolling(true);
				}
			}
		}
	}

	class ThrowDicesHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            diceGame.playTurn(playerID);
        }
    }
}
