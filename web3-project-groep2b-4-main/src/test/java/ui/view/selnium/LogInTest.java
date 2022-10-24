package ui.view.selnium;

import domain.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.view.DriverHelper;
import ui.view.LogInPage;
import ui.view.util.Utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogInTest {
    private WebDriver driver;
    private LogInPage logInPage;
    private User user;
    @Before
    public void setUp() {
        driver = DriverHelper.getDriver();
        user = new User((int)(Math.random() * 10000) + 1 + "@gmail.com","123","abd","iraqi", "alpha","employee");
    }

    @After
    public void quit(){
        driver.quit();
    }

    @Test
    public void  given_all_fields_filled_in_correctly_when_user_logs_in_user_log_in_and_gets_log_out_page(){
        Utility.addUser(driver, user); // AddUser a user automatically so we are sure he is registered so we can log in with his credentials
        logInPage = PageFactory.initElements(driver,LogInPage.class);
        this.logInPage.logOut();
        assertEquals(logInPage.getTitle(), "Log in");

        logInPage.setPassword(user.getPassword());
        logInPage.setEmail(user.getEmail());
        logInPage.add();
        assertEquals(logInPage.getTitle(), "Log out");

    }

    @Test
    public void  given_password_empty_when_user_logs_in_then_error_msg_is_shown_and_email_is_kept(){
        logInPage = PageFactory.initElements(driver,LogInPage.class);
        logInPage.setEmail(user.getEmail());

        logInPage.add();
        assertTrue(logInPage.hasErrorMessage("email or password is not correct"));
        assertEquals(logInPage.getTitle(), "Log in");

    }

    @Test
    public void given_correct_email_and_wrong_password_when_user_logs_in_then_error_msg_is_shown_and_email_is_kept(){
        logInPage = PageFactory.initElements(driver,LogInPage.class);
        logInPage.setEmail(user.getEmail());
        logInPage.setPassword(user.getPassword() + "something");
        logInPage.add();
        assertTrue(logInPage.hasErrorMessage("email or password is not correct"));
        assertEquals(logInPage.getTitle(), "Log in");
    }
}
