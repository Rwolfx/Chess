package Engine;

import java.awt.Point;
import java.util.ArrayList;

import Figures.FigureColour;

public class Move {
	
	private ArrayList<Point[]> moveList;
	private FigureColour currMove;
	
	public Move(){
		moveList = new ArrayList<Point[]>();
		currMove = FigureColour.WHITE;
	}
	
	public void addMove(Point a, Point b){
		Point[] res = {a,b};
		moveList.add(res);
	}
	
	public ArrayList<Point[]> getHistory(){
		return moveList;
	}
	
	public boolean isCheck(FigureColour Colour){
		return true;
	}
	
	public FigureColour getColour(){
		return currMove;
	}
}
