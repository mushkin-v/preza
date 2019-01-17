package ui.initialDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ui.events.EventHandler;
import ui.events.EventLoger;
import utils.Base;

public class InitialDriver extends Options {
    public static InitialDriver getInstance() {
        if (driverThread.get() == null) {
            synchronized (InitialDriver.class) {
                driverThread.set(new InitialDriver());
            }
        }
        return driverThread.get();
    }
    /*
     * There is pre-initialization of the driver and his way that is it prior to calling object
     */
    private static ThreadLocal<InitialDriver> driverThread = new ThreadLocal<>();

    private WebDriver driver;
    public WebDriver getDriver()
    {
        if(driver==null)
        {
            driver=initialDriver();
            return driver;}
        else {
            return driver;
        }
    }

    private  InitialDriver()
    {
    }

    /*
     * There is setting driver by name
     */
    Base base=new Base();
    private synchronized WebDriver initialDriver() {
        switch (base.DRIVER_NAME)
        {
            case "CHROME":
            {
                WebDriverManager.chromedriver().version(base.DRIVER_VERSION).setup();
                ChromeDriverManager.getInstance().setup();
                driver= new ChromeDriver(chromeOptions());
                driver.manage().window().maximize();
                break;
            }
            case "FIREFOX":
            {
                WebDriverManager.firefoxdriver().setup();
                driver= new FirefoxDriver(firefoxOptions());
                break;
            }
            case "IE":
            {
                driver= new InternetExplorerDriver(internetExplorerOptions());
                break;
            }

        }
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        EventHandler handler=new EventHandler() {};
        EventLoger log= new EventLoger(){};
        driver = eventDriver.register(log);
        driver = eventDriver.register(handler);
        return driver;
    }

    public void destroy()
    {
        if (driver != null)
        {
            getDriver().quit();
            driver = null;
        }
    }


}
