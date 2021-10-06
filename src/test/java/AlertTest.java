import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends  TestBase {


    @BeforeMethod
    public void preconditions(){
        app.alert().selectItemAlert();
        app.alert().selectAlerts();
    }


    @Test
    public void alerTestButton1(){
        app.alert().clickButton1();
    }

    @Test
    public void alerTestButton2Wait(){
        app.alert().clickButton2();
    }

    @Test
    public void alerTestButton3Cancel(){
        app.alert().clickButtonCancel();
    }


    @Test
    public void alerTestButton3OK(){
        app.alert().clickAlertButtonOK();

    }

    @Test
    public void alerTestButton4SendText(){
        app.alert().clickAlertButtonText();

    }
}
