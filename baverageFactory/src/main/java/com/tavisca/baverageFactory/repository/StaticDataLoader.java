package com.tavisca.baverageFactory.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tavisca.baverageFactory.model.Ingredient;

public class StaticDataLoader {
	
	
	
	public static Map<String, Double> getBeveragePriceMap(){	
		
		Map<String, Double> bevaragePriceMap=new HashMap<String, Double>(); 
			
		bevaragePriceMap.put("coffee", new Double(5));
		bevaragePriceMap.put("chai", new Double(4));
		bevaragePriceMap.put("banana smoothie", new Double(6));
		bevaragePriceMap.put("strawberry shake", new Double(7));
		bevaragePriceMap.put("mojito", new Double(7.5));
		
		return bevaragePriceMap;
	}
	public static Map<Ingredient, Double> getIngredientsPriceMap(){
		
		Map<Ingredient, Double> IngredientsPriceMap=new HashMap<Ingredient, Double>(); 
			
		IngredientsPriceMap.put(Ingredient.MILK, new Double(1));
		IngredientsPriceMap.put(Ingredient.SUGAR, new Double(0.5));
		IngredientsPriceMap.put(Ingredient.SODA, new Double(0.5));
		IngredientsPriceMap.put(Ingredient.MINT, new Double(0.5));
		IngredientsPriceMap.put(Ingredient.WATER, new Double(0.5));
		
		return IngredientsPriceMap;
	}
	
	
	

}
