Java Assessment Exercise:
Expectations from the Solution:
• Proper use of collections/data structures.
• Clean, readable and testable code.
• Do not waste time in creating a menu item accepting interface, just a method with String array input parameter is enough.
• Do not Over engineer the problem.
• Writing Unit tests is a must and Cover few boundary cases through tests.
Beverage Factory:
We are the owners of a beverage factory which serves a variety of drinks, juices etc to the customers from its pre-defined set of menu Items.
We offer the customers a choice to customize their drinks in case they want to avoid some specific ingredients from their drinks,
e.g. a person ordering "Chai Latte" which has ingredients as "tea leaves, milk, water, sugar, condiments" a person can order a chai latter without sugar and condiments.
The order value is recalculated based on the actual price of the menu minus the price of the removed ingredient.
So if 1 Cup Chai costed 5 $ and sugar costed 0.5 $ and milk costed 1$ the order: "Chai, - sugar, -milk" would charge
5 - 0.5 - 1.0=3.5$ for the order.
The order to be placed to the shop is always a String concatenated by exclusions.
1. "Chai, -sugar"
2. "Chai, -sugar, -milk"
3. "Chai"
4. ["Chai, -sugar", "Chai", "Coffee, -milk"] // Chai and Tea are menu items
are all valid orders.
As a part of this exercise you have to write a program should be able to compute the total price of the order placed. Remember the order can only be a String.
Below are the Menu Items with their respective ingredients and prices:
Coffee: "Coffee, milk, sugar, water" Price: 5$
Chai: "Tea, milk, sugar, water" Price: 4$
Banana Smoothie: "banana, milk, sugar, water" Price: 6$
Strawberry Shake: "Strawberries, sugar, milk, water" Price: 7 $
Mojito: "Lemon, sugar, water, soda, mint" Price 7.5 $
Ingredients prices:
Milk: 1 $
Sugar: 0.5 $
Soda: 0.5 $
mint: 0.5 $
water: 0.5 $
Remember corner cases like:
- Each order should have at least one menu item
- An order can exist without exclusion
- An order cannot have all the ingredients in exclusion for a menu item.
A simple Java program or rest implementation anything would work, make sure there are ample tests to cover all the scenarios that can exist in the problem.
Use in memory collections/structures to create the seed data.
