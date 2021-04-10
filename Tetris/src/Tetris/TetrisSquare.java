package Tetris;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The class responsible for the type of square the board's 2D Array will be 
 * made up of and the type of square each of the Pieces will be made up of.
 */
public class TetrisSquare {
	private Rectangle _structure;

	/**
	 * The constructor where a given square's dimensions and color is defined.
	 */
	public TetrisSquare(Color fillColor, Color borderColor) {
		_structure = new Rectangle();
		_structure.setHeight(Constants.SQUARE_SIZE);
		_structure.setWidth(Constants.SQUARE_SIZE);	
		_structure.setFill(fillColor);
		_structure.setStroke(borderColor);
	}
	
	/**
	 * Sets the x-location of a square.
	 */
	public void setX(double x) {
		_structure.setX(x);
	}
	
	/**
	 * Sets the y-location of a square.
	 */
	public void setY(double y) {
		_structure.setY(y);
	}
	
	/**
	 * Returns a given square. This method is to be used to graphically add
	 * a square to the Pane.
	 */
	public Node getNode() {
		return _structure;
	}
	
	/**
	 * Gets the y-location of a square.
	 */
	public double getY() {
		return _structure.getY();
	}
	
	/**
	 * Gets the x-location of a square.
	 */
	public double getX() {
		return _structure.getX();
	}	
}