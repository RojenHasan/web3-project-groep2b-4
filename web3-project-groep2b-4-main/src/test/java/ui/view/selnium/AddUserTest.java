package ui.view.selnium;

import domain.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.view.AddUserPage;
import ui.view.DriverHelper;
import ui.view.OverviewPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddUserTest {
    private  WebDriver driver;
    private AddUserPage addUserPage;

    private User user;
    @Before
    public void setUp() {
        driver = DriverHelper.getDriver();
        addUserPage = PageFactory.initElements(driver,AddUserPage.class);
        user = new User((int)(Math.random() * 10000) + 1 ,(int)(Math.random() * 10000) + 1+
                "@gmail.com","123","abd","iraqi", "employee","alpha");
        addUserPage.setPassword(user.getPassword());
        addUserPage.setLastnameField(user.getLastName());
        addUserPage.setEmail(user.getEmail());
        addUserPage.setFirstnameField(user.getFirstname());
    }

    @After
    public void quit(){
        driver.quit();
    }

    @Test
    public void given_email_format_not_correct_then_error_message_given_for_email_fields_value_are_kept_except_password(){
        addUserPage.setEmail("aaa");
        addUserPage.add();

        assertTrue(addUserPage.hasErrorMessage("Email not valid"));
        assertEquals(addUserPage.getTitle(),"AddUser user");

    }

    @Test
    public void  given_firstname_empty_then_error_message_given_for_name_and_other_fields_value_are_kept_except_password(){
        addUserPage.setFirstnameField("");
        addUserPage.add();
        assertTrue(addUserPage.hasErrorMessage("No firstname given"));
        assertEquals(addUserPage.getTitle(),"AddUser user");
        assertTrue(addUserPage.hasEmptyFirstname());
    }

    @Test
    public  void given_all_fields_filled_in_correctly_when_user_added_then_user_is_added() {
        addUserPage.add();
        OverviewPage overviewPage = PageFactory.initElements(driver, OverviewPage.class);
        assertEquals("Users", overviewPage.getTitle());
        assertTrue(addUserPage.containsUserWithEmail(user.getEmail()));
    }

}
