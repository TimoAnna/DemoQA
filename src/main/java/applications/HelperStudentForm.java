package applications;

import models.StudentForm;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class HelperStudentForm extends applications.HelperBase {
    public HelperStudentForm(WebDriver wd) {
        super(wd);

    }

    public void selectItemForms() {
        if (isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[2]"));
        pause(500);
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[.='Practice Form']"));
    }

    public void fillForm(StudentForm model) {
        type(By.id("firstName"), model.getFirstName());
        type(By.id("lastName"), model.getLastName());
        type(By.id("userEmail"), model.getEmail());
        selectGender(model.getGender());
        type(By.id("userNumber"), model.getPhone());
        //   typeBDay(By.id("dateOfBirthInput"), model.getBirthday());
        typeBDayWithCalendar(By.id("dateOfBirthInput"), model.getBirthday());
        addSunjectByEnter(model.getSubject());
        selectHobbies(model.getHobbies());
        type(By.id("currentAddress"), model.getAddress());
        typeState(model.getState());
        typeCity(model.getCity());


    }

    private void typeCity(String city) {
        wd.findElement(By.xpath("//div[contains(@class,'css-1hwfws3')]")).click();
        WebElement x = wd.findElement(By.id("react-select-4-input"));
        x.sendKeys(city);
        x.sendKeys(Keys.ENTER);
        pause(1000);
    }


    private void typeState(String state) {
        scroll(0, 300);
       wd.findElement(By.xpath("//div[contains(text(),'Select State')]")).click();
       WebElement x  = wd.findElement(By.id("react-select-3-input"));
        x.sendKeys(state);
        x.sendKeys(Keys.ENTER);
        pause(2000);



        pause(2000);

    }


    private void selectHobbies(String hobby) {
        String[] hobbies = hobby.split(" ");
        for (String s : hobbies) {
            switch (s) {
                case "Sports":
                    click(By.cssSelector("label[for='hobbies-checkbox-1']"));
                    break;
                case "Reading":
                    click(By.cssSelector("label[for='hobbies-checkbox-1']"));
                    break;
                case "Music":
                    click(By.cssSelector("label[for='hobbies-checkbox-3']"));
                    break;
            }
        }
    }


    private void addSunjectByEnter(String subject) {
        type(By.id("subjectsInput"), subject);
        wd.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);

    }


    private void typeBDayWithCalendar(By locator, String birthday) {
        //13 01 1992
        String[] data = birthday.split(" ");
        click(locator);
        new Select(wd.findElement(By.cssSelector(".react-datepicker__year-select"))).selectByValue(data[2]);
        pause(1000);
        new Select(wd.findElement(By.cssSelector(".react-datepicker__month-select")))
                .selectByIndex(Integer.parseInt(data[1]) - 1);
        pause(1000);

        int day = Integer.parseInt(data[0]);
        //  wd.findElement(By.xpath("//div[text()= '13']")).click();
        String loc = String.format("//div[text()= '%s']", day);
        //  click(By.xpath(loc));
        List<WebElement> list = wd.findElements(By.xpath(loc));
        WebElement el;
        //если есть повторы да в календаре то делаем проверку
        if (list.size() > 1 && day > 15) {
            el = list.get(1);
        } else {
            el = list.get(0);
        }
        el.click();
        pause(2000);

    }


    private void typeBDay(By locator, String birthday) {
        WebElement element = wd.findElement(locator);
        element.click();
        String os = System.getProperty("os.name");
        System.out.println(os);
        if (os.startsWith("Mac")) {
            element.sendKeys(Keys.chord(Keys.COMMAND + "a"));
        } else {
            element.sendKeys(Keys.chord(Keys.LEFT_CONTROL + "a"));
        }
        element.sendKeys(birthday);
        pause(700);

    }


    private void selectGender(String gender) {
        if (gender.equals("Male")) {
            click(By.xpath("//label[@for='gender-radio-1']"));
        } else if (gender.equals("Female")) {
            click(By.xpath("//label[@for='gender-radio-2']"));
        } else {
            click(By.xpath("//label[@for='gender-radio-3']"));
        }
    }


    public void submit() {
        click(By.id("submit"));
    }
}
