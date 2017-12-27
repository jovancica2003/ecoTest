/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.basics;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUtil.PageUtilities;

/**
 *
 * @author qa
 */
public class Page {

    public WebElement waitForElementClickability(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;

    }

    public void clickOnElement(WebDriver driver, By locator) {
        WebElement target = waitForElementClickability(driver, locator);
        target.click();

    }

    public WebElement waitForElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;

    }

    public String sendTextOnField(WebDriver driver, By locator, String text) {
        WebElement title = waitForElement(driver, locator);
        title.clear();
        title.sendKeys(text);
        return text;

    }

    public String sendTextOnField(WebDriver driver, By locator) {
        WebElement title = waitForElement(driver, locator);
        title.clear();
        String text = PageUtilities.getRandomText();
        title.sendKeys(text);
        return text;

    }

    public String sendUrl(WebDriver driver, By locator) {
        WebElement title = waitForElement(driver, locator);
        title.clear();
        String text = PageUtilities.getRandomUrl();
        title.sendKeys(text);
        return text;

    }

    private WebElement findLastRow(WebDriver driver) {
        WebElement table = driver.findElement(By.id("rows-table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement lastRow = rows.get(rows.size() - 1);

        return lastRow;
    }

    private WebElement findLastRowForUsers(WebDriver driver) {
        WebElement parent = driver.findElement(By.id("rows-table"));
        WebElement table = parent.findElement(By.xpath(("//*[@id='rows-table']/tbody")));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement lastRow = rows.get(rows.size() - 1);

        return lastRow;

    }

    public int getIdFromLastRow(WebDriver driver, String attributeName) {
        WebElement lastRow = findLastRow(driver);
        String id = lastRow.getAttribute(attributeName);
        return Integer.valueOf(id);

    }

    public int getIdFromLastRowUser(WebDriver driver, String attributeName) {
        WebElement lastRow = findLastRowForUsers(driver);
        String id = lastRow.getAttribute(attributeName);
        return Integer.valueOf(id);

    }

    public void chooseOptionFromLastRow(WebDriver driver, By locator) {
        WebElement lastRow = findLastRow(driver);
        WebElement optionButton = lastRow.findElement(locator);
        optionButton.click();

    }

    public int sendNumberOnField(WebDriver driver, By locator) {
        WebElement field = waitForElement(driver, locator);
        field.clear();
        int number = PageUtilities.getRandomInteger();
        field.sendKeys(String.valueOf(number));
        return number;
    }

}
