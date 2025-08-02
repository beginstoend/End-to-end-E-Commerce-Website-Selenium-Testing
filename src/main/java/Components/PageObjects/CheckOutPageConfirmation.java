package Components.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Components.AbstractComponents.AbstractComponent;

public class CheckOutPageConfirmation extends AbstractComponent{
	
	WebDriver driver;
	
	public CheckOutPageConfirmation(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".confirm_products td:nth-child(2)")
	List<WebElement> cprods;
	
	@FindBy(css=".maintext")
	WebElement confirmOrder;
	
	@FindBy(id="checkout_btn")
	WebElement checkOutSubmit;
	
	
	public void checkProductonConfirmationPage(String productName)
	{
		for(WebElement cprod : cprods)
		{
//			System.out.println(cprod.getText());
			if(cprod.getText().equalsIgnoreCase(productName))
			{
				System.out.println("Product Found in confirm page");
			}
		
		}
		
		checkOutSubmit.click();
	}
	
	public void confirmOrderText() throws InterruptedException
	{
		systemWait();
		System.out.println(confirmOrder.getText());
	}
	

	
	
	
	
	

	

	

}
