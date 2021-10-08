package applications;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HelperWindows extends applications.HelperBase {
    public HelperWindows(WebDriver wd) {
        super(wd);
    }

    public void selectWindows() {
        click(By.xpath("//span[.='Browser Windows']"));
    }

    public void clickOnNewTabWindow() {
        click(By.id("tabButton"));
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
        System.out.println(wd.findElement(By.id("sampleHeading")).getText());

    }

    public void clickOnNewWindowButton() {
        String mainWindow = wd.getWindowHandle();
        click(By.id("windowButton"));

        List<String> wndws = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(wndws.get(1));
        pause(500);
        wd.switchTo().window(wndws.get(0));
        pause(300);
    }
}




