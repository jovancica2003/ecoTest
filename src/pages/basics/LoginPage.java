/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author qa
 */
public class LoginPage extends Page {

    public HomePage logIn(WebDriver driver, String url, String username, String password) {
        driver.get(url);
        sendTextOnField(driver, By.name("username"), username);
        sendTextOnField(driver, By.name("password"), password);
        clickOnElement(driver, By.className("btn-block"));
        HomePage hp = new HomePage();
        return hp;
    }

}
