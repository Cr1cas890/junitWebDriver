package facebook;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookBaseTest {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public void setUp(String browser, String url) {
		System.out.println("Arranca el browser porfa y navega a la pagina.");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		System.out.println("Destruye la configuracion");
		driver.quit();
	}
	
	protected void likeAllPhotos() {
		// TODO Auto-generated method stub
		
	}

	protected void gotoPhotos() {
		WebElement verFotos = driver.findElement(By.xpath("//div[4]/a/div/div[2]/div/div/div/div/span"));
		verFotos.click();
	}

	protected void searchFacebookFriend(String friendName) {
		WebElement searchBar = driver.findElement(By.cssSelector("[type='search']"));
		searchBar.click();
		searchBar.sendKeys(friendName);
		WebElement friend = driver.findElement(By.xpath("//li[@id='pokiz magadan']/div/div/div/div[2]/span"));
		//									  (By.cssSelector("#projects_list > li:last-of-type .name > span")));

		friend.click(); //
		
	}

	protected void logIntoFacebook(String user, String password) {
		WebElement ussr = driver.findElement(By.cssSelector("#email"));
		//WebElement ussr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
		ussr.click();
		ussr.clear();
		ussr.sendKeys(user);
		WebElement pass = driver.findElement(By.cssSelector("#pass"));
		//WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pass")));
		pass.click();
		pass.clear();
		pass.sendKeys(password);
		WebElement loginButton = driver.findElement(By.cssSelector("#loginbutton"));
		loginButton.click();
		
	}

}
