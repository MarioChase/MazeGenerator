import java.util.ArrayList;
import java.util.Random;

import javafx.*;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Controller extends Application {
	public int width = 700;
	public int height = 700;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		View canvas = new View(primaryStage);
		ArrayList<Rectangle> grid = generateMaze(generateGrid());
		canvas.createGrid(grid);
	}

	private ArrayList<Point> generatePoints(View canvas, int num_of_points) {
		ArrayList<Point> randomPoints = new ArrayList<Point>();
		Random rand = new Random();
		int x_range = canvas.screenSize.width;
		int y_range = canvas.screenSize.height;
		for (int i = 0; i < num_of_points; i++) {
			randomPoints.add(new Point(i, rand.nextInt(x_range), rand.nextInt(y_range)));
		}
		return randomPoints;
	}

	private ArrayList<Rectangle> generateGrid() {
		ArrayList<Rectangle> grid = new ArrayList<Rectangle>();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				System.out.println(i + " " + j);
				Rectangle r = new Rectangle(i * 5, j * 5, 5, 5);
				r.setFill(Color.BLACK);
				grid.add(r);
			}
		}
		return grid;
	}

	private ArrayList<Rectangle> generateMaze(ArrayList<Rectangle> grid) {
		ArrayList<Rectangle> maze = grid;
		Random rand = new Random();
		int x = 20;
		int y = 20;
		maze.get(getCoordinate(x, y)).setFill(Color.WHITE);

		for (int i = 0; i < 500; i += 2) {
			int x_modifier = 0;
			int y_modifier = 0;
			switch (rand.nextInt(3)) {
			case 0:
				if (isValid(maze.get(getCoordinate(moveLeft(x), y))) == true) {
					System.out.println("Left");
					x_modifier = -1;
					x = moveLeft(x);
					break;
				} else {

				}
			case 1:
				if (isValid(maze.get(getCoordinate(moveRight(x), y))) == true) {
					System.out.println("Right");
					x_modifier = 1;
					x = moveRight(x);
					break;
				} else {

				}
			case 2:
				if (isValid(maze.get(getCoordinate(x, moveUp(y)))) == true) {
					System.out.println("Up");
					y_modifier = 1;
					y = moveUp(y);
					break;
				} else {
				}
			case 3:
				if (isValid(maze.get(getCoordinate(x, moveDown(y)))) == true) {
					System.out.println("Down");
					y_modifier = -1;
					y = moveDown(y);
					break;

				} else {
				}
			default:
				
			}
			maze.get(getCoordinate(x + x_modifier, y + y_modifier)).setFill(Color.WHITE);
			maze.get(getCoordinate(x, y)).setFill(Color.WHITE);
		}

		return maze;
	}

	private boolean isValid(Rectangle rectangle) {
		if (rectangle.getFill() == Color.BLACK) {
			return true;
		} else {
			return false;
		}
	}

	private int moveDown(int num) {
		if (num <= height) {
			return num + 2;
		}
		return num;
	}

	private int moveUp(int num) {
		if (num > 0) {
			return num - 2;
		}
		return num;
	}

	private int moveRight(int num) {
		if (num > 0) {
			return num - 2;
		}
		return num;
	}

	private int moveLeft(int num) {
		if (num <= height) {
			return num + 2;
		}
		return num;
	}

	private int getCoordinate(int x, int y) {
		return ((x * height) + y);
	}
}
