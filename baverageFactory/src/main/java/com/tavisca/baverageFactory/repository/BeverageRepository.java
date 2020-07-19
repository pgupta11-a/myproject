package com.tavisca.baverageFactory.repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

/**
 *
 * @author Preeti Gupta
 *
 */
@Repository
public class BeverageRepository {
	private Map<String, Double> beveragePriceMap;

	//Loading data using static data loader
	@PostConstruct
	public void initialize() {
		beveragePriceMap = StaticDataLoader.getBeveragePriceMap();

	}

	public Map<String, Double> getBeveragePriceMap() {
		return beveragePriceMap;
	}

}
