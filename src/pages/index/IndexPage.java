/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.index;

import domen.Index;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageUtil.PageUtilities;
import pages.basics.Page;

/**
 *
 * @author qa
 */
public class IndexPage extends Page {

    private void clickOnAddIndex(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }

    private String sendTitle(WebDriver driver) {
        return sendTextOnField(driver, By.id("title"));
    }

    private String sendDescription(WebDriver driver) {
        return sendTextOnField(driver, By.id("description"), PageUtilities.getRandomText());
    }

    private String sendTextOnLinkLabel(WebDriver driver) {
        return sendTextOnField(driver, By.id("link_label"));
    }

    private String sendInternalUrl(WebDriver driver) {
        return sendUrl(driver, By.id("internal_link_url"));
    }

    private String sendExternalUrl(WebDriver driver) {
        return sendUrl(driver, By.id("external_link_url"));
    }

    private String chooseLinkType(WebDriver driver, int i) {
        WebElement linkType = driver.findElement(By.id("link_type"));
        Select chooseLinkType = new Select(linkType);
        chooseLinkType.selectByIndex(i);
        return chooseLinkType.getFirstSelectedOption().getAttribute("value");
    }

    private String choosePhoto(WebDriver driver) {
       return sendTextOnField(driver, By.id("index_slide_photo"), "/Users/qa/Desktop/1.jpg");
        //return sendTextOnField(driver, By.id("index_slide_photo"),"C:\\Users\\Jovanka\\Desktop\\bug2.jpg");
    }

    private void clickOnSave(WebDriver driver) {
        clickOnElement(driver, By.id("new_indexSlide_submit"));
    }

    private void chooseEditOption(WebDriver driver) {
        chooseOptionFromLastRow(driver, By.className("btn-default"));
    }

    public int getIdFromWeb(WebDriver driver) {
        return getIdFromLastRow(driver, "data-index-slide-id");
    }

    public Index createNewIndex(WebDriver driver) {
//        Index i = new Index();
//        clickOnAddIndex(driver);
//
//        i.setTitle(sendTitle(driver));
//        i.setDescription(sendDescription(driver));
//        i.setLinkType(chooseLinkType(driver, 2));
//        i.setLinkLabel(sendTextOnLinkLabel(driver));
//
//        sendInternalUrl(driver);
//        choosePhoto(driver);
//        clickOnSave(driver);
        //     i.setId(getIdFromLastRow(driver, "data-index-slide-id"));
//
//        return i;
        return steps(driver, "new");
    }

    public Index editIndex(WebDriver driver) {
//        Index i = new Index();
        //   i.setId(getIdFromWeb(driver));
//        chooseEditOption(driver);
//        i.setTitle(sendTitle(driver));
//        i.setDescription(sendDescription(driver));
//        i.setLinkType(chooseLinkType(driver, 3));
//        i.setLinkLabel(sendTextOnLinkLabel(driver));
//        // sendDescription(driver);
//        // chooseLinkType(driver,3);
//        //sendTextOnLinkLabel(driver);
//        sendExternalUrl(driver);
//        choosePhoto(driver);
//        clickOnSave(driver);
//
//        return i;
        return steps(driver, "edit");
    }

    public Index deleteIndex(WebDriver driver) {
        Index i = new Index();
        i.setId(getIdFromWeb(driver));
        chooseOptionFromLastRow(driver, By.className("glyphicon-trash"));
        clickOnElement(driver, By.className("btn-danger"));
        return i;
    }

    private Index steps(WebDriver driver, String option) {
        Index i = new Index();

        if (option.equals("new")) {
            clickOnAddIndex(driver);
        } else {
            chooseEditOption(driver);
        }
        //i.setId(getIdFromLastRow(driver, "data-index-slide-id"));
        //i.setId(getIdFromWeb(driver));
        i.setTitle(sendTitle(driver));
        i.setDescription(sendDescription(driver));

        if (option.equals("new")) {

            i.setLinkType(chooseLinkType(driver, 2));

        } else {

            i.setLinkType(chooseLinkType(driver, 3));

        }

        i.setLinkLabel(sendTextOnLinkLabel(driver));

        if (option.equals("new")) {
            sendInternalUrl(driver);
        } else {
            sendExternalUrl(driver);
        }

        choosePhoto(driver);
        clickOnSave(driver);

        if (option.equals("new")) {
            i.setId(getIdFromLastRow(driver, "data-index-slide-id"));
        } else {
            i.setId(getIdFromWeb(driver));
        }

        return i;

    }
}
