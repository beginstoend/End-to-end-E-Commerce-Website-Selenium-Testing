package Components.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Components.AbstractComponents.AbstractComponent;

public class ProductsPage extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="li[data-id='menu_cart']")
	WebElement cartLink;
	
	@FindBy(css=".menu_home")
	WebElement homeProducts;
	
	@FindBy(css=".col-md-3.col-sm-6.col-xs-12")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".col-md-3.col-sm-6.col-xs-12");
	By addCartConfirm = By.xpath("//a[@title='Added to cart']");
	
	
	public List<WebElement> getProducts()
	{
		homeProducts.click();
		ExplicitWait(productsBy);
//		System.out.println(products.get(0).getText());
		return products;
	}
	
	public void addProducToCartByName(String productName)
	{
		for(WebElement product : products)
		{
			product.getText();
//			System.out.println(product.getText());
			
			if(product.getText().contains(productName))
			{
				product.findElement(By.cssSelector(".productcart")).click();
				ExplicitWait(addCartConfirm);			
				boolean match = product.findElement(By.xpath("//a[@title='Added to cart']")).isDisplayed();
				Assert.assertTrue(match);
				System.out.println("Product Added To Cart :"+product.getText());
			}
			
			
			
		}
		
	
	}
	public CartPage goToCartPage()
	{
		cartLink.click();
		CartPage cp = new CartPage(driver);
		return cp;

		
	}
	

	


}
