/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.photo;

import domen.Photo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUtil.PageUtilities;
import pages.basics.Page;

/**
 *
 * @author qa
 */
public class PhotoPage extends Page {

    private void clickOnAddPhotoGallery(WebDriver driver) {
        // clickOnElement(driver, By.className("btn-default"));
        clickOnElement(driver, By.className("glyphicon-plus"));
    }

    private String sendTitle(WebDriver driver) {
        return sendTextOnField(driver, By.id("title"));
    }

    private String sendDescription(WebDriver driver) {
        return sendTextOnField(driver, By.id("description"), PageUtilities.getRandomText());
    }

    private String choosePhoto(WebDriver driver) {
        return sendTextOnField(driver, By.id("photo_gallery_leading_photo"), "/Users/qa/Desktop/1.jpg");
        //return sendTextOnField(driver, By.id("photo_gallery_leading_photo"), "C:\\Users\\Jovanka\\Desktop\\bug2.jpg");
    }

    private void clickOnSave(WebDriver driver) {
        clickOnElement(driver, By.id("new_photoGallery_submit"));
    }

    public int getIdFromWeb(WebDriver driver) {
        return getIdFromLastRow(driver, "data-photo-gallery-id");
    }

    private void chooseEditOption(WebDriver driver) {
        chooseOptionFromLastRow(driver, By.className("glyphicon-pencil"));
    }

    public Photo createNewPhotoGallery(WebDriver driver) {
        Photo p = new Photo();
        // p.setId(getIdFromWeb(driver));
        p.setId(getIdFromLastRow(driver, "data-photo-gallery-id"));
        clickOnAddPhotoGallery(driver);
        p.setTitle(sendTitle(driver));
        p.setDescription(sendDescription(driver));
        choosePhoto(driver);
        clickOnSave(driver);

        return p;
    }

    public Photo editPhotoGallery(WebDriver driver) {
        Photo p = new Photo();
        p.setId(getIdFromWeb(driver));
        chooseEditOption(driver);
        p.setTitle(sendTitle(driver));
        p.setDescription(sendDescription(driver));
        choosePhoto(driver);
        clickOnSave(driver);
        return p;
    }

    public Photo deletePhotoGallery(WebDriver driver) {
        Photo p = new Photo();
        p.setId(getIdFromWeb(driver));
        chooseOptionFromLastRow(driver, By.className("glyphicon-trash"));
        clickOnElement(driver, By.className("btn-danger"));
        return p;
    }

//    private Photo steps(WebDriver driver, String option){
//        Photo p = new Photo();
//        if(option.equals("new")){
//            
//        }
//        return p;
//    }
}
