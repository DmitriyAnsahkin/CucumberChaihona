package Other;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Init{

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void begin(boolean maximaze){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        if (maximaze) driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        //1. Перейти на chaihona.ru
        driver.get("https://chaihona.ru/");
    }

    public static void end (boolean close){
        if (close) driver.close();
    }

}
