package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getChromeDriver(){
        String curentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation = "";
        if(OS.isFamilyMac()){
            chromeDriverLocation = curentProjectLocation + "/sr/test/resource/drivers/chromedriver";
        }
        if(OS.isFamilyWindows()){
            chromeDriverLocation = curentProjectLocation + "\\src\\test\\resources\\drivers\\chromedriver.exe";

        }
        if(chromeDriverLocation.isEmpty()){
            throw  new IllegalArgumentException("Can't detect OS type");
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        //Inter time | 500 mili seconds=0.5 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        return driver;


    }
}
