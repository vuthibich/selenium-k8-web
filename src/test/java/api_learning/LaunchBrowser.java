package api_learning;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
    public static void main(String[] args) {
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
        //driver.manage().window().maximize();
        driver.get("https://tiki.com/");

        //DEBUG
        try {
            Thread.sleep(3000);
        }catch ( Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
