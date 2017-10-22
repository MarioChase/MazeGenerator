public class Point {
	public double point_radius;
	public double X;
	public double Y;

	public Point(int ID, double x, double y) {
		X = x;
		Y = y;
		point_radius = 2;
	}

	public void setX(double d) {
		this.X = d;
	}

	public void setY(double y) {
		this.Y = y;
	}
	
	public double getX() {
		return this.X;
	}

	public double getY() {
		return this.Y;
	}

	public double getRadius() {
		return this.point_radius;
	}

}
