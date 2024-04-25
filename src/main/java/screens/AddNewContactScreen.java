package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen{
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputName']")
    MobileElement NameField;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputLastName']")
    MobileElement LastNameField;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement EmailField;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPhone']")
    MobileElement PhoneField;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputAddress']")
    MobileElement AddressField;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputDesc']")
    MobileElement DescField;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/createBtn']")
    MobileElement CreateButton;

    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

//    public Object fillTheForm(Contact contact) {
//return null;
//    }
//    public ContactListScreen createContact(Contact contact){
//        NameField.sendKeys(contact.getName());
//        LastNameField.sendKeys(contact.getLastName());
//        EmailField.sendKeys(contact.getEmail());
//        PhoneField.sendKeys(contact.getPhone());
//        AddressField.sendKeys(contact.getAddress());
//        DescField.sendKeys(contact.getDescription());
//        CreateButton.click();
//        return this;
//    }

    public void fillTheForm(Contact contact) {
        NameField.sendKeys(contact.getName());
        LastNameField.sendKeys(contact.getLastName());
        EmailField.sendKeys(contact.getEmail());
        PhoneField.sendKeys(contact.getPhone());
        AddressField.sendKeys(contact.getAddress());
        DescField.sendKeys(contact.getDescription());
    }

    public void createContact() {
        CreateButton.click();
    }


}

