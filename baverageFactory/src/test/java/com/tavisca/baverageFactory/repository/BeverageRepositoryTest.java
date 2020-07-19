package com.tavisca.baverageFactory.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeverageRepositoryTest {

	@Autowired
	BeverageRepository beverageRepository;

	@Test
	public void assertBeverageMap() {
		Assertions.assertEquals(5, beverageRepository.getBeveragePriceMap().size());
	}

}
