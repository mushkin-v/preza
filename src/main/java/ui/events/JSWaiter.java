package ui.events;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.initialDriver.Element;

class JSWaiter extends Element {

    private WebDriverWait jsWait=new WebDriverWait(driver, EXIST);



    //Wait for JQuery Load
    public  void waitForJQueryLoad() {
        try {


            //Wait for jQuery to load
            ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) driver)
                    .executeScript("return jQuery.active") == 0);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            //Get JQuery is Ready
            boolean jqueryReady = (Boolean) js.executeScript("return jQuery.active==0");

            //Wait JQuery until it is Ready!
            if(!jqueryReady) {
                System.out.println("JQuery is NOT Ready!");
                //Wait for jQuery to load
                jsWait.until(jQueryLoad);
            } else {
                System.out.println("JQuery is Ready!");
            }
        }
        catch (Exception ex)
        {
            System.out.println("Jquery not working"+ex.getMessage());
        }
    }


    //Wait for Angular Load
    public  void waitForAngularLoad() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;

        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

        //Wait for ANGULAR to load
        ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
                .executeScript(angularReadyScript).toString());

        //Get Angular is Ready
        boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

        //Wait ANGULAR until it is Ready!
        if(!angularReady) {
            System.out.println("ANGULAR is NOT Ready!");
            //Wait for Angular to load
            wait.until(angularLoad);
        } else {
            System.out.println("ANGULAR is Ready!");
        }
    }

    //Wait Until JS Ready
    public  void waitUntilJSReady() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady =  (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if(!jsReady) {
            System.out.println("JS in NOT Ready!");
            //Wait for Javascript to load
            wait.until(jsLoad);
        } else {
            System.out.println("JS is Ready!");
        }
    }

    //Wait Until JQuery and JS Ready
    public  void waitUntilJQueryReady() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;

        //First check that JQuery is defined on the page. If it is, then wait AJAX
        Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined == true) {
            //Pre Wait for stability (Optional)
            sleep(20);

            //Wait JQuery Load
            waitForJQueryLoad();

            //Wait JS Load
            waitUntilJSReady();

            //Post Wait for stability (Optional)
            sleep(20);
        }  else {
            System.out.println("jQuery is not defined on this site!");
        }
    }

    //Wait Until Angular and JS Ready
    public  void waitUntilAngularReady() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;

        //First check that ANGULAR is defined on the page. If it is, then wait ANGULAR
        Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
        if (!angularUnDefined) {
            Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
            if(!angularInjectorUnDefined) {
                //Pre Wait for stability (Optional)
                sleep(20);

                //Wait Angular Load
                waitForAngularLoad();

                //Wait JS Load
                waitUntilJSReady();

                //Post Wait for stability (Optional)
                sleep(20);
            } else {
                System.out.println("Angular injector is not defined on this site!");
            }
        }  else {
            System.out.println("Angular is not defined on this site!");
        }
    }

    //Wait Until JQuery Angular and JS is ready
    public  void waitJQueryAngular() {
        try {

            waitUntilJQueryReady();
            waitUntilAngularReady();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static void sleep (Integer seconds) {
        long secondsLong = (long) seconds;
        try {
            Thread.sleep(secondsLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}