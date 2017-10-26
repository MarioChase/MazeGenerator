import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class MazeAlgorithm implements IMazeAlgorithm{
	int width;
	int height;
	public MazeAlgorithm(int w, int h) {
		width = w;
		height = h;
	}
	protected ArrayList<Rectangle> generateGrid() {
		ArrayList<Rectangle> grid = new ArrayList<Rectangle>();
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < height; j++) {
				System.out.println(i + " " + j);
				Rectangle r = new Rectangle(i * 5, j * 5, 5, 5);
				r.setFill(Color.BLACK);
				grid.add(r);
			}
		}
		return grid;
	}
	protected boolean isValid(Rectangle rectangle) {
		if (rectangle.getFill() == Color.BLACK) {
			return true;
		} else {
			return false;
		}
	}

	protected int moveDown(int num) {
		if (num <= height / 2) {
			return num + 2;
		}
		return num;
	}

	protected int moveUp(int num) {
		if (num > 0) {
			return num - 2;
		}
		return num;
	}

	protected int moveRight(int num) {
		if (num > 0) {
			return num - 2;
		}
		return num;
	}

	protected int moveLeft(int num) {
		if (num <= width / 2) {
			return num + 2;
		}
		return num;
	}

	protected int getCoordinate(int x, int y) {
		return ((x * height) + y);
	}
}
