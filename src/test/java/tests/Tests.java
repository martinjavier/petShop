package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		//DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com");
		try {
			Thread.sleep(2000);		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void searchGoogle() {
		// Accept Cookies
		driver.findElement(By.xpath("//button[@id='L2AGLb']//div[@class='QS5gu sy4vM']")).click();
		waitTwoSec();
		// Input 'automation'
		driver.findElement(By.id("APjFqb")).sendKeys("automation");
		waitTwoSec();
		// Click search button
		driver.findElement(By.name("btnK")).click();
		waitTwoSec();
		List<WebElement> wikipediaLinkList = driver.findElements(By.xpath("//a[contains(@href,'https://es.wikipedia.org/wiki/Automation')]"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean verifyWikiElement = wikipediaLinkList.get(0).isDisplayed();
		
		if(verifyWikiElement) {
			wikipediaLinkList.get(0).click();
		}
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	public void waitTwoSec() {
		try {
			Thread.sleep(2000);		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


