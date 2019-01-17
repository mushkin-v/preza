package ui.initialDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

class Options  {

    public ChromeOptions chromeOptions()
    {
        ChromeOptions options= new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        return options;
    }


    public FirefoxOptions firefoxOptions()
    {
        FirefoxOptions options= new FirefoxOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-infobars");
        return options;
    }

    public InternetExplorerOptions internetExplorerOptions()
    {
        InternetExplorerOptions options= new InternetExplorerOptions();
        return options;
    }
}
