package Figures;

import java.awt.Point;
import java.util.HashSet;

import GUI.Board;
import javafx.scene.image.Image;

public class King extends Figure {
	
	private final int FIGURE_VALUE = 150;
	
	public King(FigureColour colour, int x, int y) {
		super(colour, x, y);
		if(super.getColor() == FigureColour.WHITE)
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/WhiteKing.png"));
		else
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/BlackKing.png"));
	}

	@Override
	public void generateLegalMove(Board board) {

	}


}
