/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.index.IndexPage;
import pages.photo.PhotoPage;
import pages.portfolios.PortfoliosPage;
import pages.users.UsersPage;

/**
 *
 * @author qa
 */
public class HomePage extends Page {
//    

    public IndexPage clickOnIndexSlider(WebDriver driver) {
        clickOnElement(driver, By.className("fa-sliders"));
        IndexPage ip = new IndexPage();
        return ip;

    }

    public PhotoPage clickOnPhotoGalleries(WebDriver driver) {
        clickOnElement(driver, By.className("fa-photo"));
        PhotoPage pp = new PhotoPage();
        return pp;
    }

    public PortfoliosPage clickOnAllPortfolios(WebDriver driver) {
        //clickOnElement(driver, By.className("active"));
        //clickOnElement(driver, By.xpath("//*[@id='side-menu']/li[7]/ul/li[1]/a"));
        clickOnElement(driver, By.linkText("All Portfolios"));
        PortfoliosPage pfp = new PortfoliosPage();
        return pfp;
    }

    public UsersPage clickOnAllUsers(WebDriver driver) {
        clickOnElement(driver, By.linkText("All Users"));
        UsersPage up = new UsersPage();
        return up;
    }
}
