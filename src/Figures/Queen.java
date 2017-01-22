package Figures;

import java.awt.Point;
import java.util.HashSet;

import GUI.Board;
import javafx.scene.image.Image;

public class Queen extends Figure {
	
	private final int FIGURE_VALUE = 9;
	
	public Queen(FigureColour colour, int x, int y) {
		super(colour, x, y);
		if(super.getColor() == FigureColour.WHITE)
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/WhiteQueen.png"));
		else
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/BlackQueen.png"));
	}

	@Override
	public void generateLegalMove(Board board) {
		
	}

}
