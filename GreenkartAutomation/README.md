# GreenKart Automation Project

## Project Description

This project automates the GreenKart shopping website using Java, Selenium WebDriver and TestNG.

It covers basic shopping activities such as searching for products, adding items to the cart and completing the checkout process.

The project uses the Page Object Model (POM) to keep the code organized and reusable.

## Technologies Used

- Java 21
- Selenium WebDriver 4.27.0
- TestNG 7.10.2
- Maven
- Eclipse IDE
- Chrome Browser

## Test Scenarios

### 1. Product Search

- Open the GreenKart website.
- Search for Carrot.
- Verify the product name.

### 2. Cart and Checkout

- Search for Carrot.
- Increase the quantity to 2.
- Add the product to the cart.
- Verify the product name and quantity.
- Proceed to checkout.
- Enter an invalid promo code and verify the error message.
- Select India as the country.
- Accept the terms and conditions.
- Place the order.
- Verify the order confirmation message.

## Design Pattern

Page Object Model (POM) is used to organize page actions and test cases separately, making the code easier to maintain and reuse.

## How to Run the Project

1. Import the project into Eclipse as an Existing Maven Project.
2. Update Maven dependencies.
3. Open the required test class.
4. Right-click and select **Run As → TestNG Test**.

## Application URL

https://rahulshettyacademy.com/seleniumPractise/#/

## Test Results

- SearchTest – Passed
- CartTest – Passed

**Tools:** Java | Selenium | TestNG | Maven