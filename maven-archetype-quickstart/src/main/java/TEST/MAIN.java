package TEST;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class MAIN {
	
	@Test
	
 public void demo() {
	 
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://katalon-demo-cura.herokuapp.com/");
	 /* presionar el botón Make appointment  */
	 WebElement btnMakeAppt= driver.findElement(By.id("btn-make-appointment"));
	 btnMakeAppt.click();
	 
	 WebElement usernameField = driver.findElement(By.name("username"));
	 usernameField.sendKeys("John Doe");
	 
	 WebElement passwordField = driver.findElement(By.name("password"));
	 passwordField.sendKeys("ThisIsNotAPassword");
	 
	 WebElement btnLogin= driver.findElement(By.id("btn-login"));
	 btnLogin.click();
	 
	
	 driver.get("https://phptravels.net/home");
	/* WebElement element = driver.findElement(By.tagName("p"));*/
	 
	 WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.tagName("p"))); 
	 
	 
	 WebDriver driver1 = new ChromeDriver();
	 driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver1.get("https://www.phptravels.net/");
	 WebElement element1 = driver1.findElement(By.tagName("p"));
	/* driver.close();*/
	 
	 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		      .withTimeout(Duration.ofSeconds(30))
		      .pollingEvery(Duration.ofSeconds(3))
		      .ignoring(NoSuchElementException.class);

		WebElement element2 = wait.until(new Function<WebDriver, WebElement>() {
		    public WebElement apply(WebDriver driver) {
		        return driver.findElement(By.tagName("p"));
		    }
		});
		 driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		 Alert alert = driver.switchTo().alert();
		 String text = alert.getText();
		
 }
}
