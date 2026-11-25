
package com.greenkart.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

   
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

   
    public void searchProduct(String product) {
        driver.findElement(By.cssSelector("input.search-keyword")).sendKeys(product);
    }

   
    public String getProductName() {
        return driver.findElement(By.cssSelector(".product-name")).getText();
    }
    
    public void increaseQuantity() {

        driver.findElement(By.cssSelector(".increment")).click();

    }

}
