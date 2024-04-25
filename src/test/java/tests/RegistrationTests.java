package tests;

import config.AppiumConfig;
import helpers.EmailGenerator;
import helpers.PasswordStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationNewUserTest(){
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField(EmailGenerator.generateEmail(5,5,3))
                .fillPasswordField(PasswordStringGenerator.generateString())
                .clickByRegistrationButton();
        Assert.assertTrue(contactListScreen.isContactListPresent());
    }
    @Test
    public void registrationWithInvalidEmailShouldFail() {
        String invalidEmail = EmailGenerator.generateEmail(5, 5, 3);

        SplashScreen splashScreen = new SplashScreen(driver);
        AuthenticationScreen authScreen = splashScreen.switchToAuthScreen();

        authScreen.fillEmailField(invalidEmail)
                .fillPasswordField(PasswordStringGenerator.generateString())
                .clickByRegistrationButton();
        Assert.assertTrue(authScreen.isEmailFieldDisplayed());
        Assert.assertFalse(authScreen.isErrorMessageDisplayed());
        authScreen.clickOkButton();
        Assert.assertFalse(authScreen.isErrorMessageDisplayed());
    }
}