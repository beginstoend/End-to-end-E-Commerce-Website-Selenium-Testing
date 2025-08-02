package Components.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void ExplicitWait(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void SelectDropdownByText(WebElement r , String passValue)
	{
		Select s = new Select(r);
		s.selectByContainsVisibleText(passValue);
	}
	
	public void systemWait() throws InterruptedException
	{
		Thread.sleep(5000);
	}

}
