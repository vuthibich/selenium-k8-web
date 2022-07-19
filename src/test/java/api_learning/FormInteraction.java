package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormInteraction {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {

            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            // Define selector values
            By usernameSel =By.id("username");
            By passwordSel = By.id("#password");
            By loginBtnSel =By.cssSelector("[type=submit]");

            // Find elements-tim
            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginBtnElem = driver.findElement(loginBtnSel);

            // Get attribute vale
            System.out.println("Login btn type: " + loginBtnElem.getAttribute("type"));
            System.out.println("Login btn background color: " + loginBtnElem.getCssValue("background-color"));

            // Interaction
           // usernameElem.clear();
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginBtnElem.click();

            //Go back to previous page
            driver.navigate().back();

            // Refresh page
            driver.navigate().refresh();
            
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        // Quit the browser session
        driver.quit();

        //Implicit wait, explicit wait, Fluent Wait
    }
}
