/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import db.DbConnection;
import domen.Index;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.basics.HomePage;
import pages.basics.LoginPage;
import pages.index.IndexPage;

/**
 *
 * @author qa
 */
public class TestIndex {

    private static WebDriver driver;
//    private static WebDriverWait wait;
    private IndexPage indexPage;
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
    public void testOpenIndex() {
        System.out.println("Page title is: " + driver.getTitle());
        indexPage = homePage.clickOnIndexSlider(driver);
    }

    @After
    public void tearDown() {
        System.out.println("Page title is: " + driver.getTitle());

    }

    @Test
    public void testCreateNewIndex() {
        Index indexWeb = indexPage.createNewIndex(driver);
        Index indexDb = DbConnection.getIndex("SELECT * FROM `cms_index_slides` WHERE id =" + indexWeb.getId());
        Assert.assertEquals(indexWeb.getId(), indexDb.getId());
        Assert.assertEquals(indexWeb.getTitle(), indexDb.getTitle());
//         Assert.assertEquals(indexWeb.getDescription(), indexDb.getDescription());
        Assert.assertEquals(indexWeb.getLinkType(), indexDb.getLinkType());
        Assert.assertEquals(indexWeb.getLinkLabel(), indexDb.getLinkLabel());
    }

    @Test
    public void testEditIndex() {
        Index indexWeb = indexPage.editIndex(driver);
        Index indexDb = DbConnection.getIndex("SELECT * FROM `cms_index_slides` WHERE id =" + indexWeb.getId());
        Assert.assertEquals(indexWeb.getId(), indexDb.getId());
        Assert.assertEquals(indexWeb.getTitle(), indexDb.getTitle());
        Assert.assertEquals(indexWeb.getDescription(), indexDb.getDescription());
        Assert.assertEquals(indexWeb.getLinkType(), indexDb.getLinkType());
        Assert.assertEquals(indexWeb.getLinkLabel(), indexDb.getLinkLabel());
    }

    @Test
    public void deleteIndex() {
        Index indexWeb = indexPage.deleteIndex(driver);
        Boolean isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_index_slides` WHERE id =" + indexWeb.getId());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
    }
}
