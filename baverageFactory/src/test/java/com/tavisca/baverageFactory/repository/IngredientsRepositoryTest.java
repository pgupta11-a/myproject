package com.tavisca.baverageFactory.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IngredientsRepositoryTest {

	@Autowired
	IngredientsRepository ingredientsRepository;

	@Test
	public void assertBeverageMap() {
		Assertions.assertEquals(5, ingredientsRepository.getIngredientsPriceMap().size());
	}

}
