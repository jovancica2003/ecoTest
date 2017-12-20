/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.users;

import domen.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUtil.PageUtilities;
import pages.basics.Page;

/**
 *
 * @author Jovanka
 */
public class UsersPage extends Page {
    
    private void clickOnAddUser(WebDriver driver){
        clickOnElement(driver, By.className("btn-default"));
    }
    
    private String sendUsername(WebDriver driver){
       return sendTextOnField(driver, By.id("username"));
    }
    
    private String sendFirstName(WebDriver driver){
        return sendTextOnField(driver, By.id("first_name"));
    }
    
    private String sendLastName(WebDriver driver){
        return sendTextOnField(driver, By.id("last_name"));
    }
    
    private String sendEmail (WebDriver driver){
        return sendTextOnField(driver, By.id("email"), PageUtilities.getRandomEmail());
    }
    
    private void clickOnSave(WebDriver driver){
        clickOnElement(driver, By.id("new_user_submit"));
    }
    
    public Users createNewUser(WebDriver driver){
        Users u = new Users();
        clickOnAddUser(driver);
        
        return u;
        
    }
}
