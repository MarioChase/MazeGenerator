import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

import javafx.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class View {
	public Group root;
	public Canvas canvas;
	public GraphicsContext gc;
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public Stage primaryStage;

	public View(Stage ps) {
		primaryStage = ps;
		primaryStage.setTitle("Drawing Operations Test");
		root = new Group();
		canvas = new Canvas(screenSize.getWidth(), screenSize.getHeight());
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public void update_View(Stage primaryStage) {
	}

	public void createGrid(ArrayList<Rectangle> grid) {
		for (int i = 0; i < grid.size(); i++) {
			Rectangle r = grid.get(i);
			gc.setFill(r.getFill());
			gc.fillRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
		}
	}
}
