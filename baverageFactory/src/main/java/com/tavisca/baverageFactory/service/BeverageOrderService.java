package com.tavisca.baverageFactory.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author Preeti Gupta
 *
 */
@Service
public interface BeverageOrderService {

	public Double calculateOrderPrice(String[] order);

}
