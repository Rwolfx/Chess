package Figures;

import java.awt.Point;
import java.util.HashSet;

import GUI.Board;
import javafx.scene.image.Image;

public class Bishop extends Figure{
	
	private final int FIGURE_VALUE = 3;

	public Bishop(FigureColour colour, int x, int y) {
		super(colour, x, y);
		if(super.getColor() == FigureColour.WHITE)
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/WhiteBishop.png"));
		else
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/BlackBishop.png"));
	}
	
	@Override
	public void generateLegalMove(Board board) {
		
	}


}
