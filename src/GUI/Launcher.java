package GUI;
import java.util.ArrayList;

import Figures.Figure;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Launcher extends Application {

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Chess");
		Group root = new Group();
        Canvas canvas = new Canvas(Settings.WIDTH, Settings.HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        Board board = new Board();
        board.update(gc);
        canvas.setOnMousePressed(new TileHandler(board, gc));
	}
	
}

class TileHandler implements EventHandler<MouseEvent>{
	
	private ArrayList<Figure> figures ;
	private Figure activeFigure;
	private Board board;
	private GraphicsContext gc;
	private int blockX = Settings.MARGIN_LEFT + Settings.SIDE + Settings.MARGIN_RIGHT;
	private int blockY = Settings.TEXT_MARGIN_TOP;
	
	public TileHandler(Board board, GraphicsContext gc){
		
		this.gc = gc;
		this.board = board;
		this.figures = board.getFigures();
		activeFigure = null;
		
	}
	@Override
	public void handle(MouseEvent event) {
		int currTileX = (int)(event.getX()-Settings.MARGIN_LEFT)/(Settings.GRID_VALUE);
        int currTileY = (int)(event.getY()-Settings.MARGIN_TOP)/(Settings.GRID_VALUE);
        Figure selectedFigure = board.getFigureByLocation(currTileX, currTileY);
        if((currTileX >= 0 && currTileX < 8) && (currTileY >= 0 && currTileY < 8)){
    		if(activeFigure == null){
    			if(selectedFigure != null)
    				activeFigure = selectedFigure;
    		}else{
    			activeFigure.generateLegalMove(board);
    			if(activeFigure.isLegal(currTileX, currTileY)){
    				Figure targetFigure = board.getFigureByLocation(currTileX, currTileY);
    				if(targetFigure != null && targetFigure.isAlive() && targetFigure.getColor() != activeFigure.getColor()) {
    					targetFigure.die();
    				}
	    			activeFigure.getPosition().setLocation(currTileX, currTileY);
    			}
    			activeFigure = null;
    		}
    		if(activeFigure == null){
    			gc.setFill(Color.WHITE);
    			gc.fillRect(blockX, blockY-Settings.TEXT_HEIGHT,Settings.WIDTH - blockX , Settings.HEIGHT-blockY);
    			gc.setFill(Color.BLACK);
    			gc.fillText("Figure is not selected", blockX, blockY);
    			if(activeFigure != null) System.out.print(activeFigure.getClass().toString());
    		}else{	
    			char chessSymb = (char) ('a' + activeFigure.getPosition().getLocationX());
    			gc.setFill(Color.WHITE);
    			gc.fillRect(blockX, blockY - Settings.TEXT_HEIGHT,Settings.WIDTH - blockX , Settings.HEIGHT-blockY);
    			gc.setFill(Color.BLACK);
    			gc.fillText("Currently selected : " + chessSymb + "" + (activeFigure.getPosition().getLocationY()+1) + activeFigure.getClass().toString(), blockX, blockY);
    		}
        }
        board.update(gc);
		
	}

}
