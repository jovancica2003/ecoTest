/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author qa
 */
public class SeleniumProperties {

    public static String url;
    public static String username;
    public static String password;
    // public static String driverExe;
    public static String dbUrl;
    public static String dbUsername;
    public static String dbPassword;

    public static void init() {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            prop.load(fis);

            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            // driverExe = prop.getProperty("driverExe");

            dbUrl = prop.getProperty("db.url");
            dbUsername = prop.getProperty("db.username");
            dbPassword = prop.getProperty("db.password");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SeleniumProperties.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SeleniumProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
