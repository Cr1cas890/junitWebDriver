package todoist;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TodoistTest extends Parentest{

    @Test
    @FileParameters("./data/paramsTodoist.csv")
    public void atestCrearProyecto(String url, String user, String password,
                                  String nombreProyecto, String color) throws InterruptedException {
        navegarUrl(url);
        sleep();
        validarLandingPage();
        sleep();
        login(user, password);
        sleep();
        validarHomePage();
        sleep();
        crearProyecto(nombreProyecto,  color);
        sleep();
        validarProyecto(nombreProyecto,  color);
        System.out.println("proyecto creado");

    }

    @Test
    @FileParameters("./data/paramsTodoistBorrar.csv")
    public void borrard0Proyecto(String url, String user, String password) throws InterruptedException {
        navegarUrl(url);
        sleep();
        validarLandingPage();
        sleep();
        login(user, password);
        sleep();
        validarHomePage();
        sleep();
        borrar();
        System.out.println("proyecto borrado");

    }

    private void sleep() throws InterruptedException {
        Thread.sleep(800);

    }

}




