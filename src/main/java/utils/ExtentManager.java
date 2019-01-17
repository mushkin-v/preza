package utils;


//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(String name){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"\\ExtentReports\\"+name+".html", true);
        }
        return extent;
    }
}