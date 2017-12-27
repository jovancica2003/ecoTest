/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactInfo;

import db.DbConnection;
import domen.ContactInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.basics.HomePage;
import pages.basics.LoginPage;
import pages.contactInfo.ContactInfoPage;

/**
 *
 * @author qa
 */
public class TestContactInfo {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private ContactInfoPage contactInfoPage;

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
    public void testOpenContactInfo() {
        System.out.println("Page title is: " + driver.getTitle());
        contactInfoPage = homePage.clickOnContactInfo(driver);
    }

    @After
    public void tearDown() {
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void testCreateContactInfo() throws InterruptedException {
        ContactInfo contactInfoWeb = contactInfoPage.addContactInfo(driver);
        ContactInfo contactInfoDb = DbConnection.getContactInfo("SELECT * FROM `cms_contact` WHERE id= " + contactInfoWeb.getId());
        Assert.assertEquals(contactInfoWeb.getId(), contactInfoDb.getId());
        Assert.assertEquals(contactInfoWeb.getLocation(), contactInfoDb.getLocation());
        Assert.assertEquals(contactInfoWeb.getAdress(), contactInfoDb.getAdress());
        Assert.assertEquals(contactInfoWeb.getAdressNumber(), contactInfoDb.getAdressNumber());
        Assert.assertEquals(contactInfoWeb.getLatitude(), contactInfoDb.getLatitude());
        Assert.assertEquals(contactInfoWeb.getLongitude(), contactInfoDb.getLongitude());
        Assert.assertEquals(contactInfoWeb.getZoom(), contactInfoDb.getZoom());
        Assert.assertEquals(contactInfoWeb.getPhone(), contactInfoDb.getPhone());
        Assert.assertEquals(contactInfoWeb.getEmail(), contactInfoDb.getEmail());
        Assert.assertEquals(contactInfoWeb.getHours(), contactInfoDb.getHours());
    }
}
