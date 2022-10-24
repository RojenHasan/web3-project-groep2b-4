package ui.view.util;

import domain.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.view.AddUserPage;

public class Utility {
    public static AddUserPage  addUser(WebDriver driver, User user){
        AddUserPage page = PageFactory.initElements(driver,AddUserPage.class);
        page.setEmail(user.getEmail());
        page.setFirstnameField(user.getFirstname());
        page.setLastnameField(user.getLastName());
        page.setPassword(user.getPassword());
        page.add();
        return page;
    }
}
