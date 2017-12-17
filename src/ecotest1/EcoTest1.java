/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecotest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageUtil.PageUtilities;

/**
 *
 * @author qa
 */
public class EcoTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://ecotest.school.cubes.rs/admin_session/login");

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        username.sendKeys("admin");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        password.sendKeys("cubesqa");

        WebElement logIn = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-block")));
        logIn.click();

        WebElement indexSlider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fa-sliders")));
        indexSlider.click();

        WebElement addIndexSlider = wait.until(ExpectedConditions.elementToBeClickable(By.className("glyphicon-plus")));
        addIndexSlider.click();

        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
        titleField.sendKeys(PageUtilities.getRandomText());

        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
        descriptionField.sendKeys(PageUtilities.getRandomText());

        WebElement combo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link_type")));
        Select regionCombo = new Select(combo);
        regionCombo.selectByIndex(3);

        WebElement linkLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link_label")));
        linkLabel.sendKeys(PageUtilities.getRandomText());

        WebElement internalLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("external_link_url")));
        internalLink.sendKeys(PageUtilities.getRandomUrl());

        WebElement choosePhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("index_slide_photo")));
        choosePhoto.sendKeys("/Users/qa/Desktop/1.jpg");

        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.id("new_indexSlide_submit")));
        save.click();

    }

}
