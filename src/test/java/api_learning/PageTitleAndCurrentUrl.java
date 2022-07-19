package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageTitleAndCurrentUrl {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
        }catch (Exception e){
            e.printStackTrace();
        }

        // Quit the browser session
        driver.quit();

        //Implicit wait, explicit wait, Fluent Wait
    }
}
