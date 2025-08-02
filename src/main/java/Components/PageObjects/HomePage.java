package Components.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Components.AbstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Login or register']")
	WebElement login;
	
	@FindBy(id="loginFrm_loginname")
	WebElement uName;
	
	@FindBy(id="loginFrm_password")
	WebElement password;
	
	@FindBy(css="button[title='Login']")
	WebElement loginButton;
	
	
	@FindBy(css=".alert")
	WebElement loginFailedError;
	
	By loginFailedErrorMessage = By.cssSelector(".alert");
	
	
	public void goToUrl()
	{
		driver.get("https://automationteststore.com/");

	}
	
	public ProductsPage LoggedIn(String uname, String pass)
	{
		login.click();
		uName.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
		ProductsPage pp = new ProductsPage(driver);
		return pp;
		
	}
	
	public String loginFailed()
	{
		ExplicitWait(loginFailedErrorMessage);
		return loginFailedError.getText();
	}
	

}
