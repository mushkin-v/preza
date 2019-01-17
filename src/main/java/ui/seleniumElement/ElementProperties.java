package ui.seleniumElement;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.initialDriver.Element;
import utils.Base;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ElementProperties extends Element {


    public String getAttribute(By locator) {
        return waitUntilClickable(locator).getAttribute("href");
    }

    protected boolean isPresent(By locator)
    {
        try {
            waitUntilExist(locator);
            return true;
        }
        catch (NoSuchElementException ex)
        {
            return false;
        }
    }
    protected boolean isPresent(WebElement element)
    {
        try {
            waitUntilExist(element);
            return true;
        }
        catch (NoSuchElementException  ex)
        {
            return false;
        }
    }
    public boolean isDisplayed(By locator)
    {

        return waitUntilVisible(locator).isDisplayed();
    }
    public boolean isDisplayed(WebElement element)
    {
        return waitUntilVisible(element).isDisplayed();
    }
    public boolean isEnabled(WebElement element)
    {
        return waitUntilClickable(element).isEnabled();
    }
    public boolean isEnabled(By locator)
    {
        return waitUntilClickable(locator).isEnabled();
    }
    public boolean isSelected(By locator)
    {
        return waitUntilExist(locator).isSelected();
    }
    public boolean isSelected(WebElement element)
    {
        return waitUntilExist(element).isSelected();
    }


    Base base= new Base();
    public boolean waitUntilTextPresent(By locator,String text)
    {
        WebDriverWait wait = new WebDriverWait(driver, base.TIME_OUT);
        wait.pollingEvery(Duration.ofMillis(base.DELAY));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(InterruptedException.class);
        return wait.until(ExpectedConditions.textToBe(locator,text));
    }
    public boolean waitUntilTextPresent(WebElement element,String text)
    {
        WebDriverWait wait = new WebDriverWait(driver, base.TIME_OUT);
        wait.pollingEvery(Duration.ofMillis(base.DELAY));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(InterruptedException.class);
        return wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public String getTxt(By locator) {
        return waitUntilVisible(locator).getText();
    }

    public WebElement getElementFromList(By locator,int index) {
        waitUntilVisible(locator);
        List<WebElement> elements=driver.findElements(locator);
        return elements.get(index);
    }
    public WebElement getElement(By locator){
        waitUntilVisible(locator);
        WebElement element =  driver.findElement(locator);
        return element;
    }
}
