package com.tavisca.baverageFactory.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tavisca.baverageFactory.repository.IngredientsRepository;

@Component
public abstract class Beverage {

	@Autowired
	IngredientsRepository ingredientsRepository;
	private Double price;

	public abstract List<Ingredient> getIngredients();

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}