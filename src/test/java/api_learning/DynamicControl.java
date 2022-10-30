package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnabled;
import url.Urls;

import java.io.FileInputStream;
import java.time.Duration;

public class DynamicControl implements Urls {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target base
            driver.get(baseUrl.concat(dynamicControlSlug));

            // Define parent locators | 2 forms | checkbox form + input form
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.id("input-example");

            // Checkbox form interaction
            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            boolean isLocal = System.getenv("isLocal") != null && System.getenv("isLocal").equalsIgnoreCase("true");

            if (isLocal) {
                javascriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 4px solid red;');", checkboxFormElem);
            }

            // DEBUG purpose ONLY
            Thread.sleep(2000);

            WebElement checkboxElem = checkboxFormElem.findElement(By.tagName("input"));
            if (!checkboxElem.isSelected()) checkboxElem.click();

            // DEBUG purpose ONLY
            Thread.sleep(1000);

            // Input form interaction
            WebElement inputFormElem = driver.findElement(inputFormSel);
            WebElement inputFieldElem = inputFormElem.findElement(By.tagName("input"));
            WebElement inputBtnElem = inputFormElem.findElement(By.tagName("button"));
            if (!inputFieldElem.isEnabled()) inputBtnElem.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
            wait.until(new WaitForElementEnabled(By.cssSelector("#input-example input")));
            inputFieldElem.sendKeys("Tui ten la Teo, hello cac ban!!!");

            // DEBUG purpose ONLY
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

}
