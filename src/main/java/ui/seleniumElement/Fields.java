package ui.seleniumElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.initialDriver.Element;

public class Fields extends Element {

    public void type(By locator, String text)
    {
        waitUntilClickable(locator).clear();
        waitUntilClickable(locator).sendKeys(text);
    }
    public void type(WebElement element, String text)
    {
        waitUntilClickable(element).clear();
        waitUntilClickable(element).sendKeys(text);
    }
    public void type(By locator, Keys keys)
    {
        waitUntilClickable(locator).clear();
        waitUntilClickable(locator).sendKeys(keys);
    }
    public void type(WebElement element, Keys keys)
    {
        waitUntilClickable(element).clear();
        waitUntilClickable(element).sendKeys(keys);
    }
    public void pressEnter (){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER);
    }

}
