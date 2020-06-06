package todoist;

import com.sun.codemodel.internal.JCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.invoke.SwitchPoint;
import java.util.concurrent.TimeUnit;

public class Parentest {

    public WebDriver driver;
    public WebDriverWait wait;


    @After
    public void tearDown() {
        driver.quit();

    }


    public void navegarUrl(String url) {

        driver.navigate().to(url);

    }

    public void validarLandingPage() {
        WebElement login = driver.findElement(By.linkText("Inicia sesión"));
        wait.until(ExpectedConditions.visibilityOf(login));
        login.click();
    }

    public void login(String user, String password) {
        WebElement usuario = driver.findElement(By.cssSelector("#email"));
        wait.until(ExpectedConditions.visibilityOf(usuario));
        usuario.click();
        usuario.clear();
        usuario.sendKeys(user);
        WebElement pass = driver.findElement(By.cssSelector("#password"));
        wait.until(ExpectedConditions.visibilityOf(pass));
        pass.click();
        pass.clear();
        pass.sendKeys(password);
        WebElement loginbutton = driver.findElement(By.cssSelector(".submit_btn"));
        wait.until(ExpectedConditions.visibilityOf(loginbutton));
        loginbutton.click();

    }

    public void validarHomePage() {
        WebElement menu = driver.findElement(By.cssSelector(".top_bar_btn"));
        wait.until(ExpectedConditions.visibilityOf(menu));
        menu.click();
        menu.click();


    }

        public void crearProyecto (String nombreProyecto, String color) {
        WebElement agregar = driver.findElement(By.cssSelector(".adder_icon"));
        agregar.click();
        WebElement projectName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#edit_project_modal_field_name")));
        projectName.sendKeys(nombreProyecto);
        WebElement colours = driver.findElement(By.cssSelector(".color_dropdown_select__name"));
        colours.click();
        WebElement colour = driver.findElement(By.cssSelector("#dropdown-select-4-option-31"));
        colour.click();
        WebElement aceptar = driver.findElement(By.cssSelector(".ist_button.ist_button_red"));
        aceptar.click();

        }

        public void validarProyecto (String nombreProyecto, String color){
        WebElement proyectoAgregado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#projects_list > li:last-of-type .name > span")));
        WebElement colorAgregado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#projects_list > li:last-of-type .td_color > div")));

            String expectedColor = "color: rgb(";

            switch (color) {
                case "red":
                    expectedColor += "219, 64, 53);";
                    break;

                case "blue":
                    expectedColor += "20, 170, 245););";
                    break;

            }

        Assert.assertEquals(nombreProyecto, proyectoAgregado.getText());
        Assert.assertEquals(expectedColor, colorAgregado.getAttribute("style"));

            System.out.println(expectedColor + " " + color);


        }

    }

