import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javafx.*;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Controller extends Application {
	public int width = 500;
	public int height = 500;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		View canvas = new View(primaryStage);
		IMazeAlgorithm algorithm = new BackTracker(width,height);
		ArrayList<Rectangle> grid = algorithm.generateMaze();
		canvas.createGrid(grid);
	}
	
}
