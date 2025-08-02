package Tests.SeleniumDemo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
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
import org.testng.annotations.Test;

import Components.PageObjects.CartPage;
import Components.PageObjects.CheckOutPageConfirmation;
import Components.PageObjects.HomePage;
import Components.PageObjects.ProductsPage;
import Tests.TestComponents.BaseTest;

//import PageObjects.LandingPage;

public class StandaloneTest2 extends BaseTest {

@Test
public void submitOrder() throws IOException, InterruptedException {
		String prod = "BENEFIT BELLA BAMBA";
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();

		
//		HomePage hp = new HomePage(driver);
//		hp.goToUrl();
//		HomePage hp = launchWebApp();
		ProductsPage pp = hp.LoggedIn("asterisk", "Asdf@321");
		
//		ProductsPage pp = new ProductsPage(driver);
		pp.getProducts();
		pp.addProducToCartByName(prod);
		CartPage cp = pp.goToCartPage();
		

		
//		CartPage cp = new CartPage(driver);
		cp.verifyProductInCartPage(prod);
		cp.EnterAddressDetails("India", "Bihar", "BIH122");
		CheckOutPageConfirmation cop = cp.goToConfirmationPage();
		
				

		
//		CheckOutPageConfirmation cop = new CheckOutPageConfirmation(driver);
		cop.checkProductonConfirmationPage(prod);
		cop.confirmOrderText();
			
		
	
	}
	}
	