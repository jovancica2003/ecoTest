/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import setup.SeleniumProperties;

/**
 *
 * @author cubes6
 */
public class PageUtilities {

    public static WebDriver initWebDriver(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "/Users/qa/Downloads/chromedriver");
//        SeleniumProperties.init();
//        System.setProperty("webdriver.chrome.driver", SeleniumProperties.driverExe);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static String getRandomText() {
        return "Test" + (int) (Math.random() * 1000);
    }

    public static int getRandomInteger() {
        return (int) (Math.random() * 1000);
    }

    public static String getRandomUrl() {
        return "http://".concat(getRandomText()).concat(".te");
//            return "http://" +(getRandomText())+(".te");
    }

    public static String getRandomEmail() {
        return getRandomText().concat("@").concat(getRandomText());
    }

    public static String getRandomHours() {
        return (int) (Math.random() * 1000) + "-" + (int) (Math.random() * 1000);
    }
    
    public static String getRandomNumber(){
        return String.valueOf((int) (Math.random() * 10000));
    }

}
