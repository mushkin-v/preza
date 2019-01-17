package ui.seleniumElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.initialDriver.Element;

public class Button extends Element {

    public void click(By locator)
    {
        waitUntilClickable(locator).click();
    }
    public void click(WebElement element)
    {
        waitUntilClickable(element).click();
    }
}
