package Figures;

import java.awt.Point;
import java.util.HashSet;

import GUI.Board;
import GUI.Settings;
import javafx.scene.image.Image;

public class Rook extends Figure {
	
	private final int FIGURE_VALUE = 5;

	public Rook(FigureColour colour, int x, int y) {
		super(colour, x, y);
		if(super.getColor() == FigureColour.WHITE)
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/WhiteRook.png"));
		else
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/BlackRook.png"));
	}

	@Override
	public void generateLegalMove(Board board) {
		int row = this.getPosition().getLocationY();
	    int column = this.getPosition().getLocationX();
	    legalMoves = new HashSet<Point>();
		//moves UP
	    for (int i = row + 1; i < Settings.SIZE; i++) {
	        Figure figure = board.getFigureByLocation(i, column);
	        if (figure == null ) {
	            legalMoves.add(new Point(i,column));
	        } else if (isOpponent(figure)) {
	            legalMoves.add(new Point(i,column));
	            break;
	        } else {
	            break;
	        }
	    }
	    //moves down
	    for (int i = row - 1; i > -1; i--) {
	    	Figure figure = board.getFigureByLocation(i, column);
	        if (figure == null) {
	            legalMoves.add(new Point(i,column));
	        } else if (isOpponent(figure)) {
	            legalMoves.add(new Point(i,column));
	            break;
	        } else {
	            break;
	        }
	    }
	    //moves right
	    for (int i = column + 1; i < Settings.SIZE; i++) {
	        Figure figure = board.getFigureByLocation(row, i);
	        if (figure == null) {
	            legalMoves.add(new Point(row,i));
	        } else if (isOpponent(figure)) {
	            legalMoves.add(new Point(row,i));
	            break;
	        } else {
	            break;
	        }
	    }
	    //moves left
	    for (int i = column - 1; i > -1; i--) {
	    	Figure figure = board.getFigureByLocation(row, i);
	    	if (figure == null) {
	            legalMoves.add(new Point(row,i));
	        } else if (isOpponent(figure)) {
	            legalMoves.add(new Point(row,i));
	            break;
	        } else {
	            break;
	        }
	    }
	}
		


	
}
