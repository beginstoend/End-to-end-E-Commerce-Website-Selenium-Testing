package Tests.SeleniumDemo;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import PageObjects.LandingPage;

public class Standalone {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://automationteststore.com/");
		driver.findElement(By.xpath("//a[text()='Login or register']")).click();
//        LandingPage lp = new LandingPage(driver);
		driver.findElement(By.id("loginFrm_loginname")).sendKeys("asterisk");
		driver.findElement(By.id("loginFrm_password")).sendKeys("Asdf@321");
		driver.findElement(By.cssSelector("button[title='Login']")).click();
		String prod = "BENEFIT BELLA BAMBA";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//LoggedIn page
		driver.findElement(By.cssSelector(".menu_home")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12"));
		for(WebElement product : products)
		{
			product.getText();
//			System.out.println(product.getText());
			
			if(product.getText().contains(prod))
			{
				product.findElement(By.cssSelector(".productcart")).click();
				wait.until(ExpectedConditions.visibilityOf(product.findElement(By.xpath("//a[@title='Added to cart']"))));
				boolean match = product.findElement(By.xpath("//a[@title='Added to cart']")).isDisplayed();
				Assert.assertTrue(match);
				System.out.println("Product Added To Cart :"+product.getText());
			}
			
			
			
		}
		
		//CART
		driver.findElement(By.cssSelector("li[data-id='menu_cart']")).click();
		List<WebElement> lists = driver.findElements(By.cssSelector(".product-list td:nth-child(2)"));
		for (WebElement list : lists)
		{
			if(list.getText().equalsIgnoreCase(prod))
			{
				System.out.println("Product found in Cart Page");
			}
		}
		
		WebElement country=driver.findElement(By.id("estimate_country"));
		Select ctr = new Select(country);
		ctr.selectByVisibleText("India");
		WebElement sub = driver.findElement(By.id("estimate_country_zones"));
		Select subctr = new Select(sub);
		subctr.selectByVisibleText("Bihar");
		driver.findElement(By.id("estimate_postcode")).sendKeys("BIHAR1122");
		driver.findElement(By.id("cart_checkout2")).click();
		
		
		//CheckOut Page
		List<WebElement> cprods =driver.findElements(By.cssSelector(".confirm_products td:nth-child(2)"));
		for(WebElement cprod : cprods)
		{
//			System.out.println(cprod.getText());
			if(cprod.getText().equalsIgnoreCase(prod))
			{
				System.out.println("Product Found in confirm page");
			}
		
		}
		
		driver.findElement(By.id("checkout_btn")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.cssSelector(".maintext")).getText());
	
		
		
	
	}
	}
	