package ui.view.selnium;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import domain.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import ui.view.*;
import ui.view.util.Utility;


public class EditUserTest {
    private WebDriver driver;
    private EditUserPage editUserPage;

    @Before
    public void setUp() {
        driver = DriverHelper.getDriver();
        Utility.addUser(driver, new User((int)(Math.random() * 10000) + 1 + "@gmail.com","123","abd","iraqi", "alpha","employee"));
        Utility.addUser(driver, new User((int)(Math.random() * 10000) + 1 + "@gmail.com","123","abd","iraqi", "alpha","employee"));
        this.editUserPage = PageFactory.initElements(driver,EditUserPage.class);

    }

    @After
    public void quit(){
        //driver.quit();
    }
    @Test
    public void given_all_fields_filled_in_correctly_when_user_updates_then_userd_is_updated(){
        editUserPage.setEmailField("updated@gmail.com");
        editUserPage.setFirstnameField("updatedFirst");
        editUserPage.setLastnameField("updatedLast");
        editUserPage.update();
        assertEquals(driver.getTitle(), "Users");
        assertTrue(editUserPage.containsUserWithEmail("updated@gmail.com"));

    }

    @Test
    public void given_name_field_empty_when_user_updates_error_msg_is_shown_and_user_info_is_kept(){
        editUserPage.setFirstnameField("");
        editUserPage.update();
        assertEquals(editUserPage.getTitle(), "Edit");

    }

    @Test
    public void given_email_that_exists_when_user_updates__error_msg_is_shown_and_user_info_is_kept(){
        editUserPage.setEmailField(editUserPage.getBeforeLastEmail());
        editUserPage.update();
        assertTrue(editUserPage.hasErrorMessage("already exist"));
    }
}
