package Components.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Components.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	@FindBy(css="li[data-id='menu_cart']")
//	WebElement cartLink;
	
	@FindBy(css=".product-list td:nth-child(2)")
	List<WebElement> cartProdLists;
	
	@FindBy(id="estimate_country")
	WebElement country;
	
	@FindBy(id="estimate_country_zones")
	WebElement sub;
	
	@FindBy(id="estimate_postcode")
	WebElement postalCode;
	
	@FindBy(id="cart_checkout2")
	WebElement cartSubmit;
	
	
	
	
	
	public CartPage verifyProductInCartPage(String productName)
	{
//		cartLink.click();
		for (WebElement list : cartProdLists)
		{
			if(list.getText().equalsIgnoreCase(productName))
			{
				System.out.println("Product found in Cart Page");
			}
		}
		
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	public void EnterAddressDetails(String ctry, String subRegion, String postalCd)
	{
		SelectDropdownByText(country,ctry);
		SelectDropdownByText(sub,subRegion);
		postalCode.sendKeys(postalCd);
		//cartSubmit.click();
	}
	

	public CheckOutPageConfirmation goToConfirmationPage()
	{
		cartSubmit.click();
		CheckOutPageConfirmation cop = new CheckOutPageConfirmation(driver);
		return cop;

	}

	

}
