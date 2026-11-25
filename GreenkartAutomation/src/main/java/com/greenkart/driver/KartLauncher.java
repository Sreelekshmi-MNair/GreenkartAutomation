package com.greenkart.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KartLauncher {
	
	public static WebDriver driver;
	public static void startKart() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	 public static void stopKart() {

	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
