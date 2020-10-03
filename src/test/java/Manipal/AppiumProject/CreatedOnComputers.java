package Manipal.AppiumProject;

import static org.testng.Assert.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreatedOnComputers {

AndroidDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Rahul");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        driver.get("http://demowebshop.tricentis.com");
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws Exception {
		driver.findElementByXPath("//div[@id='mob-menu-button']/a/span[1]/span[1]").click();
	    Thread.sleep(200);
		driver.findElementByXPath("/html/body/div[4]/div[1]/div[2]/ul[2]/li[2]/a").click();
		Thread.sleep(200);
		driver.findElementByXPath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/a/img").click();
		Thread.sleep(200);
		driver.findElementByXPath("//select[@name='products-orderby']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//*[contains(text(),'Created on')]").click();
		Thread.sleep(200);
		Select select = new Select(driver.findElementByXPath("//select[@name='products-orderby']"));
		String option = select.getFirstSelectedOption().getText();
		assertEquals("Created on", option);		
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
}
