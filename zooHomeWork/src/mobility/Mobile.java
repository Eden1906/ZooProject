package mobility;

import utilities.MessageUtility;
/*
* Mobile abstract class
* implements Ilocatable
*/
public abstract class Mobile implements Ilocatable {
	private Point location;
	private double totalDistance;
/*
* getLocation method
* @return location of object(animal)
* @see Ilocatable interface
*/
	public Point getLocation() {
		return this.location;
	}
	/*
* setLocation method(boolean)
* @params: Point p
* @return true if location(Point p) is valid
* @see Ilocatable interface
*/
	public  boolean setLocation(Point p) {
		if((p.get_x()>0 && p.get_x()<800)&&(p.get_y()>0&&p.get_y()<600)) {
			this.location = new Point(p);
			return true;
		}
		return false;
		
	}
/*
* Mobile constructors
* @param: Point location
*/
	public Mobile(Point location) {
		this.location=location;
		this.totalDistance=0;
	}
/*
* addTotalDistance mathod
* @params: distance
* increases the total distance if the added distance is valid
* 
*/
	public void addTotalDistance(double distance) {
		if(distance>0) {
			this.totalDistance+=distance;
		}
	}
/*
* calcDistance method
* @param: Point p
* @return a calculation for the location of the pythagoras theorem
*/
	public double calcDistance(Point p) {
		return Math.sqrt(Math.pow((location.get_x()-p.get_x()) ,2)+Math.pow((location.get_y()-p.get_y()) ,2));	
	}
/*
* getDistance method
* @return total distance
*/
	public double getDistance() {
		return this.totalDistance;
	}
/*
* move method
* @param: Point p
* @return calculation of calcDistance activation with p
*/
	public double move(Point p) {
		  double dist_traveld = calcDistance(p);
		  this.addTotalDistance(dist_traveld);
		  return dist_traveld;
	}
	

}
