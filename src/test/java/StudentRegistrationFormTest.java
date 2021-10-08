import models.StudentForm;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegistrationFormTest extends TestBase {



    @BeforeMethod
    public void preConditions(){
        app.forms().selectItemForms();
        app.forms().selectPracticeForm();
        app.forms().hideFooter();
    }


    @Test
    public void studetRegFormTest(){
        StudentForm model = new StudentForm()
                .setFirstName("Anna")
                .setLastName("Smith")
                .setEmail("annna123@gmail.com")
                .setGender("Female")
                .setPhone("2583691470")
                .setBirthday("13 1 1992")
                .setSubject("English")
                .setHobbies("Music")
                .setAddress("Rehovot")
                .setState("NCR")
                .setCity("Gurgaon");

        app.forms().fillForm(model);
       app.forms().submit();
    }





}
