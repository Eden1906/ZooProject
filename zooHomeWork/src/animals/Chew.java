package animals;

import mobility.Point;
/*
* chew class
* extends from animal class
*/
public abstract class Chew extends Animal {
	
	
/*
* chew consturctor
*/	

	public Chew(String name, Point Location) {
		super(name, Location);
	}
/*
* make sound method
* @see chew 
*/
	public void makeSound() {
		this.chew();
	}
	
	public abstract void chew();

}
