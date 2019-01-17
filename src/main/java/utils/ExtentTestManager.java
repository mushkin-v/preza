package utils;


import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest(String testName) {
        ExtentManager.getReporter(testName).endTest(extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = ExtentManager.getReporter(testName).startTest(testName, desc);
        extentTestMap.put((int)  (Thread.currentThread().getId()), test);
        return test;
    }
}