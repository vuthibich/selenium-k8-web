package api_learning;

import dev.failsafe.internal.util.Assert;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementDisplaying {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        List<WebElement> elementsList=driver.findElements(By.tagName("Taobao"));
        if(!elementsList.isEmpty())


        // Quit the browser session
        driver.quit();

        //Implicit wait, explicit wait, Fluent Wait
    }
}
