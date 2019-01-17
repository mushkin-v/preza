package ui.initialDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Base;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Element extends Base {

    protected WebDriver driver = InitialDriver.getInstance().getDriver();


    /**
     * Wait until element would be the clickable
     *
     * @param locator
     * @return
     */
    public WebElement waitUntilClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
        wait.pollingEvery(Duration.ofMillis(DELAY));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(InterruptedException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
        wait.pollingEvery(Duration.ofMillis(DELAY));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait until element would be the visible
     *
     * @param element
     * @return
     */
    protected WebElement waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
        wait.pollingEvery(Duration.ofMillis(DELAY));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(InterruptedException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
        wait.pollingEvery(Duration.ofMillis(DELAY));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(InterruptedException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait until element would be the exist
     *
     * @param locator
     * @return
     */
    public WebElement waitUntilExist(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT / 30);
        wait.pollingEvery(Duration.ofMillis(DELAY));
        wait.ignoring(InterruptedException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitUntilExist(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT / 30);
        wait.pollingEvery(Duration.ofMillis(DELAY));
        wait.ignoring(InterruptedException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public List<WebElement> selectFromList(By locator) {
        waitUntilClickable(locator);
        return driver.findElements(locator);
    }




    /***
     * Wait until element is Present
     * @param locator
     * @return
     */


}
