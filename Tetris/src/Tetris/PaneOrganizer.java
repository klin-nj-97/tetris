package Tetris;

import Cartoon.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * This is the top-level object class that will contain the different panes of
 * the application and delegate responsibility to the Game class.
 */
public class PaneOrganizer {
	private BorderPane _root;
	private Label _gameLabel;

	/**
	 * The constructor of the PaneOrganizer where the BorderPane, animation 
	 * pane, menu pane, responsive label, and responsive button are 
	 * instantiated. The label and button are then added to their appropriate 
	 * menu pane.
	 */
	public PaneOrganizer() {
		_root = new BorderPane();
		new Game(this);
		VBox menuPane = new VBox(Constants.VBOX_SPACING);
		menuPane.setPrefWidth(Constants.VBOX_WIDTH);
		menuPane.setAlignment(Pos.CENTER);
		_root.setRight(menuPane);
		_gameLabel = new Label("You know what to do.");
		Button button = new Button("Quit");
		button.setOnAction(new QuitHandler());
		menuPane.getChildren().addAll(_gameLabel, button);	
	}

	/**
	 * This method returns the BorderPane and is used in the App class to set 
	 * the scene.
	 */
	public BorderPane getRoot() {
		return _root;
	}

	/**
	 * This class implements the EventHandler interface to set the action of 
	 * the button to quitting the application.
	 */
	private class QuitHandler implements EventHandler<ActionEvent> {

		/**
		 * The method to execute the designated action.
		 */
		public void handle(ActionEvent event) {
			System.exit(0);
		}
	}
	
	/**
	 * This method updates the label to let the player know the game is over.
	 */
	public void gameOverLabel() {
		_gameLabel.setText("Game over");
	}
	
	/**
	 * This method updates the label to let the player know the game is paused.
	 */
	public void pauseLabel() {
		_gameLabel.setText("Paused");
	}
	
	/**
	 * This method updates the label to let the player know the game is 
	 * unpaused.
	 */
	public void resetLabel() {
		_gameLabel.setText("You know what to do.");
	}

}
