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
import Tests.TestComponents.Retry;

//import PageObjects.LandingPage;

public class ErrorValidations extends BaseTest {

@Test(groups="ErrorValidation", retryAnalyzer = Retry.class )
public void loginFailed() throws IOException, InterruptedException {


		ProductsPage pp = hp.LoggedIn("asteris", "Asdf@32");
		hp.loginFailed();
		System.out.println(hp.loginFailed());
		Assert.assertEquals("Login failed", hp.loginFailed());

		
			}

@Test(groups="ErrorValidation")
public void addProductValidation()
{
	String prod = "BENEFIT BELLA BAMBA";

	ProductsPage pp = hp.LoggedIn("asterisk", "Asdf@321");
	

	pp.getProducts();
	pp.addProducToCartByName("product not found");
	
}
	}
	