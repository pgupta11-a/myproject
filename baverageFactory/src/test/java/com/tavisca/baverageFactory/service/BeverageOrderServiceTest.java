package com.tavisca.baverageFactory.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tavisca.baverageFactory.exception.BeverageOrderException;

@SpringBootTest
class BeverageOrderServiceTest {

	@Autowired
	BeverageOrderService beverageOrderService;

	@Test
	void contextLoads() {
	}

	@Test
	public void assertOrder() {
		Assertions.assertEquals((Double) 6.0, beverageOrderService.calculateOrderPrice(new String[] {"banana smoothie"}));
	
	
	}
	@Test
	public void assertOrderWithMultipleBeverages() {
		Assertions.assertEquals((Double) 29.5, beverageOrderService.calculateOrderPrice(new String[] {"Strawberry shake","chai","coffee","mojito","banana smoothie"}));
	
	}
	
	@Test
	public void assertCustomOrders() {
		Assertions.assertEquals((Double) 3.5, beverageOrderService.calculateOrderPrice(new String[] {"Chai, -Water"}));
	}
	
	@Test
	public void assertOrderWithMultipleAndCustomizedBeverages() {
		Assertions.assertEquals((Double) 8.0, beverageOrderService.calculateOrderPrice(new String[] {"Chai, -Milk","Coffee"}));
	
	
	}

	@Test
	public void assertRemoveAllIngredients() {
		Assertions.assertThrows(BeverageOrderException.class, () -> {
			beverageOrderService.calculateOrderPrice(new String[] {"strawberry shake, -Water, -Sugar, -Milk"});
		});
	}

	@Test
	public void assertInvalidOrders() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			beverageOrderService.calculateOrderPrice(new String[] {"strawberry shake, -Test, -Sugar, -Milk"});
		});

		Assertions.assertThrows(BeverageOrderException.class, () -> {
			beverageOrderService.calculateOrderPrice(new String[] {"Chai-Milk"});
		});

		Assertions.assertThrows(BeverageOrderException.class, () -> {
			beverageOrderService.calculateOrderPrice(new String[] {" , - "});
		});



	}

}