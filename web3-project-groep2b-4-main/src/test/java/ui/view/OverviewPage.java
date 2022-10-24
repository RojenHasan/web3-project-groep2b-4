package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class OverviewPage extends Page{

    public OverviewPage(WebDriver driver) {
        super(driver);
        this.driver.get(super.getPath() + "Controller?command=Overview");
    }

    public boolean containsUserWithEmail(String email){
        ArrayList<WebElement> webElements = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));

        for (WebElement webElement :webElements){
            System.out.println(webElement);
        }
        return false;

    }
}
