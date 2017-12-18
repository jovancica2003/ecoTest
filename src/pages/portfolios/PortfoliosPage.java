/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.portfolios;

import domen.Portfolios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.basics.Page;

/**
 *
 * @author Jovanka
 */
public class PortfoliosPage extends Page {
    
    
    
//    private void chooseAllPortfolios(WebDriver driver){
//        clickOnElement(driver, By.className("active"));
//    }
    
    private void clickOnAddPortfolio(WebDriver driver){
        clickOnElement(driver, By.className("glyphicon-plus"));
    }
     
    private String sendFirstName(WebDriver driver) {
        return sendTextOnField(driver, By.id("title"));
    }
    
    private void clickOnDataCategories(WebDriver driver){
        //clickOnElement(driver, By.className("multiselect dropdown-toggle btn"));
        clickOnElement(driver, By.xpath("//*[@id='page-wrapper']/div/div[3]/div/div/div[2]/form/fieldset/div[2]/div[1]/span/div/button"));
    }
    
    private void clickOnSelected(WebDriver driver){
        clickOnElement(driver, By.linkText("Voće"));
    }
//    private String chooseDataCategories(WebDriver driver){
//        WebElement dataCategories = driver.findElement(By.id("data_categories"));
//        Select chooseDataCategories = new Select(dataCategories);
//        chooseDataCategories.selectByIndex(2);
//        return chooseDataCategories.getFirstSelectedOption().getAttribute("value");
//        
//    }
    private String sendCharacteristic1(WebDriver driver){
        return sendTextOnField(driver, By.id("characteristic1"));   
    }
    private String sendCharacteristic2(WebDriver driver){
        return sendTextOnField(driver, By.id("characteristic2"));   
    }
    private String sendDescription(WebDriver driver){
        return sendTextOnField(driver, By.id("description"));   
    }
    
    private String choosePhoto(WebDriver driver){
        //return sendTextOnField(driver, By.id("portfolio_photo"), "C:\\Users\\Jovanka\\Desktop\\bug2.jpg");
         return sendTextOnField(driver, By.id("portfolio_photo"), "/Users/qa/Desktop/1.jpg");
    }
     private void clickOnSave(WebDriver driver) {
        clickOnElement(driver, By.id("new_portfolio_submit"));
    }
      private void clickOnEditPortfolio(WebDriver driver){
          chooseOptionFromLastRow(driver, By.className("btn-default"));
          //clickOnElement(driver, By.className("btn-default"));
      }
      
      private void selectAllCategories(WebDriver driver){
          clickOnElement(driver, By.linkText(" Selektuj sve!"));
      }
      
     public Portfolios addNewPortfolio(WebDriver driver){
         Portfolios p = new Portfolios();
        
        // chooseAllPortfolios(driver);
         clickOnAddPortfolio(driver);
         p.setTitle(sendFirstName(driver));
         clickOnDataCategories(driver);
         clickOnSelected(driver);
        // p.setDataCategories(chooseDataCategories(driver));
         p.setCharacteristic1(sendCharacteristic1(driver));
         p.setCharacteristic2(sendCharacteristic2(driver));
         p.setDescription(sendDescription(driver));
         choosePhoto(driver);
         clickOnSave(driver);
          p.setId(getIdFromLastRow(driver, "data-portfolio-id"));
         return p;
     }
     
     public Portfolios editPortfolio(WebDriver driver){
         Portfolios p = new Portfolios();
         p.setId(getIdFromLastRow(driver, "data-portfolio-id"));
         clickOnEditPortfolio(driver);
         p.setTitle(sendFirstName(driver));
         clickOnDataCategories(driver);
         selectAllCategories(driver);
         selectAllCategories(driver);
         clickOnSelected(driver);
         
         return p;
     }
     
     public Portfolios deletePortfolio(WebDriver driver){
         Portfolios p = new Portfolios();
         p.setId(getIdFromLastRow(driver, "data-portfolio-id"));
         chooseOptionFromLastRow(driver, By.className("glyphicon-trash"));
         clickOnElement(driver, By.className("btn-danger"));
         
         return p;
     }
     private void clickOnPortfolioCategories (WebDriver driver){
         clickOnElement(driver, By.linkText("Categories"));
     }
     private void clickOnAddPortfolio2(WebDriver driver){
         clickOnElement(driver, By.className("btn-default"));
     }
     
     private String sendName(WebDriver driver){
         return sendTextOnField(driver, By.id("name"));
     }
     private void clickOnSave2(WebDriver driver) {
        clickOnElement(driver, By.id("new_category_submit"));
    }
     
     public Portfolios categories(WebDriver driver){
         Portfolios p = new Portfolios();
         p.setId(getIdFromLastRow(driver, "data-portfolio-id"));
         
         return p;
     }
}
