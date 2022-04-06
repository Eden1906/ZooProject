package animals;

import mobility.Point;
/*
* roar class
* extends from animal class
*/
public abstract class Roar extends Animal {
/*
* roar consturctor
* @params:name(animal),Point location
*/	
	
	public Roar(String name,Point location) {
		super(name,location);
	}
	
	public abstract void roar();
/*
* make sound method
* @see chew 
*/	
	public void makeSound() {
		this.roar();
	}

}
