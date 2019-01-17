package ui.seleniumElement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.collections.Lists;
import ui.initialDriver.Element;

import java.util.ArrayList;
import java.util.List;

public class Windows extends Element {

    public void navigate(String url) {
        driver.navigate().to(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void switchBetweenTabs(int tabIndex) {
        String parentHandle = new ArrayList<>(driver.getWindowHandles()).get(0);
        String anyTabName = new ArrayList<>(driver.getWindowHandles()).get(tabIndex);
        driver.switchTo().window(anyTabName);
        System.setProperty("current.window.handle", parentHandle);
    }

    public int checkPopUpIsClosed() {
        return driver.getWindowHandles().size();
    }


    public void closeChild() {
        selectChild();
        driver.close();
    }

    public void selectChild() {
        String parent = driver.getWindowHandle();
        for (String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(parent)) {
                driver.switchTo().window(childHandle);
            }
        }
    }

    public void allertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public void allertAccept() {
        driver.switchTo().alert().accept();
    }

    public void selectIframe() {
        String parent = driver.getWindowHandle();
        for (String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(parent)) {
                driver.switchTo().frame(childHandle);
            }
        }
    }

    public void selectParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void waitWindows() {
        long startTime = System.currentTimeMillis(); //fetch starting time
        int windows;
        do {

            windows = driver.getWindowHandles().size();
        }
        while (windows > 1 || (System.currentTimeMillis() - startTime) < 10000);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void switchToFrameWithName(String name) {
        driver.switchTo().frame(name);
    }

    public void switchToFrameWithElement(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void openNewTab(Integer tab, String url) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        switchTabAndGetUrl(tab, url);
    }

    public void switchTabAndGetUrl(Integer tab, String url) {
        switchToTab(tab);
        navigate(url);
    }

    public void switchToTab(Integer number) {
        List<String> windowHandleList = Lists.newArrayList(driver.getWindowHandles());
        String tab = windowHandleList.get(number - 1);
        driver.switchTo().window(tab);
    }
}
