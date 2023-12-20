Feature: Place order

Background: User Login
Given User is on login Page
When User enters "rhande" and "Qwerty"
Then User should be on Home page

@SmokeTest
Scenario: Add Item to cart
Given User should be on Home page
When User add item to cart
Then Item must be added

@RegressionTest
Scenario: Delete Item from cart
Given User should be on Home page
When Item should be present in cart
Then User delete item from cart

@SmokeTest
Scenario: Checkout Order
Given User is on cart page
When User do Purchase
Then Should navigate to Purchase page