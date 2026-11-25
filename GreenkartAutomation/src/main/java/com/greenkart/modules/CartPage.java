package com.greenkart.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage {
	 WebDriver driver;

  public CartPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
  public void openCart() {

	        driver.findElement(By.cssSelector(".cart-icon")).click();

	    }	
  public String getCartProduct() {

      return driver.findElement(By.cssSelector(".cart-item .product-info")).getText();

  }
  

  public String getCartQuantity() {

	    return driver.findElement(
	            By.cssSelector(".cart-items .cart-item .quantity")
	    ).getText();

	}
public void proceedToCheckout() {

    driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

}

public void enterPromoCode(String code) {

 driver.findElement(By.cssSelector("input.promoCode"))
       .sendKeys(code);

}


public void applyPromoCode() {
    driver.findElement(By.cssSelector("button.promoBtn")).click();
}
    

public String getPromoMessage() {
    return driver.findElement(By.className("promoInfo")).getText();
}

public void placeOrder() {
    driver.findElement(By.xpath("//button[text()='Place Order']")).click();
}

public void selectCountry(String country) {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    Select dropdown = new Select(
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.tagName("select")
        ))
    );

    dropdown.selectByVisibleText(country);
}
public void acceptTerms() {
    driver.findElement(By.className("chkAgree")).click();
}

public void proceed() {
    driver.findElement(By.xpath("//button[text()='Proceed']")).click();
}
public String getOrderConfirmation() {
    return driver.findElement(By.className("wrapperTwo")).getText();
}

}
