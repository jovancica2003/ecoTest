/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photo;

import db.DbConnection;
import domen.Photo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basics.HomePage;
import pages.basics.LoginPage;
//import pages.basics.LoginPage;
import pages.photo.PhotoPage;

/**
 *
 * @author Jovanka
 */
public class TestPhoto {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private PhotoPage photoPage;
    private static LoginPage loginPage;
    private static HomePage homePage;

    @BeforeClass
    public static void testLogin() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage();
        homePage = loginPage.logIn(driver, "http://ecotest.school.cubes.rs/admin_session/login", "admin", "cubesqa");
        DbConnection.getConnection();
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
        DbConnection.close();
    }

    @Before
    public void testOpenPhoto() {
        System.out.println("Page title is: " + driver.getTitle());
        photoPage = homePage.clickOnPhotoGalleries(driver);
    }

    @After
    public void tearDown() {
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void testCreateNewPhotoGallery() {
        Photo photoWeb = photoPage.createNewPhotoGallery(driver);
        Photo photoDb = DbConnection.getPhoto("SELECT * FROM `cms_photo_galleries` WHERE id =" + photoWeb.getId());
        Assert.assertEquals(photoWeb.getId(), photoDb.getId());
//        Assert.assertEquals(photoWeb.getTitle(), photoDb.getTitle());
        //    Assert.assertEquals(photoWeb.getDescription(), photoDb.getDescription());
    }

    @Test
    public void testEditPhotoGallery() {
        Photo photoWeb = photoPage.editPhotoGallery(driver);
        Photo photoDb = DbConnection.getPhoto("SELECT * FROM `cms_photo_galleries` WHERE id =" + photoWeb.getId());
        Assert.assertEquals(photoWeb.getId(), photoDb.getId());
        Assert.assertEquals(photoWeb.getTitle(), photoDb.getTitle());

        Assert.assertEquals(photoWeb.getDescription(), photoDb.getDescription());
    }

    @Test
    public void deletePhotoGallery() {
        Photo indexWeb = photoPage.deletePhotoGallery(driver);
        Boolean isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_index_slides` WHERE id =" + indexWeb.getId());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
    }
}
