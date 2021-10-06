import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTest extends TestBase{



    @BeforeMethod
    public void preconditions(){
        app.alert().selectItemAlert();
        app.windows().selectWindows();
    }

    @Test
    public void newTubButtonTest(){
        app.windows().clickOnNewTabWindow();
    }

    @Test
    public void newWindowTest(){

    }

    @Test
    public void newWinwodMessageTest(){

    }
}
