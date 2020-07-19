package com.tavisca.baverageFactory.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavisca.baverageFactory.exception.BeverageOrderException;
import com.tavisca.baverageFactory.model.BananaSmoothie;
import com.tavisca.baverageFactory.model.Beverage;
import com.tavisca.baverageFactory.model.Chai;
import com.tavisca.baverageFactory.model.Coffee;
import com.tavisca.baverageFactory.model.Ingredient;
import com.tavisca.baverageFactory.model.Mojito;
import com.tavisca.baverageFactory.model.StrawberryShake;
import com.tavisca.baverageFactory.repository.BeverageRepository;
import com.tavisca.baverageFactory.repository.IngredientsRepository;

/**
 *
 * @author Preeti Gupta
 *
 */

@Service
public class BeverageOrderServiceImpl implements BeverageOrderService {

	Beverage beverage;
	@Autowired
	Chai chai;
	@Autowired
	Mojito mojito;
	@Autowired
	StrawberryShake strawberryShake;
	@Autowired
	BananaSmoothie bananaSmoothie;
	@Autowired
	Coffee coffee;
	@Autowired
	BeverageRepository beverageRepository;
	@Autowired
	IngredientsRepository ingredientsRepository;

	@Override
	public Double calculateOrderPrice(String[] orderItems) {

		Double totalPrice = 0.0;
	
		for (String order : orderItems) {
			beverage = getCustomizedBeverage(order);
			totalPrice += beverage.getPrice();
		}
		return totalPrice;
	}

	private Beverage getCustomizedBeverage(String item) {

		String ingredients[] = item.toLowerCase().split(", -");
		String beverageName = ingredients[0];

		setBeverage(beverageName);

		beverage.setPrice(beverageRepository.getBeveragePriceMap().get(beverageName));

		if (ingredients.length == 1) {
			return beverage;
		}
		excludeIngredients(ingredients, beverage);
		return beverage;
	}

	private boolean isValidIngredient(Ingredient ingredient, Beverage beverage) {
		return beverage.getIngredients().contains(ingredient);
	}

	// TODO: This can be enhanced later

	private void excludeIngredients(String[] ingredients, Beverage beverage) throws BeverageOrderException {

		List<Ingredient> excludedIngredients = Arrays.asList(Arrays.copyOfRange(ingredients, 1, ingredients.length))
				.stream().map(i -> Ingredient.valueOf(i.toUpperCase())).collect(Collectors.toList());

		if (beverage.getIngredients().size() == (excludedIngredients.size())
				&& beverage.getIngredients().containsAll(excludedIngredients)) {
			throw new BeverageOrderException("Invalid Order");
		}
		excludedIngredients.stream().forEach(ingredient -> {
			if (!isValidIngredient(ingredient, beverage)) {
				throw new BeverageOrderException("Invalid Order");
			}
			beverage.setPrice(beverage.getPrice() - ingredientsRepository.getIngredientsPriceMap().get(ingredient));
		});
	}

	private void setBeverage(String beverageName) {
		switch (beverageName) {
		case "chai":
			beverage = chai;
			break;
		case "coffee":
			beverage = coffee;
			break;
		case "mojito":
			beverage = mojito;
			break;
		case "strawberry shake":
			beverage = strawberryShake;
			break;
		case "banana smoothie":
			beverage = bananaSmoothie;
			break;
		default:
			throw new BeverageOrderException("Invalid order, please retry.");

		}
	}

}
