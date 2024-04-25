package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTest extends AppiumConfig {

    @Test
    public void loginPositive() throws InterruptedException {
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("kate24@gmail.com")
                .fillPasswordField("kaT45#kit")
                .clickByLoginButton();
        AuthenticationScreen authenticationScreen = contactListScreen.logout();
        Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());
    }
    @Test
    public void loginNegative() throws InterruptedException {
        SplashScreen splashScreen = new SplashScreen(driver);
        AuthenticationScreen authenticationScreen = splashScreen.switchToAuthScreen();
        authenticationScreen.fillEmailField("kate24gmail.com");
        authenticationScreen.fillPasswordField("kaT45#kit");
        authenticationScreen.clickByLoginButton();

        Assert.assertTrue(authenticationScreen.isErrorTextDisplayed());
        authenticationScreen.clickOkButton();
        Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());
    }
}