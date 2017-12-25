/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.contactInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUtil.PageUtilities;
import pages.basics.Page;

/**
 *
 * @author qa
 */
public class ContactInfoPage extends Page{
    private void clickOnAddNewContact(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }
    
    private String SendLocation (WebDriver driver){
         return sendTextOnField(driver, By.id("location"));
    }
    
    private String SendAddress (WebDriver driver){
         return sendTextOnField(driver, By.id("address"));
    }
    
    private String SendAddressNumber (WebDriver driver){
         return sendTextOnField(driver, By.id("address_number"));
    }
    
    private String SendHours (WebDriver driver){
        return sendTextOnField(driver, By.id("hours"), PageUtilities.getRandomHours());
    }
    
    private String SendLattitude (WebDriver driver){
        return sendTextOnField(driver, By.id("latitude"), PageUtilities.getRandomNumber());
    }
}
