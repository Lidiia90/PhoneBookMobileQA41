package tests;

import config.AppiumConfig;
import helpers.EmailGenerator;
import helpers.PasswordStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.NoSuchElementException;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationNewUserTest() {
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField(EmailGenerator.generateEmail(5, 5, 3))
                .fillPasswordField(PasswordStringGenerator.generateString())
                .clickByRegistrationButton();
        Assert.assertTrue(contactListScreen.isContactListPresent());
    }

    @Test
    public void registrationWithInvalidEmailShouldFail() {
        String invalidEmail = EmailGenerator.generateEmail(5, 5, 3);
        SplashScreen splashScreen = new SplashScreen(driver);
        AuthenticationScreen authScreen = splashScreen.switchToAuthScreen();
        WebElement emailField = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.id("com.sheygam.contactapp:id/inputEmail")));
        authScreen.fillEmailField(invalidEmail)
                .fillPasswordField(PasswordStringGenerator.generateString())
                .clickByRegistrationButton();
        try {
            authScreen.clickOkButton();
        } catch (StaleElementReferenceException e) {
            authScreen = new AuthenticationScreen(driver);
            authScreen.clickOkButton();
        }

        Assert.assertFalse(authScreen.isErrorMessageDisplayed());
        Assert.assertTrue(authScreen.isItAuthenticationScreen());
    }
}


