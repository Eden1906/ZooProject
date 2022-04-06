package mobility;
/*
* Point class
*/
public class Point {
	private int x;
	private int y;
	private int max_x=800;
	private int min_x,min_y=0;
	private int max_y=600;
/*
* Point constructor
* @params: x,y
*/	
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
		
	}
/*
* Point constructor
* @params: location(x,y)
*/
	
	public Point(Point location) {
		this.x = location.x;
		this.y = location.y;
	}
/*
* get x/y methods
* @return coordinate of point
*/
	public int get_x() {
		return this.x;
	}
	public int get_y() {
		return this.y;
	}
	public int get_max_x() {
		return this.max_x;
	}
	public int get_min_x() {
		return this.min_x;
	}
	public int get_min_y() {
		return this.min_y;
	}
	public int get_max_y(){
		return this.max_y;
	}
/*
* checkBoundaris method(boolean)
* @param: point
* @return true if boundaris of point valid
*/
	public static boolean checkBoundaris(Point point) {
		if (point.get_x() <= point.get_max_x()&& point.get_x() >= point.get_min_x() && point.get_y() <= point.get_max_y() && point.get_y() >= point.get_min_y()){
			return true;
		}
		return false;
	}
/*
* toString method
* @return format of a point as a string
* @see get methods
*/
	public String toString() {
		return "(" + this.get_x() + "," + this.get_y() + ")";
	}
}
