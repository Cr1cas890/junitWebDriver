package imdb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ParentTest {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/Users/cricas/Documents/SELENIUM/INSTALADORES/Drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}
	
	@After
	public void tearDown() {
		driver.quit();
		
	}
	protected void validateMovieExists(String movieName) {
		WebElement resultado = driver.findElement(By.linkText(movieName));
		wait.until(ExpectedConditions.visibilityOf(resultado));
		assertTrue(resultado.isDisplayed());
	}
	protected void searchMovie(String movieName) {

		WebElement campoBusqueda = driver.findElement(By.name("q"));
		campoBusqueda.sendKeys(movieName);
		WebElement botonBusqueda = driver.findElement(By.id("navbar-submit-button"));
		botonBusqueda.click();
	}

	protected void validatePage() {
		WebElement lupa = driver.findElement(By.name("//body/div[@id='IMDbHomepageSiteReactViews']/nav[@id='imdbHeader']/div[2]/div[1]/form[1]/button[1]/*[1]"));
		lupa.click();

				
	}

	protected void navigateToPage(String url) {
		// TODO Auto-generated method stub
		driver.navigate().to(url);
	}
	
		
	

	protected void selectMovie(String movieName, String movieYear) {
		String xpathResultado = "//td[contains(., '" + movieName + " (" + movieYear+ ")')]/a";
		WebElement peliculaCorrecta = driver.findElement(By.xpath(xpathResultado));
		peliculaCorrecta.click();

		// TODO Auto-generated method stub
		
	}
	
	protected void validateMovieStars() {
		// TODO Auto-generated method stub
		
	}


}
