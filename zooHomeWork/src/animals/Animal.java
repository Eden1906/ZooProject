package animals;

import diet.IDiet;
import food.IEdible;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;
/*
* Animal class
*/
public abstract class Animal extends Mobile implements IEdible {
	private String name;
	private double weight;
	private IDiet diet;
/*
* Animal constructor
* @params: name,Point location
*/	
	public Animal(String name,Point location) {
		super(location);
		this.name = name;
		MessageUtility.logConstractor("Animal", name);
	}
/*
* Abstract method makeSound
*/
	public abstract void makeSound();
/*
* Abstract method eat
* @see eat method in diet classes
*/
	public abstract boolean eat(IEdible food);
/*
* GetName method
* @return animal name
*/
	public String getName() {
		MessageUtility.logGetter(this.name,"getname",this.name);
		return this.name;
	}
/*
* Set animal weight(boolean)
* @return true if weight valid
*/
	public boolean setWeight(double weight) {
		if (weight > 0) {
			this.weight = weight;
			MessageUtility.logSetter(this.name,"setWeight",this.weight, true);
			return true;
		}
		MessageUtility.logSetter(this.name,"setWeight",this.weight, false);
		return false;
	}
/*
* Get method 
* @return animal weight
*/
	public double getWeight() {
		return this.weight;
		
	}
/*
* Set animal diet method
*/	
	public boolean setDiet(IDiet diet) {
		this.diet = diet;
		MessageUtility.logSetter(this.name,"setDiet",this.diet.getClass().getSimpleName() , true);
		return true;
	}
	
	

}
