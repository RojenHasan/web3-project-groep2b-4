package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class AddUserPage extends Page{
    @FindBy(id = "firstname")

    private WebElement firstnameField ;

    @FindBy(id = "lastname")
    private WebElement lastnameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

/*    @FindBy(id = "team")
    private WebElement team;*/

    @FindBy(id = "submit")
    private WebElement submitBtn;


    public AddUserPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL + "addUser.jsp");
    }

    public void setFirstnameField(String firstname) {
        firstnameField.clear();
        firstnameField.sendKeys(firstname);
    }

    public void setLastnameField(String lastnameField) {
        this.lastnameField.clear();
        this.lastnameField.sendKeys(lastnameField);
    }

    public void setEmail(String emailField) {
        this.emailField.clear();
        this.emailField.sendKeys(emailField);
    }
    public void setPassword(String password) {
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
    }

    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }

    public void add(){
        submitBtn.click();
    }

    public boolean hasEmptyFirstname() {
        return firstnameField.getAttribute("value").isEmpty();
    }

    public boolean containsUserWithEmail(String email) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(email)) {
                found=true;
            }
        }
        return found;
    }
}
