package Figures;

import java.awt.Point;
import java.util.HashSet;

import GUI.Board;
import GUI.Settings;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Figure {
	
	private boolean alive;
	private FigureColour colour;
	protected Image img;
	protected HashSet<Point> legalMoves;
	protected FigurePosition position;
	
	public Figure(FigureColour colour,int x, int y){
		this.colour = colour;
		position = new FigurePosition(x,y);
		alive = true;
	}
	
	public void draw(GraphicsContext gc){
		gc.drawImage(img, this.position.getLocationX() * Settings.GRID_VALUE + Settings.MARGIN_LEFT,
						  this.position.getLocationY() * Settings.GRID_VALUE + Settings.MARGIN_TOP);
	}
	
	public FigureColour getColor(){
		return colour;
	}
	
	public FigurePosition getPosition(){
		return position;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public boolean isLegal(int x, int y){
		if(legalMoves.contains(new Point(x,y))) return true;
		else return false;
	}
	
	public abstract void generateLegalMove(Board board);
	
	public boolean isOpponent(Figure figure){
		if(figure.getColor() != this.getColor()) return true;
		else return false;
	}
	
	public void die(){
		this.alive = false;
	}
	
	
}


