package com.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator_Docker {
	
	AppiumDriver<WebElement> driver;
	DesiredCapabilities dc;

    @BeforeClass
	public void calculator_connection() throws MalformedURLException, InterruptedException {

        dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "nexus_5_7.1.1");
		dc.setCapability("browserName", "android");
		dc.setCapability("platformName", "Android");
		//cap.setCapability("seleniumProtocol", "WebDriver");
		dc.setCapability("appPackage", "com.android.calculator2");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url = new URL("http://0.0.0.0:4444/wd/hub");

		// This is local Appium
		// URL url = new URL("http://127.0.0.1:4723/wd/hub/");

		driver = new AppiumDriver<WebElement>(url, dc);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Connection successfuly started!");
    }

    
    /*
        public void methods() {
            // locate the Text on the calculator by using By.name()
            WebElement seven = driver.findElementById("com.android.calculator2:id/digit_7");
            seven.click();
            WebElement plus = driver.findElementById("com.android.calculator2:id/op_add");
            plus.click();
            WebElement three = driver.findElementById("com.android.calculator2:id/digit_3");
            three.click();
            WebElement equalTo = driver.findElementById("com.android.calculator2:id/eq");
            equalTo.click();

            // locate the edit box
            WebElement results = driver.findElementById("com.android.calculator2:id/formula");

            if(results.getText().equals("10"))
            {
                System.out.println("Test Passed...");
            }
            else
            {
                System.out.println("Test Failed...");
            }
        	
        }
        
        */
               

        
        @Test
    	public void test1() throws InterruptedException {

    		System.out.println("This is the test N1");
    		driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
    		driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
    		driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
    		driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
    		driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
    		driver.findElement(By.id("com.android.calculator2:id/eq")).click();
    		
    		String total = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
    		System.out.println(total);		
    		String expected = "2214";
    		
    		Thread.sleep(1000);
    		Assert.assertEquals(total, expected);
    		
    	}
        
        @AfterClass
        public void shutdown() {
        	driver.quit();
        	
        }

}