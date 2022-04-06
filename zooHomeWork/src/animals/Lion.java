package animals;

import java.util.Random;


import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;
/*
* Lion class(an animal)
*/
public class Lion extends Roar {
	private static final Point start_location = new Point(20,0);
	private static final Carnivore diet = new Carnivore();
	private int scarCount = 0;
/*
* Lion constructor
* @param: name
*/	
	public Lion(String name) {
		super(name,start_location);
		super.setWeight(408.2);
		super.setDiet(diet);
		this.scarCount = 0;
		MessageUtility.logConstractor("Lion", name);
	}
/*
* Lion constructor
* @params: name,Point location
*/	
	public Lion(String name,Point location) {
		super(name,location);
		super.setWeight(408.2);
		super.setDiet(diet);
		this.scarCount = 0;
		MessageUtility.logConstractor("Lion", name);
	}
/*
* Roaring operation method
* @see roar class
*/
	public void roar() {
		MessageUtility.logSound(super.getName(),"Roars, then stretches and shakes its mane");
	}
/*
* Eat method(boolean)
* if diet allows eating
* @see eat method in animal class
* @return true
*/
	public boolean eat(IEdible food) {
		double w = diet.eat(this, food);
		if (w>0) {
			super.setWeight(super.getWeight()+w);
			boolean value = new Random().nextInt(50) == 0;
			if (value) {
				this.scarCount += 1;
			}
			super.makeSound();
			return true;
		}
		return false;
	}
/*
* get food type method
* @return food type
* @see getfoodtype method in food packege
*/	
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(),"foodType", EFoodType.NOTFOOD);
		return EFoodType.NOTFOOD;
	}
	

}
