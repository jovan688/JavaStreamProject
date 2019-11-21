package com.example.jrostran;

import java.util.Comparator;

public class CaloryComparator implements Comparator<Dish> {
	@Override
	public int compare(Dish d1, Dish d2) {
		return Integer.compare( d1.getCalories(),d2.getCalories());			
	}
}
