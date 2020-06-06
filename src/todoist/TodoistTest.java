package todoist;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
@RunWith(JUnitParamsRunner.class)
public class TodoistTest extends Parentest{

    @Test
    @FileParameters("./data/paramsTodoist.csv")
    public void testCrearProyecto(String browser, String url, String user, String password,
                                  String nombreProyecto, String color) {
        navegarUrl(url);
        validarLandingPage();
        login(user, password);
        validarHomePage();
        crearProyecto(nombreProyecto,  color);
        validarProyecto(nombreProyecto,  color);
    }
}


