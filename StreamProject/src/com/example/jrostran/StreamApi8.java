package com.example.jrostran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.example.jrostran.CaloryComparator;
import com.example.jrostran.Dish;
import com.example.jrostran.DishType;
import com.example.jrostran.Menu;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

public class StreamApi8 {

	public static void main(String[] args) {
		
		List<Dish> menu = new ArrayList<>();		
		List<Dish> dishes = new ArrayList<>();				
		menu = Arrays.asList
		(				
		new Dish("Pork",800,DishType.MEAT),				
		new Dish("Beef",700,DishType.MEAT),				
		new Dish("Chicken",400,DishType.MEAT),				
		new Dish("FrenchFries",300,DishType.OTHER),				
		new Dish("Rice",200,DishType.OTHER),				
		new Dish("Pizza",100,DishType.OTHER),
		new Dish("Fish",100,DishType.FISH)	
		);				
		/** JAVA 7	
		for (Dish dish : dishes) {			
			if(dish.getCalories() < 400) {				
				menu.add(dish);			
			}		
		}				
		// no Anonima		
		Collections.sort(menu, new CaloryComparator());		
		// version anomina		
		Collections.sort(menu, new Comparator<Dish>() {			
			@Override			
			public int compare(Dish d1, Dish d2) {				
				return Integer.compare( d1.getCalories(),d2.getCalories());			
			}					
		});		
		***/
		
		// API 8		
		List<String> LowCaloriesdishes = menu.stream()
				.filter(m -> m.getCalories() < 400) // filtra
				.sorted(comparing(Dish::getCalories)) // Ordena en base a comparator
				.map(Dish::getName) // es un select tecnicamente
				.collect(toList()); // recolecta los resultados
		System.out.println("LowCaloriesdishes" + LowCaloriesdishes);
		
		// Agrupado por Tipo Plato		
		Map<DishType, List<Dish>> dishestype =menu.stream()												
									.collect(groupingBy(Dish::getDishtype));				
		// FISH :[food1 , food4 ];		//		
		System.out.println("Agrupado por Tipo Plato " + dishestype);
		
		
		// Tomar los primeros 3				
		List<String> takethree = menu.stream()				
		.filter(m-> m.getCalories()>300) // filtra				
		.map(Dish::getName) // es un select tecnicamente				
		.limit(3)				
		.collect(toList()); // recolecta los resultados

		System.out.println("takethree" +takethree);				
		
		// se puede agregar  otras cosas	
		List<String> other = menu.stream()
				.filter(m-> 
					{ 
						System.out.println("Other filtering : " + m.getName());		
						return m.getCalories()> 300;
					})
				.map(m->
					{ 
						System.out.println("Other Mapping : " + m.getName());		
						return m.getName(); 
					})
				.limit(3)
				.collect(toList());
		System.out.println("Other" + other);
		
		// seleccionar el limit		
		long count = menu.stream()				
		.filter(m-> m.getCalories()>300) // filtra				
		.distinct() // es un select tecnicamente				
		.limit(3)				
		.count(); // recolecta los resultados
		System.out.println("Count" + count);
		
		System.out.println("**** Copiando de una lista a otra ****");
		
		
		var list2 = new ArrayList<Address>();
		var list = new ArrayList<Address>();
		var address1 = new Address();
		address1.setStreetName("Magnolia");
		address1.setStreetNumber("9638");
		
		var address2 = new Address();
		address2.setStreetName("McCorkle");
		address2.setStreetNumber("");
		
		var address3 = new Address();
		address3.setStreetName("Mischied");
		address3.setStreetNumber("123");
		
		var address4 = new Address();
		address4.setStreetName("Montford");
		address4.setStreetNumber("224");
		
		var address5 = new Address();
		address5.setStreetName("");
		address5.setStreetNumber("");
		
		var address6 = new Address();
		address6.setStreetName("Mischied");
		address6.setStreetNumber("123");
		
		list.add(address1);
		list.add(address2);
		list.add(address3);
		list.add(address4);
		list.add(address5);
		list.add(address6);
		list.stream().forEach(list2::add );
		
		list2.stream().forEach(a-> { System.out.println("List2 : StreetName : " + a.getStreetName() + " , StreetNumber :" + a.getStreetNumber() );	 });
		
		System.out.println("**** Predicados ****");
		
		// Predicates to filter
		Predicate<Address> streetNumberPredicate = a -> !a.getStreetNumber().isBlank();
		Predicate<Address> streetNamePredicate = a -> !a.getStreetName().isBlank();
		
		var addresses = list.stream()
				.filter(streetNamePredicate.or(streetNumberPredicate))
				.distinct()
				.collect(Collectors.toSet());
				
		
		addresses.stream().forEach(a-> { System.out.println("List2 : StreetName : " + a.getStreetName() + " , StreetNumber :" + a.getStreetNumber() );	 });
		
	}

}
