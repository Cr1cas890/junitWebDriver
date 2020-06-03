package todoist;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TodoistTest extends Parentest{

        @Test
        public void testCrearProyecto() {

            navegarUrl("https://todoist.com");
            validarLandingPage();
            login("jomarnavarro@gmail.com", "Test@1234");
            validarHomePage();
            crearProyecto("CDCS1", "Red");
            validarProyecto("CDCS1", "Red");
        }
 }


