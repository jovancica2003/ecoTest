/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import db.DbConnection;
import domen.Users;
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
import pages.index.IndexPage;
import pages.users.UsersPage;

/**
 *
 * @author Jovanka
 */
public class TestUsers {
    
    private static WebDriver driver;

    private UsersPage usersPage;
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
        usersPage = homePage.clickOnAllUsers(driver);
    }
    
    @After
    public void tearDown() {
        System.out.println("Page title is: " + driver.getTitle());
    }

    
   @Test
   public void testCreateNewUser(){
       Users userWeb = usersPage.createNewUser(driver);
       Users userDb = DbConnection.getUser("SELECT * FROM `cms_users` ORDER by id DESC LIMIT 1");
//       Assert.assertEquals(userWeb.getId(), userDb.getId());
       Assert.assertEquals(userWeb.getUsername(), userDb.getUsername());
       Assert.assertEquals(userWeb.getFirstName(), userDb.getFirstName());
       Assert.assertEquals(userWeb.getLastName(), userDb.getLastName());
       Assert.assertEquals(userWeb.getEmail(), userDb.getEmail());
       
       
       
   }
}
