
package com.greenkart.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import com.greenkart.driver.KartLauncher;
import com.greenkart.modules.ProductPage;

public class SearchTest {

    @Test
    public void searchProduct() {

        KartLauncher.startKart();

        ProductPage product = new ProductPage(KartLauncher.driver);

        product.searchProduct("Carrot");
        

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Wait interrupted");
        }

        String actualProduct = product.getProductName();

        System.out.println("Search Result: " + actualProduct);

        Assert.assertTrue(actualProduct.contains("Carrot"),
                "Carrot not found!");
       
    }

    @AfterMethod
    public void closeBrowser() {
        KartLauncher.stopKart();
    }
}
