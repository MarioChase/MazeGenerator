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
	public int width = 250;
	public int height = 250;

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
		int x_range = width;
		int y_range = height;
		for (int i = 0; i < num_of_points; i++) {
			randomPoints.add(new Point(i, rand.nextInt(x_range), rand.nextInt(y_range)));
		}
		return randomPoints;
	}

	// Separate this algorithm into a separate object
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

	// Separate this into algorithm
	private ArrayList<Rectangle> generateMaze(ArrayList<Rectangle> grid) {
		ArrayList<Rectangle> maze = grid;
		Stack<String> directions = new Stack<String>();
		Random rand = new Random();
		int x = 2;
		int y = 2;

		maze.get(getCoordinate(x, y)).setFill(Color.GREEN);

		for (int i = 0; i < (width * height); i++) {
			int x_modifier = 0;
			int y_modifier = 0;
			switch (rand.nextInt(3)) {
			case 0:
				if (isValid(maze.get(getCoordinate(moveLeft(x), y))) == true) {
					x_modifier = -1;
					x = moveLeft(x);
					directions.push("Left");
					break;
				}
			case 1:
				if (isValid(maze.get(getCoordinate(moveRight(x), y))) == true) {
					x_modifier = 1;
					x = moveRight(x);
					directions.push("Right");
					break;
				}
			case 2:
				if (isValid(maze.get(getCoordinate(x, moveUp(y)))) == true) {
					y_modifier = 1;
					y = moveUp(y);
					directions.push("Up");
					break;
				}
			case 3:
				if (isValid(maze.get(getCoordinate(x, moveDown(y)))) == true) {
					y_modifier = -1;
					y = moveDown(y);
					directions.push("Down");
					break;

				}
			default:
				if (directions.isEmpty() == false) {
					switch (directions.peek()) {
					case "Left":
						x_modifier = 1;
						x = moveRight(x);
						directions.pop();
						break;
					case "Right":
						x_modifier = -1;
						x = moveLeft(x);
						directions.pop();
						break;
					case "Up":
						y_modifier = -1;
						y = moveDown(y);
						directions.pop();
						break;
					case "Down":
						y_modifier = 1;
						y = moveUp(y);
						directions.pop();
						break;

					}
				}
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
		if (num <= height / 2) {
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
		if (num <= width / 2) {
			return num + 2;
		}
		return num;
	}

	private int getCoordinate(int x, int y) {
		return ((x * height) + y);
	}
}
