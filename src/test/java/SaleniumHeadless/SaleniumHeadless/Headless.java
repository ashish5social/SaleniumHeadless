package SaleniumHeadless.SaleniumHeadless;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Headless {
 
	WebDriver driver;
	private static int timeout = 10;
	public WebDriverWait wait;
	private final By SearchTextBox = By.id("input");
	
	//@Test
  public void testWithBrowserGui() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://bigbasket.com");
		driver.manage().window().maximize();
		WebElement loginButton = driver.findElement(By.linkText("Login"));
		loginButton.click();
		WebElement email = driver.findElement(By.id("loginemail"));
		email.sendKeys("ashish5social@gmail.com");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("novell@123");
		// WebElement loginButton1 =
		// driver.findElement(By.xpath("//*[@id=\"login\"]/login/div/form/button"));
		WebElement loginButton1 = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton1.click();
		//// *[@id="login"]/login/div/form/button "//span[@id='red']/span"

		waitUntilElementIsDisplayedOnScreen(SearchTextBox);
		WebElement searchBox = driver.findElement(SearchTextBox);
		searchBox.sendKeys("Potato");
		WebElement searchButton = driver.findElement(By.cssSelector(".btn.btn-default.bb-search"));
		searchButton.click();
		
		driver.quit();

		
	}

    	@Test
	  public void testWithHeadlesssBrowser() {
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			//driver = new ChromeDriver();

			 ChromeOptions options = new ChromeOptions();
		        options.addArguments("headless");
		        options.addArguments("window-size=1200x600");

		        WebDriver driver = new ChromeDriver(options);
		        //driver.get("http://seleniumhq.org");
			
			
			
			driver.get("http://bigbasket.com");
			driver.manage().window().maximize();
			WebElement loginButton = driver.findElement(By.linkText("Login"));
			loginButton.click();
			WebElement email = driver.findElement(By.id("loginemail"));
			email.sendKeys("ashish5social@gmail.com");
			WebElement pwd = driver.findElement(By.id("password"));
			pwd.sendKeys("novell@123");
			// WebElement loginButton1 =
			// driver.findElement(By.xpath("//*[@id=\"login\"]/login/div/form/button"));
			WebElement loginButton1 = driver.findElement(By.xpath("//button[@type='submit']"));
			loginButton1.click();
			//// *[@id="login"]/login/div/form/button "//span[@id='red']/span"

			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//waitUntilElementIsDisplayedOnScreen(SearchTextBox);
			WebElement searchBox = driver.findElement(SearchTextBox);
			searchBox.sendKeys("Potato");
			WebElement searchButton = driver.findElement(By.cssSelector(".btn.btn-default.bb-search"));
			searchButton.click();
			driver.quit();
			
		}

	
	public void waitUntilElementIsDisplayedOnScreen(By selector) {
		try {
			wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		} catch (Exception e) {
			throw new NoSuchElementException(String.format("The following element was not visible: %s ", selector));
		}
	}
	
}
