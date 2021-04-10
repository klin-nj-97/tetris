package Tetris;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * This class is responsible for dealing with the graphical animation, logical
 * data structuring, and handling of key inputs of the application. An Array
 * contains the board and each piece.
 */
public class Game {
	private Pane _pane;
	private PaneOrganizer _paneOrganizer;
	private TetrisSquare[][] _board;
	private Piece _piece;
	private TetrisSquare[] _nextPiece;
	private Timeline _moving;
	private MainKeyHandler _mainKeyHandler;
	private Boolean _rotateChecker;
	private Boolean _pauseChecker;
	private Boolean _endCheckerOne;

	/**
	 * The constructor that instantiates a pane to contain the graphical
	 * movement and then adds the board in this pane. It associates itself
	 * with the top-level object PaneOrganizer class in order to set the
	 * animation pane to the center of the PaneOrganizer's BorderPane and to
	 * update the label. More detail regarding this design choice in README. It
	 * calls the method to set up the Timeline responsible for having Pieces
	 * fall, the method to set up key inputs for moving and rotating Pieces, and
	 * the method to set up the key input for pausing Tetris.
	 */
	public Game(PaneOrganizer organizer) {
		_pane = new Pane();
		_pane.setPrefWidth(Constants.PANE_WIDTH);
		_pane.setPrefHeight(Constants.PANE_HEIGHT);
		_pane.setStyle("-fx-background-color: black;");
		_paneOrganizer = organizer;
		_paneOrganizer.getRoot().setCenter(_pane);
		this.setUpBoard();
		this.launchPiece();
		this.setupTimeHandler();
		this.setupMainKeyHandler();
		_pauseChecker = false; // Sets initial Boolean value for method below
		this.setupPauseKeyHandler();
	}

	/**
	 * Instantiates the board as a 2D Array of type TetrisSquare[][] and adds
	 * TetrisSquares only to the border via column-major nested for-loop.
	 * Border squares are each logically added to the Array and then graphically
	 * to the Pane.
	 */
	private void setUpBoard() {
		_board = new TetrisSquare[Constants.NUM_COLUMNS][Constants.NUM_ROWS];
		for (int col = 0; col < Constants.NUM_COLUMNS; col++) {
			for (int row = 0; row < Constants.NUM_ROWS; row++) {
				/*
				 * Corresponding row and column values for the border.
				 */
				if (row <= 1 || row >= 24 || col <= 1 || col >= 12) {
					TetrisSquare border = new TetrisSquare(Color.LIGHTGREY, 
							Color.BLACK);
					border.setX(col * Constants.SQUARE_SIZE);
					border.setY(row * Constants.SQUARE_SIZE);
					_board[col][row] = border;
					_pane.getChildren().add(_board[col][row].getNode());
				}
			}
		}
	}

	/**
	 * Via factory pattern in this switch-statement, a Piece is assigned to one
	 * of seven possible methods as each adds one of the seven possible Pieces.
	 * Only the square piece returns a false Boolean thereafter being added to
	 * the Pane because it is the only piece that does not rotate. Whichever
	 * Piece was added is then returned at the end of the method so that the
	 * falling Timeline can then act upon it.
	 */
	private TetrisSquare[] launchPiece() {
		_piece = new Piece();
		int num = (int) (Math.random() * 7);
		_nextPiece = null;
		switch (num) {
		case 0:
			_nextPiece = _piece.addPieceOne(_pane, _board, this);
			_rotateChecker = true;
			break;
		case 1:
			_nextPiece = _piece.addPieceTwo(_pane, _board, this);
			_rotateChecker = true;
			break;
		case 2:
			_nextPiece = _piece.addPieceThree(_pane, _board, this);
			_rotateChecker = true;
			break;
		case 3:
			_nextPiece = _piece.addPieceFour(_pane, _board, this);
			_rotateChecker = false;
			break;
		case 4:
			_nextPiece = _piece.addPieceFive(_pane, _board, this);
			_rotateChecker = true;
			break;
		
		case 5:
			_nextPiece = _piece.addPieceSix(_pane, _board, this);
			_rotateChecker = true;
			break;
		case 6:
			_nextPiece = _piece.addPieceSeven(_pane, _board, this);
			_rotateChecker = true;
			break;
		}
		return _nextPiece;
	}

	/**
	 * Instantiates a KeyFrame specifying how long the animation should run for
	 * and which event handler to use it with. Also instantiates the Timeline
	 * itself, sets the animation to play indefinitely, and then plays the 
	 * animation.
	 */
	private void setupTimeHandler() {
		KeyFrame moveFrame = new KeyFrame(Duration.seconds(Constants.DURATION), 
				new TimeHandler());
		_moving = new Timeline(moveFrame);
		_moving.setCycleCount(Animation.INDEFINITE);
		_moving.play();
	}

	/**
	 * Class to implement handle method specifying what should occur at the end
	 * of each KeyFrame for proper falling of each piece. This class implements
	 * EventHandler interface.
	 */
	private class TimeHandler implements EventHandler<ActionEvent> {
		private Boolean _fallChecker;

		/**
		 * Overrides the original handle method so as to check whether the piece
		 * can fall in the first place, continuing to fall the piece if it can
		 * via graphically moving it down one square size, and then logically
		 * adding it to the board's Array when it cannot.
		 */
		@Override
		public void handle(ActionEvent event) {
			_fallChecker = true;
			this.checkFall();
			if (_fallChecker == true) {
				for (int j = 0; j < 4; j++) {
					_nextPiece[j].setY(_nextPiece[j].getY() 
							+ Constants.SQUARE_SIZE);
				}
			} else {
				Game.this.addToBoard();
			}
		}

		/**
		 * Checks whether a piece must stop falling by checking whether any one
		 * of the graphical squares beneath each of the piece's parts is
		 * not null. If so, the initial Boolean in the handle method is set to
		 * false and the piece stops falling and is added to the board's Array.
		 */
		private void checkFall() {
			for (int i = 0; i < 4; i++) {
				if (_board[(int) ((_nextPiece[i].getX() 
						/ Constants.SQUARE_SIZE))][(int) ((_nextPiece[i].getY()
						+ Constants.SQUARE_SIZE) 
								/ Constants.SQUARE_SIZE)] != null) {
					_fallChecker = false;
				}
			}
		}
	}

	/**
	 * Instantiates and adds the KeyHandler responsible for moving and rotating
	 * a piece. Sets the focus to the animation pane so that other nodes do not
	 * grab focus.
	 */
	private void setupMainKeyHandler() {
		_mainKeyHandler = new MainKeyHandler();
		_pane.addEventHandler(KeyEvent.KEY_PRESSED, _mainKeyHandler);
		_pane.setFocusTraversable(true);
	}

	/**
	 * Class responsible for key input to move and rotate a piece via 
	 * implementing EventHandler interface.
	 */
	private class MainKeyHandler implements EventHandler<KeyEvent> {
		private Boolean _leftChecker;
		private Boolean _rightChecker;
		private Boolean _downChecker;
		private double _centerOfRotationX;
		private double _centerOfRotationY;
		private Double _originalX;
		private Boolean _dropChecker;
		
		/**
		 * Overrides the original handle method so as to allow movement left,
		 * right, and down, rotation, and dropping as far as a piece can drop
		 * with corresponding key inputs.
		 */
		@Override
		public void handle(KeyEvent e) {
			KeyCode keyPressed = e.getCode();
			switch (keyPressed) {
			/*
			 * For moving left, right, and down, the pattern is to declare an
			 * initial Boolean value, check whether the piece can move into the
			 * appropriate space, and then move the piece if it can.
			 */
			case LEFT:
				_leftChecker = true;
				this.checkLeft();
				if (_leftChecker == true) {
					for (int j = 0; j < 4; j++) {
						_nextPiece[j].setX(_nextPiece[j].getX() 
								- Constants.SQUARE_SIZE);
					}
				}
				break;
			case RIGHT:
				_rightChecker = true;
				this.checkRight();
				if (_rightChecker == true) {
					for (int j = 0; j < 4; j++) {
						_nextPiece[j].setX(_nextPiece[j].getX() 
								+ Constants.SQUARE_SIZE);
					}
				}
				break;
			case DOWN:
				_downChecker = true;
				this.checkDown();
				if (_downChecker == true) {
					for (int j = 0; j < 4; j++) {
						_nextPiece[j].setY(_nextPiece[j].getY() 
								+ Constants.SQUARE_SIZE);
					}
				} else {
					/*
					 * If it can no longer move down, it is added to the board's
					 * Array
					 */
					Game.this.addToBoard();
				}
				break;
			/*
			 * Each piece stores its center of rotation as its second part. The
			 * piece is checked to see if rotating is permissible and then
			 * rotates if so.
			 */
			case UP:
				_centerOfRotationX = _nextPiece[1].getX();
				_centerOfRotationY = _nextPiece[1].getY();
				this.checkRotate();
				if (_rotateChecker == true) {
					this.rotate();
				}
				break;
				/*
				 * Each piece checks whether a piece can move down one square,
				 * similar to how its done for the down arrow key input. If so,
				 * a while-loop keeps moving the piece down while down-movement
				 * conditions are met.
				 */
			case SPACE:
				_dropChecker = true;
				this.checkDrop();
				while (_dropChecker == true) {
					this.drop();
				}
				break;
			default:
				break;
			}
			e.consume(); // Only executes code specified above
		}
		
		/**
		 * Checks whether each square to the left of each of the Piece's parts
		 * is not null. If any one of the squares are not null, the initial
		 * Boolean is changed to false and moving the piece left is not
		 * executed in the handle method.
		 */
		private void checkLeft() {
			for (int i = 0; i < 4; i++) {
				if (_board[(int) ((_nextPiece[i].getX() 
						- Constants.SQUARE_SIZE)
						/ Constants.SQUARE_SIZE)][(int) (_nextPiece[i].getY() 
								/ Constants.SQUARE_SIZE)] != null) {
					_leftChecker = false;
				}
			}
		}
		
		/**
		 * Checks whether each square to the right of each of the Piece's parts
		 * is not null. If any one of the squares are not null, the initial
		 * Boolean is changed to false and moving the piece right is not
		 * executed in the handle method.
		 */
		private void checkRight() {
			for (int i = 0; i < 4; i++) {
				if (_board[(int) ((_nextPiece[i].getX() 
						+ Constants.SQUARE_SIZE)
						/ Constants.SQUARE_SIZE)][(int) (_nextPiece[i].getY() 
								/ Constants.SQUARE_SIZE)] != null) {
					_rightChecker = false;
				}
			}
		}
		
		/**
		 * Checks whether each square beneath of each of the Piece's parts
		 * is not null. If any one of the squares are not null, the initial
		 * Boolean is changed to false and moving the piece down is not
		 * executed in the handle method.
		 */
		private void checkDown() {
			for (int i = 0; i < 4; i++) {
				if (_board[(int) (_nextPiece[i].getX()
						/ Constants.SQUARE_SIZE)][(int) ((_nextPiece[i].getY() 
								+ Constants.SQUARE_SIZE)
								/ Constants.SQUARE_SIZE)] != null) {
					_downChecker = false;
				}
			}
		}
		
		/**
		 * Checks whether each square to be rotated into by each of the Piece's
		 * parts is not null. If any one of the squares are not null, the 
		 * initial Boolean is changed to false and rotating the piece is 
		 * not executed in the handle method.
		 */
		private void checkRotate() {
			for (int i = 0; i < 4; i++) {
				_originalX = _nextPiece[i].getX();
				if (_board[(int) ((_centerOfRotationX 
						- _centerOfRotationY 
						+ _nextPiece[i].getY())
						/ Constants.SQUARE_SIZE)][(int) ((_centerOfRotationY 
								+ _centerOfRotationX 
								- _originalX)
								/ Constants.SQUARE_SIZE)] != null) {
					_rotateChecker = false;
				}
			}
		}
		
		/**
		 * Rotates the piece via utilizing given equations for x and
		 * y-coordinates.
		 */
		private void rotate() {
			for (int j = 0; j < 4; j++) {
				_originalX = _nextPiece[j].getX();
				_nextPiece[j].setX(_centerOfRotationX 
						- _centerOfRotationY 
						+ _nextPiece[j].getY());
				_nextPiece[j].setY(_centerOfRotationY 
						+ _centerOfRotationX 
						- _originalX);
			}
		}
		
		/**
		 * Same code as checkDown except the corresponding Boolean for dropping
		 * a piece is changed.
		 */
		private void checkDrop() {
			for (int i = 0; i < 4; i++) {
				if (_board[(int) (_nextPiece[i].getX()
						/ Constants.SQUARE_SIZE)][(int) ((_nextPiece[i].getY() 
								+ Constants.SQUARE_SIZE)
								/ Constants.SQUARE_SIZE)] != null) {
					_dropChecker = false;
				}
			}
		}
		
		/**
		 * The first for-loop moves each part of a Piece down by one square. The
		 * second for-loop checks whether each square beneath each Piece after
		 * being moved down one square is not null. If so, the nested third
		 * for-loop adds each of that piece's parts to the board's Array. Per
		 * how Tetris works, any line is cleared if it full and the game is 
		 * ended if game-over conditions are met or continues if they are not.
		 */
		private void drop() {
			for (int j = 0; j < 4; j++) {
				_nextPiece[j].setY(_nextPiece[j].getY() 
						+ Constants.SQUARE_SIZE);
			}
			for (int i = 0; i < 4; i++) {
				if (_board[(int) (_nextPiece[i].getX()
						/ Constants.SQUARE_SIZE)][(int) ((_nextPiece[i].getY() 
								+ Constants.SQUARE_SIZE)
								/ Constants.SQUARE_SIZE)] != null) {
					for (int k = 0; k < 4; k++) {
						_board[(int) ((_nextPiece[k].getX() 
								/ Constants.SQUARE_SIZE))]
										[(int) (_nextPiece[k].getY() 
												/ Constants.SQUARE_SIZE)] 
														= _nextPiece[k];
					}

					Game.this.clearLine();
					Game.this.endGame();
					if (_endCheckerOne == false) {
						Game.this.launchPiece();
						_moving.play();
						_dropChecker = false;
					}
				}
			}
		}
	}

	/**
	 * Instantiates and adds the KeyHandler responsible for pausing the game. 
	 * Sets the focus to the animation pane so that other nodes do not grab 
	 * focus.
	 */
	private void setupPauseKeyHandler() {
		PauseKeyHandler pauseKeyHandler = new PauseKeyHandler();
		_pane.addEventHandler(KeyEvent.KEY_PRESSED, pauseKeyHandler);
		_pane.setFocusTraversable(true);
	}

	/**
	 * Class responsible for key input to pause the game.
	 */
	private class PauseKeyHandler implements EventHandler<KeyEvent> {
		
		/**
		 * Overrides the original handle method so as to pause the game upon
		 * pressing "P".
		 */
		@Override
		public void handle(KeyEvent e) {
			KeyCode keyPressed = e.getCode();
			if (keyPressed == KeyCode.P) {
				this.pause();
			}
			e.consume();
		}
		
		/**
		 * Uses a boolean to check whether the game is currently paused or not.
		 * If the game is currently paused, the Timeline is resumed to have
		 * pieces fall, the KeyHandler permitting moving and rotating Pieces is
		 * re-added, the label is updated to indicate the game is unpaused, and
		 * the Boolean is changed to false to indicate the game is unpaused. If
		 * the game is currently unpaused, the Timeline is stopped, the 
		 * KeyHandler for moving and rotating Pieces is removed, the label is
		 * updated to indicate the game is paused, and the Boolean is changed to
		 * true to indicate the game is paused.
		 */
		private void pause() {
			if (_pauseChecker == true) {
				_moving.play();
				_pane.addEventHandler(KeyEvent.KEY_PRESSED, _mainKeyHandler);
				_paneOrganizer.resetLabel();
				_pauseChecker = false;
			} else {
				_moving.stop();
				_pane.removeEventHandler(KeyEvent.KEY_PRESSED, _mainKeyHandler);
				_paneOrganizer.pauseLabel();
				_pauseChecker = true;
			}
		}
	}

	/**
	 * Adds the current falling piece to the board's Array via a for-loop. Per
	 * how Tetris works, any line is cleared if full and the game is ended if 
	 * game-over conditions are met or continues if they are not.
	 */
	private void addToBoard() {
		for (int k = 0; k < 4; k++) {
			_board[(int) ((_nextPiece[k].getX() 
					/ Constants.SQUARE_SIZE))][(int) (_nextPiece[k].getY()
					/ Constants.SQUARE_SIZE)] = _nextPiece[k];
		}
		this.clearLine();
		this.endGame();
		if (_endCheckerOne == false) {
			Game.this.launchPiece();
			_moving.play();
		}
	}

	/**
	 * Firstly checks whether any rows in the board are full in the first pair
	 * of for-loops. If so, each square in that full row is first removed 
	 * graphically from the pane and then logically from the board's Array via 
	 * assignment to null. Each row above a clear row is then moved down the
	 * board by one square.
	 */
	private void clearLine() {
		for (int row = 2; row < 24; row++) {
			/*
			 * Although this second nested for-loop appears to not be required,
			 * a piece occasionally loses focus to being movable and rotatable.
			 * Although not a bug, this is discussed in README.
			 */
			
			for (int col = 2; col < 12; col++) {
				/*
				 * Code for each square in a given row looped through
				 */
				if (_board[2][row] != null 
						&& _board[3][row] != null 
						&& _board[4][row] != null 
						&& _board[5][row] != null
						&& _board[6][row] != null 
						&& _board[7][row] != null 
						&& _board[8][row] != null
						&& _board[9][row] != null 
						&& _board[10][row] != null 
						&& _board[11][row] != null) {
					_pane.getChildren().remove(_board[2][row].getNode());
					_board[2][row] = null;
					_pane.getChildren().remove(_board[3][row].getNode());
					_board[3][row] = null;
					_pane.getChildren().remove(_board[4][row].getNode());
					_board[4][row] = null;
					_pane.getChildren().remove(_board[5][row].getNode());
					_board[5][row] = null;
					_pane.getChildren().remove(_board[6][row].getNode());
					_board[6][row] = null;
					_pane.getChildren().remove(_board[7][row].getNode());
					_board[7][row] = null;
					_pane.getChildren().remove(_board[8][row].getNode());
					_board[8][row] = null;
					_pane.getChildren().remove(_board[9][row].getNode());
					_board[9][row] = null;
					_pane.getChildren().remove(_board[10][row].getNode());
					_board[10][row] = null;
					_pane.getChildren().remove(_board[11][row].getNode());
					_board[11][row] = null;
					/*
					 * After graphical and logical removal, each row from the
					 * row above the cleared row until the top of the board
					 * is shifted down graphically first via setter and getter
					 * functions and then logically via assigning each square
					 * to the corresponding square beneath it.
					 */
					for (int i = row; i > 2; i--) {
						for (int j = 2; j < 12; j++) {
							if (_board[j][i - 1] != null) {
								_board[j][i - 1].setY(_board[j][i - 1].getY() 
										+ Constants.SQUARE_SIZE);
							}
							_board[j][i] = _board[j][i - 1];
						}
					}
				}
			}
		}
	}

	/**
	 * If any of the squares in the top row are not null therefore occupied by
	 * a piece, the PaneOrganizer updates the label to let the user know the
	 * game is over, the KeyHandler for moving and rotating the piece is
	 * removed, and the Boolean is set to true so that the next piece is not
	 * launched and the Timeline for falling is not played. 
	 */
	public void endGame() {
		_endCheckerOne = false;
		int topRow = 2;
		if (_board[2][2] != null 
				|| _board[3][topRow] != null 
				|| _board[4][topRow] != null 
				|| _board[5][topRow] != null
				|| _board[6][topRow] != null 
				|| _board[7][topRow] != null 
				|| _board[8][topRow] != null 
				|| _board[9][topRow] != null
				|| _board[9][topRow] != null) {
			_paneOrganizer.gameOverLabel();
			_pane.removeEventHandler(KeyEvent.KEY_PRESSED, _mainKeyHandler);
			_endCheckerOne = true;
		}
	}
	
}