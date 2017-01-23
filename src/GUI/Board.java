package GUI;
import java.awt.GraphicsDevice.WindowTranslucency;
import java.io.File;

import java.util.ArrayList;

import Figures.Bishop;
import Figures.Figure;
import Figures.FigureColour;
import Figures.King;
import Figures.Knight;
import Figures.Pawn;
import Figures.Queen;
import Figures.Rook;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import static Figures.FigureColour.*;

public class Board {
	private ArrayList<Figure> figures;
	private final int COLUMNS = 8;
	private final int RAWS = 8;
	private Image boardImg;	
	
	public Board(){
		figures = new ArrayList<Figure>();
		fillfigures();
		boardImg = new Image(getClass().getResourceAsStream("/Resource/Chess_Board.png"));
	}
	
	private void fillfigures(){
		// white side
		figures.add(new Rook(BLACK,0,0));
		figures.add(new Knight(BLACK,1,0));
		figures.add(new Bishop(BLACK,2,0));
		figures.add(new Queen(BLACK,3,0));
		figures.add(new King(BLACK,4,0));
		figures.add(new Bishop(BLACK,5,0));
		figures.add(new Knight(BLACK,6,0));
		figures.add(new Rook(BLACK,7,0));
		figures.add(new Pawn(BLACK,0,1));
		figures.add(new Pawn(BLACK,1,1));
		figures.add(new Pawn(BLACK,2,1));
		figures.add(new Pawn(BLACK,3,1));
		figures.add(new Pawn(BLACK,4,1));
		figures.add(new Pawn(BLACK,5,1));
		figures.add(new Pawn(BLACK,6,1));
		figures.add(new Pawn(BLACK,7,1));
		//black side
		figures.add(new Rook(WHITE,0,7));
		figures.add(new Knight(WHITE,1,7));
		figures.add(new Bishop(WHITE,2,7));
		figures.add(new Queen(WHITE,3,7));
		figures.add(new King(WHITE,4,7));
		figures.add(new Bishop(WHITE,5,7));
		figures.add(new Knight(WHITE,6,7));
		figures.add(new Rook(WHITE,7,7));
		figures.add(new Pawn(WHITE,0,6));
		figures.add(new Pawn(WHITE,1,6));
		figures.add(new Pawn(WHITE,2,6));
		figures.add(new Pawn(WHITE,3,6));
		figures.add(new Pawn(WHITE,4,6));
		figures.add(new Pawn(WHITE,5,6));
		//figures.add(new Pawn(WHITE,6,6));
		figures.add(new Pawn(WHITE,7,6));
	}
	
	public void update(GraphicsContext gc){
		gc.drawImage(boardImg, Settings.MARGIN_LEFT, Settings.MARGIN_TOP);
		for(Figure figure : figures){
			if(figure.isAlive())
				figure.draw(gc);
		}
	}
	
	public Figure getFigureByLocation(int locationX, int locationY){
		for(Figure figure : figures){
			if(figure.getPosition().getLocationX() == locationX && figure.getPosition().getLocationY() == locationY && figure.isAlive()) return figure;
		}
		return null;
	}
	public ArrayList<Figure> getFigures(){
		return figures;
	}
	
	
	
}
