package ui.seleniumElement;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ui.initialDriver.Element;

public class JSExecuter extends Element {
    public void JSClick()
    {

    }

    public void scrollToNecessaryElement(WebElement element) {
        int y = element.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0," + y + ")");
    }

    public void scrollToNecessaryElement(By locator) {
        WebElement element = waitUntilClickable(locator);
        int y = element.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0," + y + ")");
    }

}
