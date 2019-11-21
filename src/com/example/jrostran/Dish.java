package com.example.jrostran;

public class Dish {

	private int Calories;
	private String Name;
	private DishType dishtype;
	
	public int getCalories() {
		return Calories;
	}

	public void setCalories(int calory) {
		this.Calories = calory;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public DishType getDishtype() {
		return dishtype;
	}

	public void setDishtype(DishType dishtype) {
		this.dishtype = dishtype;
	}

	public Dish(String name, int calory, DishType meat) {
		this.Name = name;
		this.Calories = calory;
		this.dishtype = meat;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.Name;
	}
	
	

}
