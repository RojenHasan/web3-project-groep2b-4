package ui.view;

import domain.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.view.util.Utility;

import java.util.ArrayList;

public class EditUserPage extends Page {
    private String beforeLastEmail;
    @FindBy(id = "submit")
    private WebElement submitBtn;

    @FindBy(id = "firstname")

    private WebElement firstnameField ;

    @FindBy(id = "lastname")
    private WebElement lastnameField;

    @FindBy(id = "email")
    private WebElement emailField;

    public EditUserPage(WebDriver driver) {
        super(driver);

        setBeforeLastEmail();
        redirectToEditConf();
    }

    private void redirectToEditConf(){
        this.driver.get(Config.BASE_URL + "Controller?command=Edit&id="+getLastUserId());

    }

    private int getLastUserId(){
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("tr"));
        WebElement last = listItems.get(listItems.size()-1);
        return Integer.parseInt(last.getText().split(" ")[0]);
    }

   public String getBeforeLastEmail(){
        return beforeLastEmail;
   }
    private void setBeforeLastEmail(){
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("tr"));

        WebElement last = listItems.get(listItems.size()-2);
        this.beforeLastEmail = last.getText().split(" ")[3];
    }

    public void  setFirstnameField(String firstname){
        this.firstnameField.clear();
        this.firstnameField.sendKeys(firstname);
    }


    public void  setLastnameField(String lastname){
        this.lastnameField.clear();
        this.lastnameField.sendKeys(lastname);
    }

    public void update() {
        submitBtn.click();
    }

    public void setEmailField(String email) {
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }

    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
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
