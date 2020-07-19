package com.tavisca.baverageFactory.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 *
 * @author Preeti Gupta
 *
 */
@Component
public class Chai extends Beverage {

	private List<Ingredient> ingredients = Arrays.asList(Ingredient.SUGAR, Ingredient.MILK, Ingredient.WATER);

	@Override
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
}