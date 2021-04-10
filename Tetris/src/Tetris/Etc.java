package Tetris;

import java.util.LinkedList;

import cs015.fnl.PacmanSupport.BoardLocation;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Etc {

}

// BFS

//public Direction BFS(BoardCoordinate targetCell) { // Q: Ghost(s) can't turn left or right when in row 11, why?
//	// A: Manually hard-code all left or right neighbors when in row 11
//double smallestDist = 1000;
//BoardCoordinate closestCell = null;
//LinkedList<BoardCoordinate> queue = new LinkedList<BoardCoordinate>();
//Direction[][] dirArray = new Direction[Constants.NUM_ROWS][Constants.NUM_COLUMNS];
//BoardCoordinate ghostLoc = new BoardCoordinate((int) _ghost.getY() / Constants.SQUARE_SIZE,(int) _ghost.getX() / Constants.SQUARE_SIZE, false);
//BoardLocation[][] layout = cs015.fnl.PacmanSupport.SupportMap.getMap(); // Consider using board instead of support map, time-permitting
//
///*
//* Checking to see if neighbors are valid: on board, is not a wall, and has not been visited
//*/
//Boolean validNeighDown = true;
//Boolean validNeighUp = true;
//Boolean validNeighRight = true;
//Boolean validRightTunnel = false;
//Boolean validNeighLeft = true;
//Boolean validLeftTunnel = false;
//
//if (ghostLoc.getRow() + 1 > 22
//|| _game.getBoard()[ghostLoc.getRow() + 1][ghostLoc.getColumn()].checkWall() == true
////layout[ghostLoc.getRow() + 1][ghostLoc.getColumn()] == BoardLocation.WALL 
//|| _prevDir.getOpposite() == Direction.DOWN) {
//validNeighDown = false;
//}
//if (ghostLoc.getRow() - 1 < 0 
//|| _game.getBoard()[ghostLoc.getRow() - 1][ghostLoc.getColumn()].checkWall() == true
////layout[ghostLoc.getRow() - 1][ghostLoc.getColumn()] == BoardLocation.WALL
//|| _prevDir.getOpposite() == Direction.UP) {
//validNeighUp = false;
//}
//if (ghostLoc.getColumn() + 1 > 22 
//|| _game.getBoard()[ghostLoc.getRow()][ghostLoc.getColumn() + 1].checkWall() == true
////layout[ghostLoc.getRow()][ghostLoc.getColumn() + 1] == BoardLocation.WALL
//|| _prevDir.getOpposite() == Direction.RIGHT) {
//validNeighRight = false;
//}
//
//if (ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 22) { 
//validRightTunnel = true;
//}
//
//if (ghostLoc.getColumn() - 1 < 0 
//|| _game.getBoard()[ghostLoc.getRow()][ghostLoc.getColumn() - 1].checkWall() == true
////layout[ghostLoc.getRow()][ghostLoc.getColumn() - 1] == BoardLocation.WALL
//|| _prevDir.getOpposite() == Direction.LEFT) {
//validNeighLeft = false;
//}
//
//if (ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 0) {
//validLeftTunnel = true;
//}
//
///*
//* If neighbor is valid, assigning BoardCoordinate to that neighbor, storing its direction in 2D Array, and adding respective BoardCoordinate to queue
//*/
//if (validNeighDown) {
//BoardCoordinate neighDown = new BoardCoordinate(ghostLoc.getRow() + 1, ghostLoc.getColumn(), false);
//dirArray[neighDown.getRow()][neighDown.getColumn()] = Direction.DOWN;
//queue.addLast(neighDown);
//}
//
//if (validNeighUp) {
//BoardCoordinate neighUp = new BoardCoordinate(ghostLoc.getRow() - 1, ghostLoc.getColumn(), false);
//dirArray[neighUp.getRow()][neighUp.getColumn()] = Direction.UP;
//queue.addLast(neighUp);
//}
//
//if (validNeighRight || validRightTunnel) {
//BoardCoordinate neighRight = null;
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 22)
//&& dirArray[11][0] == null) {
//neighRight = new BoardCoordinate(11, 0, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 0)
//&& dirArray[11][1] == null) {
//neighRight = new BoardCoordinate(11, 1, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 1)
//&& dirArray[11][2] == null) {
//neighRight = new BoardCoordinate(11, 2, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 2)
//&& dirArray[11][3] == null) {
//neighRight = new BoardCoordinate(11, 3, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 3)
//&& dirArray[11][4] == null) {
//neighRight = new BoardCoordinate(11, 4, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 4)
//&& dirArray[11][5] == null) {
//neighRight = new BoardCoordinate(11, 5, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 5)
//&& dirArray[11][6] == null) {
//neighRight = new BoardCoordinate(11, 6, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 6)
//&& dirArray[11][7] == null) {
//neighRight = new BoardCoordinate(11, 7, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 7)
//&& dirArray[11][8] == null) {
//neighRight = new BoardCoordinate(11, 8, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 8)
//&& dirArray[11][9] == null) {
//neighRight = new BoardCoordinate(11, 9, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 9)
//&& dirArray[11][10] == null) {
//neighRight = new BoardCoordinate(11, 10, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 10)
//&& dirArray[11][11] == null) {
//neighRight = new BoardCoordinate(11, 11, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 11)
//&& dirArray[11][12] == null) {
//neighRight = new BoardCoordinate(11, 12, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 12)
//&& dirArray[11][13] == null) {
//neighRight = new BoardCoordinate(11, 13, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 13)
//&& dirArray[11][14] == null) {
//neighRight = new BoardCoordinate(11, 14, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 14)
//&& dirArray[11][15] == null) {
//neighRight = new BoardCoordinate(11, 15, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 15)
//&& dirArray[11][16] == null) {
//neighRight = new BoardCoordinate(11, 16, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 16)
//&& dirArray[11][17] == null) {
//neighRight = new BoardCoordinate(11, 17, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 17)
//&& dirArray[11][18] == null) {
//neighRight = new BoardCoordinate(11, 18, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 18)
//&& dirArray[11][19] == null) {
//neighRight = new BoardCoordinate(11, 19, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 19)
//&& dirArray[11][20] == null) {
//neighRight = new BoardCoordinate(11, 20, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 20)
//&& dirArray[11][21] == null) {
//neighRight = new BoardCoordinate(11, 21, false); //Consider making true
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 21)
//&& dirArray[11][22] == null) {
//neighRight = new BoardCoordinate(11, 22, false); //Consider making true
//}
//
//
//if (ghostLoc.getRow() != 11 && ghostLoc.getColumn() != 22){
//neighRight = new BoardCoordinate(ghostLoc.getRow(), ghostLoc.getColumn() + 1, false); 
//}
//
//if (neighRight != null) {
//dirArray[neighRight.getRow()][neighRight.getColumn()] = Direction.RIGHT;
//queue.addLast(neighRight);
//}
//}
//
//if (validNeighLeft || validLeftTunnel) {
//BoardCoordinate neighLeft = null;
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 0)
//&& dirArray[11][22] == null) {
//neighLeft = new BoardCoordinate(11, 22, false);
//} 
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 22)
//&& dirArray[11][21] == null) {
//neighLeft = new BoardCoordinate(11, 21, false);
//} 
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 21)
//&& dirArray[11][20] == null) {
//neighLeft = new BoardCoordinate(11, 20, false);
//} 
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 20)
//&& dirArray[11][19] == null) {
//neighLeft = new BoardCoordinate(11, 19, false);
//} 
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 19)
//&& dirArray[11][18] == null) {
//neighLeft = new BoardCoordinate(11, 18, false);
//} 
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 18)
//&& dirArray[11][17] == null) {
//neighLeft = new BoardCoordinate(11, 17, false);
//} 
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 17)
//&& dirArray[11][16] == null) {
//neighLeft = new BoardCoordinate(11, 16, false);
//} 
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 16)
//&& dirArray[11][15] == null) {
//neighLeft = new BoardCoordinate(11, 15, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 15)
//&& dirArray[11][14] == null) {
//neighLeft = new BoardCoordinate(11, 14, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 14)
//&& dirArray[11][13] == null) {
//neighLeft = new BoardCoordinate(11, 13, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 13)
//&& dirArray[11][12] == null) {
//neighLeft = new BoardCoordinate(11, 12, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 12)
//&& dirArray[11][11] == null) {
//neighLeft = new BoardCoordinate(11, 11, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 11)
//&& dirArray[11][10] == null) {
//neighLeft = new BoardCoordinate(11, 10, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 10)
//&& dirArray[11][9] == null) {
//neighLeft = new BoardCoordinate(11, 9, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 9)
//&& dirArray[11][8] == null) {
//neighLeft = new BoardCoordinate(11, 8, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 8)
//&& dirArray[11][7] == null) {
//neighLeft = new BoardCoordinate(11, 7, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 7)
//&& dirArray[11][6] == null) {
//neighLeft = new BoardCoordinate(11, 6, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 6)
//&& dirArray[11][5] == null) {
//neighLeft = new BoardCoordinate(11, 5, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 5)
//&& dirArray[11][4] == null) {
//neighLeft = new BoardCoordinate(11, 4, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 4)
//&& dirArray[11][3] == null) {
//neighLeft = new BoardCoordinate(11, 3, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 3)
//&& dirArray[11][2] == null) {
//neighLeft = new BoardCoordinate(11, 2, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 2)
//&& dirArray[11][1] == null) {
//neighLeft = new BoardCoordinate(11, 1, false);
//}
//if ((ghostLoc.getRow() == 11 && ghostLoc.getColumn() == 1)
//&& dirArray[11][0] == null) {
//neighLeft = new BoardCoordinate(11, 0, false);
//}
//
//if (ghostLoc.getRow() != 11 && ghostLoc.getColumn() != 0) {
//neighLeft = new BoardCoordinate(ghostLoc.getRow(), ghostLoc.getColumn() - 1, false); 
//}
//
//if (neighLeft != null) {
//dirArray[neighLeft.getRow()][neighLeft.getColumn()] = Direction.LEFT;
//queue.addLast(neighLeft);
//}
//}
//
//while (!queue.isEmpty()) {
//BoardCoordinate currentCell = queue.removeFirst(); 
//
//double currentDist = Math.sqrt(Math.abs(currentCell.getRow() - targetCell.getRow()) 
//* Math.abs(currentCell.getRow() - targetCell.getRow())
//+ Math.abs(currentCell.getColumn() - targetCell.getColumn()) 
//* Math.abs(currentCell.getColumn() - targetCell.getColumn()));
//
//
//if (currentDist < smallestDist) {
//smallestDist = currentDist;
//closestCell = currentCell;
//}
//
///*
//* Checking to see if current cell's neighbors are valid: on board, is not a wall, and has not been visited
//*/
//Boolean validNextNeighDown = true;
//Boolean validNextNeighUp = true;
//Boolean validNextNeighRight = true;
//Boolean validNextRightTunnel = false;
//Boolean validNextNeighLeft = true;
//Boolean validNextLeftTunnel = false;
//if (currentCell.getRow() + 1 > 22  
//|| _game.getBoard()[currentCell.getRow() + 1][currentCell.getColumn()].checkWall() == true
////layout[currentCell.getRow() + 1][currentCell.getColumn()] == BoardLocation.WALL
//|| dirArray[currentCell.getRow() + 1][currentCell.getColumn()] != null) {
//validNextNeighDown = false;
//}
//if (currentCell.getRow() - 1 < 0 
//|| _game.getBoard()[currentCell.getRow() - 1][currentCell.getColumn()].checkWall() == true
////layout[currentCell.getRow() - 1][currentCell.getColumn()] == BoardLocation.WALL
//|| dirArray[currentCell.getRow() - 1][currentCell.getColumn()] != null) {
//validNextNeighUp = false;
//}
//if (currentCell.getColumn() + 1 > 22 
//|| _game.getBoard()[currentCell.getRow()][currentCell.getColumn() + 1].checkWall() == true
////layout[currentCell.getRow()][currentCell.getColumn() + 1] == BoardLocation.WALL
//|| dirArray[currentCell.getRow()][currentCell.getColumn() + 1] != null) {
//validNextNeighRight = false;
//}
//
//if (currentCell.getRow() == 11 && currentCell.getColumn() == 22) {
//validNextRightTunnel = true;
//}
//
//if (currentCell.getColumn() - 1 < 0 
//|| _game.getBoard()[currentCell.getRow()][currentCell.getColumn() - 1].checkWall() == true
////layout[currentCell.getRow()][currentCell.getColumn() - 1] == BoardLocation.WALL
//|| dirArray[currentCell.getRow()][currentCell.getColumn() - 1] != null) {
//validNextNeighLeft = false;
//}
//
//if (currentCell.getRow() == 11 && currentCell.getColumn() == 0) {
//validNextLeftTunnel = true;
//}
//
///*
//* If neighbor is valid, assigning BoardCoordinate to that neighbor, storing its direction in 2D Array, and adding respective BoardCoordinate to queue
//*/
//if (validNextNeighDown) {
//BoardCoordinate nextNeighDown = new BoardCoordinate(currentCell.getRow() + 1, currentCell.getColumn(), false);
//dirArray[nextNeighDown.getRow()][nextNeighDown.getColumn()] = dirArray[currentCell.getRow()][currentCell.getColumn()];
//queue.addLast(nextNeighDown);
//}
//if (validNextNeighUp) {
//BoardCoordinate nextNeighUp = new BoardCoordinate(currentCell.getRow() - 1, currentCell.getColumn(), false);
//dirArray[nextNeighUp.getRow()][nextNeighUp.getColumn()] = dirArray[currentCell.getRow()][currentCell.getColumn()];
//queue.addLast(nextNeighUp);
//}
//if (validNextNeighRight || validNextRightTunnel) {
//BoardCoordinate nextNeighRight = null;
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 22)
//&& dirArray[11][0] == null) {
//nextNeighRight = new BoardCoordinate(11, 0, false);	
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 0)
//&& dirArray[11][1] == null) {
//nextNeighRight = new BoardCoordinate(11, 1, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 1)
//&& dirArray[11][2] == null) {
//nextNeighRight = new BoardCoordinate(11, 2, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 2)
//&& dirArray[11][3] == null) {
//nextNeighRight = new BoardCoordinate(11, 3, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 3)
//&& dirArray[11][4] == null) {
//nextNeighRight = new BoardCoordinate(11, 4, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 4)
//&& dirArray[11][5] == null) {
//nextNeighRight = new BoardCoordinate(11, 5, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 5)
//&& dirArray[11][6] == null) {
//nextNeighRight = new BoardCoordinate(11, 6, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 6)
//&& dirArray[11][7] == null) {
//nextNeighRight = new BoardCoordinate(11, 7, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 7)
//&& dirArray[11][8] == null) {
//nextNeighRight = new BoardCoordinate(11, 8, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 8)
//&& dirArray[11][9] == null) {
//nextNeighRight = new BoardCoordinate(11, 9, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 9)
//&& dirArray[11][10] == null) {
//nextNeighRight = new BoardCoordinate(11, 10, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 10)
//&& dirArray[11][11] == null) {
//nextNeighRight = new BoardCoordinate(11, 11, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 11)
//&& dirArray[11][12] == null) {
//nextNeighRight = new BoardCoordinate(11, 12, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 12)
//&& dirArray[11][13] == null) {
//nextNeighRight = new BoardCoordinate(11, 13, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 13)
//&& dirArray[11][14] == null) {
//nextNeighRight = new BoardCoordinate(11, 14, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 14)
//&& dirArray[11][15] == null) {
//nextNeighRight = new BoardCoordinate(11, 15, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 15)
//&& dirArray[11][16] == null) {
//nextNeighRight = new BoardCoordinate(11, 16, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 16)
//&& dirArray[11][17] == null) {
//nextNeighRight = new BoardCoordinate(11, 17, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 17)
//&& dirArray[11][18] == null) {
//nextNeighRight = new BoardCoordinate(11, 18, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 18)
//&& dirArray[11][19] == null) {
//nextNeighRight = new BoardCoordinate(11, 19, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 19)
//&& dirArray[11][20] == null) {
//nextNeighRight = new BoardCoordinate(11, 20, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 20)
//&& dirArray[11][21] == null) {
//nextNeighRight = new BoardCoordinate(11, 21, false); //Consider making true
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 21)
//&& dirArray[11][22] == null) {
//nextNeighRight = new BoardCoordinate(11, 22, false); //Consider making true
//}	
//
//
////STOP
//} 
//if (currentCell.getRow() != 11 && currentCell.getColumn() != 22){
//nextNeighRight = new BoardCoordinate(currentCell.getRow(), currentCell.getColumn() + 1, false);
//}
//if (nextNeighRight != null) {
//dirArray[nextNeighRight.getRow()][nextNeighRight.getColumn()] = dirArray[currentCell.getRow()][currentCell.getColumn()];
//queue.addLast(nextNeighRight);
//}
//}
//if (validNextNeighLeft || validNextLeftTunnel) {
//BoardCoordinate nextNeighLeft = null;
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 0)
//&& dirArray[11][22] == null) {
//nextNeighLeft = new BoardCoordinate(11, 22, false);
//} 
//
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 22)
//&& dirArray[11][21] == null) {
//nextNeighLeft = new BoardCoordinate(11, 21, false);
//} 
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 21)
//&& dirArray[11][20] == null) {
//nextNeighLeft = new BoardCoordinate(11, 20, false);
//} 
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 20)
//&& dirArray[11][19] == null) {
//nextNeighLeft = new BoardCoordinate(11, 19, false);
//} 
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 19)
//&& dirArray[11][18] == null) {
//nextNeighLeft = new BoardCoordinate(11, 18, false);
//} 
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 18)
//&& dirArray[11][17] == null) {
//nextNeighLeft = new BoardCoordinate(11, 17, false);
//} 
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 17)
//&& dirArray[11][16] == null) {
//nextNeighLeft = new BoardCoordinate(11, 16, false);
//} 
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 16)
//&& dirArray[11][15] == null) {
//nextNeighLeft = new BoardCoordinate(11, 15, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 15)
//&& dirArray[11][14] == null) {
//nextNeighLeft = new BoardCoordinate(11, 14, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 14)
//&& dirArray[11][13] == null) {
//nextNeighLeft = new BoardCoordinate(11, 13, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 13)
//&& dirArray[11][12] == null) {
//nextNeighLeft = new BoardCoordinate(11, 12, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 12)
//&& dirArray[11][11] == null) {
//nextNeighLeft = new BoardCoordinate(11, 11, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 11)
//&& dirArray[11][10] == null) {
//nextNeighLeft = new BoardCoordinate(11, 10, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 10)
//&& dirArray[11][9] == null) {
//nextNeighLeft = new BoardCoordinate(11, 9, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 9)
//&& dirArray[11][8] == null) {
//nextNeighLeft = new BoardCoordinate(11, 8, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 8)
//&& dirArray[11][7] == null) {
//nextNeighLeft = new BoardCoordinate(11, 7, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 7)
//&& dirArray[11][6] == null) {
//nextNeighLeft = new BoardCoordinate(11, 6, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 6)
//&& dirArray[11][5] == null) {
//nextNeighLeft = new BoardCoordinate(11, 5, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 5)
//&& dirArray[11][4] == null) {
//nextNeighLeft = new BoardCoordinate(11, 4, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 4)
//&& dirArray[11][3] == null) {
//nextNeighLeft = new BoardCoordinate(11, 3, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 3)
//&& dirArray[11][2] == null) {
//nextNeighLeft = new BoardCoordinate(11, 2, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 2)
//&& dirArray[11][1] == null) {
//nextNeighLeft = new BoardCoordinate(11, 1, false);
//}
//if ((currentCell.getRow() == 11 && currentCell.getColumn() == 1)
//&& dirArray[11][0] == null) {
//nextNeighLeft = new BoardCoordinate(11, 0, false);
//}
//
//
////STOP
//if (currentCell.getRow() != 11 && currentCell.getColumn() != 0){
//nextNeighLeft = new BoardCoordinate(currentCell.getRow(), currentCell.getColumn() - 1, false);
//}
//
//if (nextNeighLeft != null) {
//dirArray[nextNeighLeft.getRow()][nextNeighLeft.getColumn()] = dirArray[currentCell.getRow()][currentCell.getColumn()];
//queue.addLast(nextNeighLeft);
//}
//}
//}
//
//_prevDir = dirArray[closestCell.getRow()][closestCell.getColumn()];
//return dirArray[closestCell.getRow()][closestCell.getColumn()];
//
//}

// CHECK COLLISION

//private void checkCollision() {
//	for (int i = 0; i < _board[(int) (_pachim.getY() / Constants.SQUARE_SIZE)][(int) (_pachim.getX()
//			/ Constants.SQUARE_SIZE)].getList().size(); i++) {
//		
//		_paneOrganizer.updatePoints(_board[(int) (_pachim.getY() / Constants.SQUARE_SIZE)][(int) (_pachim.getX()
//				/ Constants.SQUARE_SIZE)].getItem(i).returnPoints());
//		_board[(int) (_pachim.getY() / Constants.SQUARE_SIZE)][(int) (_pachim.getX() / Constants.SQUARE_SIZE)]
//				.getItem(i).collide(_pane);
//		if (_board[(int) (_pachim.getY() / Constants.SQUARE_SIZE)][(int) (_pachim.getX() / Constants.SQUARE_SIZE)].checkStorage()) {
//			_board[(int) (_pachim.getY() / Constants.SQUARE_SIZE)][(int) (_pachim.getX() / Constants.SQUARE_SIZE)].removeItem(_board[(int) (_pachim.getY() / Constants.SQUARE_SIZE)][(int) (_pachim.getX() / Constants.SQUARE_SIZE)]
//					.getItem(i));
//		}
//	}
////	_board[(int) (_pachim.getY() / Constants.SQUARE_SIZE)][(int) (_pachim.getX() / Constants.SQUARE_SIZE)]
////			.clearStorage();
//
//	if (_paneOrganizer.getLives() == 0) {
//		_paneOrganizer.gameOver();
//		_pane.removeEventFilter(KeyEvent.KEY_PRESSED, _keyHandler);
//		_moving.pause();
//		_ghostTimeline.pause();
//		_penTimeline.pause();
//	}
//
//	if (_dotEnergCount == 0) {
//		_paneOrganizer.gameWin();
//		_pane.removeEventFilter(KeyEvent.KEY_PRESSED, _keyHandler);
//		_moving.pause();
//		_ghostTimeline.pause();
//		_penTimeline.pause();
//	}
//}