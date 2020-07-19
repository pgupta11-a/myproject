package com.tavisca.baverageFactory.repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.tavisca.baverageFactory.model.Ingredient;
/**
*
* @author Preeti Gupta
*
*/

@Repository
public class IngredientsRepository {

	private Map<Ingredient, Double> ingredientsPriceMap;

	//Loading data using static loader
	
	@PostConstruct
	public void initialize() {

		ingredientsPriceMap = StaticDataLoader.getIngredientsPriceMap();

	}

	public Map<Ingredient, Double> getIngredientsPriceMap() {
		return ingredientsPriceMap;
	}

}
