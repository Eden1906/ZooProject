package animals;

import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;
/*
* Bear class(an animal)
*/
public class Bear extends Roar {
	public static final Point start_location = new Point(100,5);
	public static final Omnivore diet = new Omnivore();
	private String furColor;		
/*
* Animal constructor
* @param: name
*/
	public Bear(String name) {
		super(name,start_location);
		super.setWeight(308.2);
		super.setDiet(diet);
		this.furColor = "GRAY";
		MessageUtility.logConstractor("Bear", name);
	}
/*
* Animal constructor
* @params: name,Point location
*/
	public Bear(String name,Point location) {
		super(name,location);
		super.setWeight(308.2);
		super.setDiet(diet);
		this.furColor = "GRAY";
		MessageUtility.logConstractor("Bear", name);
	}
/*
* Roaring operation method
* @see roar class
*/
	public void roar() {
		MessageUtility.logSound(super.getName(),"Stands on its hind legs, roars and scratches its belly");
		
	}
/*
* Set fur color(boolean)
* @param: bear fur color
* @return true if fur color valid
*/
	public boolean setFurColor(String furColor) {
		if(furColor.equals("black") ||furColor.equals("white")|| furColor.equals("gray")){
			this.furColor = furColor;
			MessageUtility.logSetter(super.getName(), "fur set", furColor, true);
			return true;
		}
		MessageUtility.logSetter(super.getName(), "fur not set", furColor, false);
		return false;
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
			super.makeSound();
			return true;
		}
		return false;
	}
/*
* get animal food type method
* @return food type
* @see getfoodtype method in food packege
*/
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(),"foodtype", EFoodType.MEAT);
		return EFoodType.MEAT;
	}

	
	
	
	

}
