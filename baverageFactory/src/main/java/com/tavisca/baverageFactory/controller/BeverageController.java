package com.tavisca.baverageFactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tavisca.baverageFactory.service.BeverageOrderService;


/**
 *
 * @author Preeti Gupta
 *
 */

@RestController
@RequestMapping("/beverage")
public class BeverageController {

    @Autowired
    BeverageOrderService beverageOrderService;

    @GetMapping("/order")
    public String getBeveragePrice(@RequestParam(value = "order", required = true) String[] order) {
        return beverageOrderService.calculateOrderPrice(order).toString();
    }


}