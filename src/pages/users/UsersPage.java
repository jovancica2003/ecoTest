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

    private void clickOnAddUser(WebDriver driver) {
        clickOnElement(driver, By.className("btn-default"));
    }

    private String sendUsername(WebDriver driver) {
        return sendTextOnField(driver, By.id("username"));
    }

    private String sendFirstName(WebDriver driver) {
        return sendTextOnField(driver, By.id("first_name"));
    }

    private String sendLastName(WebDriver driver) {
        return sendTextOnField(driver, By.id("last_name"));
    }

    private String sendEmail(WebDriver driver) {
        return sendTextOnField(driver, By.id("email"), PageUtilities.getRandomEmail());
    }

    private void clickOnSave(WebDriver driver) {
        clickOnElement(driver, By.id("new_user_submit"));
    }

    private void clickOnEditUser(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-pencil"));
    }

    public Users createNewUser(WebDriver driver) {
        Users u = new Users();
        clickOnAddUser(driver);
        u.setUsername(sendUsername(driver));
        u.setFirstName(sendFirstName(driver));
        u.setLastName(sendLastName(driver));
        u.setEmail(sendEmail(driver));
        clickOnSave(driver);
        // u.setId(getIdFromLastRow(driver, "data-user-id"));

        return u;

    }

    public Users editUser(WebDriver driver) throws InterruptedException {
        Users u = new Users();
        clickOnEditUser(driver);
        u.setUsername(sendUsername(driver));
        u.setFirstName(sendFirstName(driver));
        u.setLastName(sendLastName(driver));
        u.setEmail(sendEmail(driver));
        clickOnSave(driver);
        Thread.sleep(5000);

        u.setId(getIdFromLastRowUser(driver, "data-user-id"));

        return u;
    }

    public Users deleteUser(WebDriver driver) {
        Users u = new Users();
        clickOnElement(driver, By.className("glyphicon-trash"));
        clickOnElement(driver, By.className("btn-danger"));

        return u;

    }
}
