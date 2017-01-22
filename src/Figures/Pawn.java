package Figures;

import java.awt.Point;
import java.util.HashSet;

import GUI.Board;
import javafx.scene.image.Image;

public class Pawn extends Figure{
	
	private final int FIGURE_VALUE = 1;
	
	public Pawn(FigureColour colour, int x, int y) {
		super(colour, x, y);
		if(super.getColor() == FigureColour.WHITE)
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/WhitePawn.png"));
		else
			super.img = new Image(getClass().getResourceAsStream("/Resource/Piece/BlackPawn.png"));
	}

	@Override
	public void generateLegalMove(Board board) {
		
	}

	
	

}
