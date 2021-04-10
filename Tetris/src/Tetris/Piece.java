package Tetris;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * This class holds the seven different methods to be called in the factory
 * pattern switch statement to randomly generate the seven different pieces.
 */
public class Piece {
	private TetrisSquare[][] _board;
	private Game _game;
	private Boolean _setChecker;

	/**
	 * Instantiates the first possible piece as a 1D Array of type 
	 * TetrisSquare[] and loops through to add each square to the Array. This is
	 * logically adding the Piece to the game. The position of each square is
	 * then set via the respective coordinates from the 2D Array in Constants.
	 * The Piece is then checked to see if it can be added to the board. If it
	 * can be added, the Piece is then graphically added to the game's Pane. If
	 * not, this indicates there is not enough room to add the Piece (this newly
	 * generated Piece would not be able to move), and the game is ended by
	 * calling the public method from Game. This logically and graphically added
	 * piece is returned so that assignment can occur in the Game's switch
	 * statement.
	 */
	public TetrisSquare[] addPieceOne(Pane pane, TetrisSquare[][] board, 
			Game game) {
		TetrisSquare[] pieceOne = new TetrisSquare[4];
		for (int i = 0; i < 4; i++) {
			TetrisSquare pieceOnePart = new TetrisSquare(Color.RED, 
					Color.BLACK);
			pieceOnePart.setX(Constants.PIECE_ONE[i][0]);
			pieceOnePart.setY(Constants.PIECE_ONE[i][1]);
			pieceOne[i] = pieceOnePart;
			_board = board;
			_setChecker = true;

		}
		this.checkAdd(pieceOne);
		/*
		 * Adds pieceOne graphically to the board part by part -- otherwise ends
		 * the game if it cannot.
		 */
		for (int k = 0; k < 4; k++) {
			if (_setChecker == true) {
				pane.getChildren().add(pieceOne[k].getNode());
			} else {
				_game = game;
				_game.endGame();
			}
		}
		return pieceOne;
	}

	/**
	 * Adds second possible piece via same implementation as addPieceOne.
	 */
	public TetrisSquare[] addPieceTwo(Pane pane, TetrisSquare[][] board, 
			Game game) {
		TetrisSquare[] pieceTwo = new TetrisSquare[4];
		for (int i = 0; i < 4; i++) {
			TetrisSquare pieceTwoPart = new TetrisSquare(Color.ORANGE, 
					Color.BLACK);
			pieceTwoPart.setX(Constants.PIECE_TWO[i][0]);
			pieceTwoPart.setY(Constants.PIECE_TWO[i][1]);
			pieceTwo[i] = pieceTwoPart;
			_board = board;
			_setChecker = true;
		}
		this.checkAdd(pieceTwo);
		for (int k = 0; k < 4; k++) {
			if (_setChecker == true) {
				pane.getChildren().add(pieceTwo[k].getNode());
			} else {
				_game = game;
				_game.endGame();
			}
		}
		return pieceTwo;
	}

	/**
	 * Adds third possible piece via same implementation as addPieceOne.
	 */
	public TetrisSquare[] addPieceThree(Pane pane, TetrisSquare[][] board, 
			Game game) {
		TetrisSquare[] pieceThree = new TetrisSquare[4];
		for (int i = 0; i < 4; i++) {
			TetrisSquare pieceThreePart = new TetrisSquare(Color.YELLOW, 
					Color.BLACK);
			pieceThreePart.setX(Constants.PIECE_THREE[i][0]);
			pieceThreePart.setY(Constants.PIECE_THREE[i][1]);
			pieceThree[i] = pieceThreePart;
			_board = board;
			_setChecker = true;

		}
		this.checkAdd(pieceThree);
		for (int k = 0; k < 4; k++) {
			if (_setChecker == true) {
				pane.getChildren().add(pieceThree[k].getNode());
			} else {
				_game = game;
				_game.endGame();
			}
		}
		return pieceThree;
	}

	/**
	 * Adds fourth possible piece via same implementation as addPieceOne.
	 */
	public TetrisSquare[] addPieceFour(Pane pane, TetrisSquare[][] board, 
			Game game) {
		TetrisSquare[] pieceFour = new TetrisSquare[4];
		for (int i = 0; i < 4; i++) {
			TetrisSquare pieceFourPart = new TetrisSquare(Color.GREEN, 
					Color.BLACK);
			pieceFourPart.setX(Constants.PIECE_FOUR[i][0]);
			pieceFourPart.setY(Constants.PIECE_FOUR[i][1]);
			pieceFour[i] = pieceFourPart;
			_board = board;
			_setChecker = true;

		}
		this.checkAdd(pieceFour);
		for (int k = 0; k < 4; k++) {
			if (_setChecker == true) {
				pane.getChildren().add(pieceFour[k].getNode());
			} else {
				_game = game;
				_game.endGame();
			}
		}
		return pieceFour;
	}

	/**
	 * Adds fifth possible piece via same implementation as addPieceOne.
	 */
	public TetrisSquare[] addPieceFive(Pane pane, TetrisSquare[][] board, 
			Game game) {
		TetrisSquare[] pieceFive = new TetrisSquare[4];
		for (int i = 0; i < 4; i++) {
			TetrisSquare pieceFivePart = new TetrisSquare(Color.BLUE, 
					Color.BLACK);
			pieceFivePart.setX(Constants.PIECE_FIVE[i][0]);
			pieceFivePart.setY(Constants.PIECE_FIVE[i][1]);
			pieceFive[i] = pieceFivePart;
			_board = board;
			_setChecker = true;

		}
		this.checkAdd(pieceFive);
		for (int k = 0; k < 4; k++) {
			if (_setChecker == true) {
				pane.getChildren().add(pieceFive[k].getNode());
			} else {
				_game = game;
				_game.endGame();
			}
		}
		return pieceFive;
	}

	/**
	 * Adds sixth possible piece via same implementation as addPieceOne.
	 */
	public TetrisSquare[] addPieceSix(Pane pane, TetrisSquare[][] board, 
			Game game) {
		TetrisSquare[] pieceSix = new TetrisSquare[4];
		for (int i = 0; i < 4; i++) {
			TetrisSquare pieceSixPart = new TetrisSquare(Color.PURPLE, 
					Color.BLACK);
			pieceSixPart.setX(Constants.PIECE_SIX[i][0]);
			pieceSixPart.setY(Constants.PIECE_SIX[i][1]);
			pieceSix[i] = pieceSixPart;
			_board = board;
			_setChecker = true;

		}
		this.checkAdd(pieceSix);
		for (int k = 0; k < 4; k++) {
			if (_setChecker == true) {
				pane.getChildren().add(pieceSix[k].getNode());
			} else {
				_game = game;
				_game.endGame();
			}
		}
		return pieceSix;
	}

	/**
	 * Adds seventh possible piece via same implementation as addPieceOne.
	 */
	public TetrisSquare[] addPieceSeven(Pane pane, TetrisSquare[][] board, 
			Game game) {
		TetrisSquare[] pieceSeven = new TetrisSquare[4];
		for (int i = 0; i < 4; i++) {
			TetrisSquare pieceSevenPart = new TetrisSquare(Color.PINK, 
					Color.BLACK);
			pieceSevenPart.setX(Constants.PIECE_SEVEN[i][0]);
			pieceSevenPart.setY(Constants.PIECE_SEVEN[i][1]);
			pieceSeven[i] = pieceSevenPart;
			_board = board;
			_setChecker = true;

		}
		this.checkAdd(pieceSeven);
		for (int k = 0; k < 4; k++) {
			if (_setChecker == true) {
				pane.getChildren().add(pieceSeven[k].getNode());
			} else {
				_game = game;
				_game.endGame();
			}
		}
		return pieceSeven;
	}
	
	/**
	 * Checks whether a Piece can be graphically added to the board by logically
	 * checking whether each part of the Piece would be added to an occupied
	 * square. If any one of the squares are occupied, the initial Boolean is
	 * set to false and the Piece is not added.
	 */
	private void checkAdd(TetrisSquare[] piece) {
		for (int j = 0; j < 4; j++) {
			if (_board[(int) (piece[j].getX() 
					/ Constants.SQUARE_SIZE)][(int) (piece[j].getY()
					/ Constants.SQUARE_SIZE)] != null) {
				_setChecker = false;
			}
		}
	}
	
}