package com.greenkart.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.greenkart.driver.KartLauncher;
import com.greenkart.modules.ProductPage;
import com.greenkart.modules.CartPage;
import org.testng.annotations.AfterMethod;
public class CartTest  {

    @Test
    public void addProductToCart() {
    	System.out.println("Cart test started");
        
        
        KartLauncher.startKart();
        ProductPage product = new ProductPage(KartLauncher.driver);

        // Search for Carrot
        product.searchProduct("Carrot");
        

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Wait interrupted");
        }

        product.increaseQuantity();
       
        KartLauncher.driver.findElement(
                By.xpath("//div[@class='product-action']/button")).click();

     
        CartPage cart = new CartPage(KartLauncher.driver);

        cart.openCart();

       
        String cartProduct = cart.getCartProduct();
        System.out.println("Cart Product: " + cartProduct);
        String quantity = cart.getCartQuantity();

        System.out.println("Cart Quantity: " + quantity);
        Assert.assertTrue(cartProduct.contains("Carrot"));
        Assert.assertTrue(quantity.contains("2"));
        
        cart.proceedToCheckout();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Wait interrupted");
        }

        System.out.println("Checkout Page URL: " + KartLauncher.driver.getCurrentUrl());
     // Enter invalid promocode
        cart.enterPromoCode("INVALID123");  
        cart.applyPromoCode();
               try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            System.out.println("Wait interrupted");
        }

         //Get promocode message
        String promoMessage = cart.getPromoMessage();

        System.out.println("Promocode Message: " + promoMessage);
        Assert.assertEquals(promoMessage, "Invalid code ..!");

        System.out.println("Invalid promocode test passed!");
        

        cart.placeOrder();
        System.out.println("Place Order button clicked!");
        
        cart.selectCountry("India");
        System.out.println("Country selected: India");
        
        cart.acceptTerms();
        System.out.println("Terms and Conditions accepted!");
        
        cart.proceed();
        System.out.println("Proceed button clicked!");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        	 System.out.println("Wait interrupted");
        }

        // Get order confirmation message
        String confirmation = cart.getOrderConfirmation();

        System.out.println("Order Confirmation: " + confirmation);

        Assert.assertTrue(confirmation.contains("Thank you, your order has been placed successfully"));

        System.out.println("Order placed successfully!");

    }

    @AfterMethod
    public void closeBrowser() {
        KartLauncher.stopKart();
    }

}