package tests;

import config.AppiumConfig;
import helpers.AddressGenerator;
import helpers.EmailGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PhoneNumberGenerator;
import models.Contact;
import org.testng.annotations.Test;
import screens.AddNewContactScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class AddNewContactTest extends AppiumConfig {

    @Test
    public void addNewContact(){
        new SplashScreen(driver).switchToAuthScreen()
                .fillEmailField("kate24@gmail.com")
                .fillPasswordField("kaT45#kit")
                .clickByLoginButton();
        Contact contact = new Contact(NameAndLastNameGenerator.generateName()
                , NameAndLastNameGenerator.generateLastName(),
                PhoneNumberGenerator.generatePhoneNumber(),
                EmailGenerator.generateEmail(3,3,3),
                AddressGenerator.generateAddress(),"Descr");

    ContactListScreen contactListScreen = new ContactListScreen(driver);
    AddNewContactScreen addNewContactScreen = contactListScreen.openNewContactForm();
    addNewContactScreen.fillTheForm(contact);
    addNewContactScreen.createContact();

    }
}