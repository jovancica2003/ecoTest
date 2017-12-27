/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.contactInfo;

import domen.ContactInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUtil.PageUtilities;
import pages.basics.Page;

/**
 *
 * @author qa
 */
public class ContactInfoPage extends Page {

    private void clickOnAddNewContact(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }

    private String SendLocation(WebDriver driver) {
        return sendTextOnField(driver, By.id("location"));
    }

    private String SendAddress(WebDriver driver) {
        return sendTextOnField(driver, By.id("address"));
    }

    private int SendAddressNumber(WebDriver driver) {
        return sendNumberOnField(driver, By.id("address_number"));
    }

    private String SendHours(WebDriver driver) {
        return sendTextOnField(driver, By.id("hours"), PageUtilities.getRandomHours());
    }

    private String SendLattitude(WebDriver driver) {
        return sendTextOnField(driver, By.id("latitude"), PageUtilities.getRandomNumber());
    }

    private String SendLongitude(WebDriver driver) {
        return sendTextOnField(driver, By.id("longitude"), PageUtilities.getRandomNumber());
    }

    private String SendPhone(WebDriver driver) {
        return sendTextOnField(driver, By.id("phone"), PageUtilities.getRandomNumber());
    }

    private String SendEmail(WebDriver driver) {
        return sendTextOnField(driver, By.id("email"), PageUtilities.getRandomEmail());
    }

    private int sendZoom(WebDriver driver) {
        return sendNumberOnField(driver, By.id("zoom"));
    }

    public void clickOnSave(WebDriver driver) {
        clickOnElement(driver, By.id("new_portfolio_submit"));
    }
//     public int getIdFromWeb(WebDriver driver) {
//        return getIdFromLastRow(driver, "data-contact-id");
//    }

    public ContactInfo addContactInfo(WebDriver driver) throws InterruptedException {
        ContactInfo ci = new ContactInfo();
        clickOnAddNewContact(driver);

        ci.setLocation(SendLocation(driver));
        ci.setAdress(SendAddress(driver));
        ci.setAdressNumber(SendAddressNumber(driver));
        ci.setHours(SendHours(driver));
        ci.setLatitude(SendLattitude(driver));
        ci.setLongitude(SendLongitude(driver));
        ci.setPhone(SendPhone(driver));
        ci.setEmail(SendEmail(driver));
        ci.setZoom(sendZoom(driver));
        clickOnSave(driver);
        //ci.setId(getIdFromWeb(driver));
        Thread.sleep(5000);
        ci.setId(getIdFromLastRow(driver, "data-contact-id"));

        return ci;
    }
}
