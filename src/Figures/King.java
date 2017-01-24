package Figures;

import java.awt.Point;
import java.util.HashSet;

import GUI.Board;
import javafx.scene.image.Image;

public class King extends Figure {
	
	private final int FIGURE_VALUE = 150;
	private final int[][] POSSIBLE_MOVES;
	public King(FigureColour colour, int x, int y) {
		super(colour, x, y);
		if(super.getColor() == FigureColour.WHITE)
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/WhiteKing.png"));
		else
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/BlackKing.png"));
		POSSIBLE_MOVES = fillPossibleMoves();
	}
	
	public int[][] fillPossibleMoves(){
		int[][] positionChange = {
		        {1, 1},
		        {-1, 1},
		        {1, -1},
		        {-1, -1},
		        {1, 0},
		        {-1, 0},
		        {0, -1},
		        {0, 1}
		    };
		return positionChange;
	}

	@Override
	public void generateLegalMove(Board board) {
		legalMoves = new HashSet<Point>();
		for(int[] point : POSSIBLE_MOVES){
			int possibleX = getPosition().getLocationX() + point[0];
			int possibleY = getPosition().getLocationY() + point[1];
			if(board.getFigureByLocation(possibleX, possibleY) == null || 
			   isOpponent(board.getFigureByLocation(possibleX, possibleY)))
						legalMoves.add(new Point(possibleX,possibleY));
		}
	}


}
