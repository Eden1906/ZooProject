package zoo;

import java.util.Random;


import java.util.Scanner;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import food.IEdible;
import mobility.Point;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;
import utilities.MessageUtility;


public class ZooActions {
	 
/*
* @params: animal,IEdible food
* Examines an instance of an animal by class and applies the method
*/
	public static boolean eat(Object animal,IEdible food) {
		if(animal instanceof Bear) {
			if(((Bear)animal).eat(food)){
				return true;
			}
			return false;
		}
		
		if(animal instanceof Elephant) {
			if(((Elephant)animal).eat(food)){
				return true;
			}
			return false;
		}
		
		if(animal instanceof Giraffe) {
			if(((Giraffe)animal).eat(food)){
				return true;
			}
			return false;
		}
		if(animal instanceof Lion) {
			if(((Lion)animal).eat(food)){
				return true;
			}
			return false;
		}
		if(animal instanceof Turtle) {
			if(((Turtle)animal).eat(food)){
				return true;
			}
			return false;
		}
		return false;
	}
	
	
/*
* @params: animal, point
* Operates move method according to the Implementation of each class
* @return true if the operation of the move method is valid
*/


	public static boolean move(Object animal,Point point) {
		if (point.get_x() <= point.get_max_x()&& point.get_x() >= point.get_min_x() && point.get_y() <= point.get_max_y() && point.get_y() >= point.get_min_y()){
			if(animal instanceof Turtle) {
				 ((Turtle) animal).move(point);
				 MessageUtility.logBooleanFunction(((Turtle)animal).getName(), "move", point.toString(), true);
				return true;
			}
			if(animal instanceof Lion) {
				((Lion) animal).move(point);
				 MessageUtility.logBooleanFunction(((Lion)animal).getName(), "move", point.toString(), true);

				return true;
			}
			if(animal instanceof Giraffe) {
				((Giraffe) animal).move(point);
				 MessageUtility.logBooleanFunction(((Giraffe)animal).getName(), "move", point.toString(), true);
				return true;
			}
			if(animal instanceof Elephant) {
				((Elephant) animal).move(point);
				 MessageUtility.logBooleanFunction(((Elephant)animal).getName(), "move", point.toString(), true);

				return true;
			}
			if(animal instanceof Bear) {
				((Bear) animal).move(point);
				 MessageUtility.logBooleanFunction(((Bear)animal).getName(), "move", point.toString(), true);

				return true;
			}
			return false;
		}
		
		 MessageUtility.logBooleanFunction("animal didnt move", "move", point.toString(), false);
		return false;
	}
	

		
	
	public static void main(String[] args) {
		System.out.println("Enter the number of animals");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		if(size<3) {
			System.out.println("Invalid input");
		}
		else {
			Animal[] animals_array = new Animal[size];
			for(int i=0;i<size;i++) {
				System.out.println("Choose animal:\n1.lion\n2.bear\n3.elephant\n4.giraffe\n5.turtle\n6.plant");
				sc = new Scanner(System.in);
				Point p;
				switch(sc.nextInt()) {
					case 1:
						System.out.println("Enter lion name");
						sc = new Scanner(System.in);
						animals_array[i] = new Lion(sc.nextLine());
						System.out.println("Enter lion location");
						sc = new Scanner(System.in);
						p = new Point(sc.nextInt(),sc.nextInt());
						animals_array[i].setLocation(p);
						break;
					case 2:
						System.out.println("Enter bear name");
						sc = new Scanner(System.in);
						animals_array[i]= new Bear(sc.nextLine());
						System.out.println("Enter bear location");
						sc = new Scanner(System.in);
						p = new Point(sc.nextInt(),sc.nextInt());
						animals_array[i].setLocation(p);
						System.out.println("Enter bear fur color");
						sc = new Scanner(System.in);
						((Bear)animals_array[i]).setFurColor(sc.nextLine());
						break;
					case 3:
						System.out.println("Enter elephant name");
						sc = new Scanner(System.in);
						animals_array[i] = new Elephant(sc.nextLine());
						System.out.println("Enter elephant location");
						sc = new Scanner(System.in);
						p = new Point(sc.nextInt(),sc.nextInt());
						animals_array[i].setLocation(p);
						System.out.println("Enter elephant trunk length");
						sc = new Scanner(System.in);
						((Elephant)animals_array[i]).settrunkLength(sc.nextDouble());
						break;
					case 4:
						System.out.println("Enter giraffe name");
						sc = new Scanner(System.in);
						animals_array[i] = new Giraffe(sc.nextLine());
						System.out.println("Enter giraffe location");
						sc = new Scanner(System.in);
						p = new Point(sc.nextInt(),sc.nextInt());
						animals_array[i].setLocation(p);
						System.out.println("Enter giraffe neck length");
						sc = new Scanner(System.in);
						((Giraffe)animals_array[i]).setNeckLength(sc.nextDouble());
						break;
					case 5:
						System.out.println("Enter turtle name");
						sc = new Scanner(System.in);
						animals_array[i] = new Turtle(sc.nextLine());
						System.out.println("Enter turtle loaction");
						sc = new Scanner(System.in);
						p = new Point(sc.nextInt(),sc.nextInt());
						animals_array[i].setLocation(p);
						System.out.println("enter turtle age");
						sc = new Scanner(System.in);
						((Turtle)animals_array[i]).setAge(sc.nextInt());
						break;
					case 6:
						System.out.println("Which plant?\n1.cabbage\n2.lattuce");
						sc = new Scanner(System.in);
						int flag = sc.nextInt();
						if(flag==1) {
							Plant temp_plant = new Cabbage();
							temp_plant.getFoodtype();
							
						}
						if(flag==2) {
							Plant temp_plant2 = new Lettuce();
							temp_plant2.getFoodtype();
						}
						i--;
						
						break;
					default:
						System.out.println("Invalid input");
						i--;
						break;
				}
							
					
			}
/*
* Move method simulation for every animal in array
*/			
			Random rand = new Random();
			System.out.println("****Move simulation****");
			for(Animal animal:animals_array) {
				move(animal,new Point(rand.nextInt(801),rand.nextInt(601)));
			}
			System.out.println("***********************");
/*
* Food lottery with the size of the array (divided by 2) rounds
*/		
			System.out.println("****Animal food lottery****");
			for(int i =0;i<animals_array.length/2;i++) {
				int a = rand.nextInt(animals_array.length);
				int b = rand.nextInt(animals_array.length);
				if(a!=b) {
					animals_array[a].eat(animals_array[b]);
				}
				else {
					System.out.println("Inedible. lottery failed");
				}
				

			}
			System.out.println("***********************");

			
				
				}
		
			}
		}
		
			
		
	




	
	







