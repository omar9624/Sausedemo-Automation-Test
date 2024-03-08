package Sausedemo;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddItemToCart {
	
	WebDriver driver = new ChromeDriver();
	
	String url = "https://www.saucedemo.com/";
	
	@BeforeTest
	
	public void beforeTest()
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	
	public void addToCart() throws InterruptedException
	{
		WebElement userName = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		
		Thread.sleep(1000);
		
		//Send Value For The Inputs and Click On Login Button In Login Page
		userName.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginButton.click();
		
		Thread.sleep(1000);
		
		List<WebElement> addToCartButtons = driver.findElements(By.className("btn"));
		
		for(int i = 0 ; i < addToCartButtons.size() ; i++)
		{
			Thread.sleep(1000);
			addToCartButtons.get(i).click();
		}
		
		//Move To Cart Page
		Thread.sleep(1000);
		WebElement cartButton = driver.findElement(By.id("shopping_cart_container"));
		cartButton.click();
		
		//Remove Random Item From Cart And Back To Home Page
		WebElement cartListContainer = driver.findElement(By.className("cart_list"));
		List<WebElement> cartList = cartListContainer.findElements(By.className("btn"));
		
		System.out.println(cartList.size());
		
		Thread.sleep(1000);
		
		Random randomNumber = new Random();
		cartList.get(randomNumber.nextInt(5)).click();
		
		Thread.sleep(1000);
		
		driver.navigate().back();
			
		
	}

}
