/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolios;

import db.DbConnection;
import domen.Portfolios;
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
import pages.portfolios.PortfoliosPage;

/**
 *
 * @author Jovanka
 */
public class TestPortfolios {

    private static WebDriver driver;
    private PortfoliosPage portfoliosPage;
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
        // DbConnection.close();
    }

    @Before
    public void testOpenPortfoilios() {
        System.out.println("Page title is: " + driver.getTitle());
        portfoliosPage = homePage.clickOnAllPortfolios(driver);
    }

    @After
    public void tearDown() {
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void testCreateNewPortfolio() {
        Portfolios portfolioWeb = portfoliosPage.addNewPortfolio(driver);
        Portfolios portfolioDb = DbConnection.getPortfolio("SELECT * FROM `cms_portfolios` WHERE id=" + portfolioWeb.getId());
//        Portfolios portfolioDb = DbConnection.getPortfolio("SELECT * FROM `cms_portfolios` WHERE id=" +34);
       Assert.assertEquals(portfolioWeb.getId(), portfolioDb.getId());
      Assert.assertEquals(portfolioWeb.getTitle(), portfolioDb.getTitle());
//        Assert.assertEquals(portfolioWeb.getDataCategories(), portfolioDb.getDataCategories());
       Assert.assertEquals(portfolioWeb.getCharacteristic1(), portfolioDb.getCharacteristic1());
        Assert.assertEquals(portfolioWeb.getDescription(), portfolioDb.getDescription());

    }

    @Test
    public void testEditPortfolio() {
        Portfolios portfolioWeb = portfoliosPage.editPortfolio(driver);
//        Portfolios portfolioDb = DbConnection.getPortfolio("SELECT * FROM `cms_portfolios` WHERE id=" + portfolioWeb.getId());
//        Assert.assertEquals(portfolioWeb.getId(), portfolioDb.getId());
//        Assert.assertEquals(portfolioWeb.getTitle(), portfolioDb.getTitle());
//        Assert.assertEquals(portfolioWeb.getDataCategories(), portfolioDb.getDataCategories());
//        Assert.assertEquals(portfolioWeb.getCharacteristic1(), portfolioDb.getCharacteristic2());
//        Assert.assertEquals(portfolioWeb.getDescription(), portfolioDb.getDescription());
    }

    @Test
    public void deetePortfolio() {
        Portfolios portfolioWeb = portfoliosPage.deletePortfolio(driver);
        Boolean isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_portfolios` WHERE id=" + portfolioWeb.getId());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
    }
}
