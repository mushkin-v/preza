package ui.seleniumElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import ui.initialDriver.Element;

public class Mouse extends Element {



    public void moveMouseToAndClick(By locator, int x, int y) {
        Actions action = new Actions(driver);
        WebElement element = waitUntilClickable(locator);
        action.moveToElement(element, x, y).click().build().perform();

    }

    public void useKeyboard(Keys keys) {
        Actions action = new Actions(driver);
        action.sendKeys(keys).build().perform();
    }

    public void moveMouseTo(By locator) {
        WebElement element = waitUntilClickable(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }


    public void mouseClick(WebElement element)
    {
        Mouse builder= new Mouse();
        builder.mouseClick(element);
    }

    public void mouseClick(By locator)
    {
        Mouse builder= new Mouse();
        builder.mouseClick(locator);
    }
    public void mouseHoverAndClick(WebElement element)
    {
        Mouse builder= new Mouse();
        builder.mouseClickAndHold(element);
    }

    public void mouseHoverAndClick(By locator)
    {
        Mouse builder= new Mouse();
        builder.mouseClickAndHold(locator);
    }

    public void mouseDoubleClick(WebElement element)
    {
        Mouse builder= new Mouse();
        builder.mouseDoubleClick(element);
    }

    public void mouseDoubleClick(By locator)
    {
        Mouse builder= new Mouse();
        builder.mouseDoubleClick(locator);
    }

    public void mouseClickAndHold(By locator)
    {
        Mouse builder= new Mouse();
        builder.mouseClickAndHold(locator);
    }
    public void mouseClickAndHold(WebElement element)
    {
        Mouse builder= new Mouse();
        builder.mouseClickAndHold(element);
    }
    public  void mouseDragAndDrop(WebElement elementFrom,WebElement elementTo)
    {
        Mouse builder= new Mouse();
        builder.mouseDragAndDrop(elementFrom,elementTo);
    }

    public void dragAndDrop(By locator, int x, int y) {
        Actions move = new Actions(driver);
        WebElement element = waitUntilExist(locator);
        Action action = move.dragAndDropBy(element, x, y).build();
        action.perform();
    }


}
