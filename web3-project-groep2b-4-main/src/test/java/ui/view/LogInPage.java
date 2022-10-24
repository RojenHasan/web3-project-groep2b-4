package ui.view;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogInPage extends Page{
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement submitBtn;


    @FindBy (id="log-out-btn")
    private WebElement logOutBtn;

    public LogInPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL + "index.jsp");
    }

    public void setEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void add(){
        submitBtn.click();
    }

    public void logOut(){
        this.logOutBtn.click();
    }

    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }




}
