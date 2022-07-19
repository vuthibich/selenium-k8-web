package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTestInteraction {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {// Get a chrome session

            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");


            //By poweredByLinkTextSel =By.linkText("Elemental Selenium");
           By poweredByLinkTextSel =By.partialLinkText("Elemental");

            // Find elements-tim
            WebElement poweredByLinkTextElem = driver.findElement(poweredByLinkTextSel);

            // Interaction
            poweredByLinkTextElem.click();


            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        // Quit the browser session
        driver.quit();

        //Implicit wait, explicit wait, Fluent Wait
    }
}
