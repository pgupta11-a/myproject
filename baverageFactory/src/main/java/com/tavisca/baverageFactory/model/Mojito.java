package com.tavisca.baverageFactory.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Preeti Gupta
 *
 */
@Component
public class Mojito extends Beverage {

	private List<Ingredient> ingredients = Arrays.asList(Ingredient.SUGAR, Ingredient.WATER, Ingredient.SODA,
			Ingredient.MINT);

	@Override
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
}
