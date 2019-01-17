package utils;

public class Base {


    public String DRIVER_NAME =  (String) new JSONReader().readJson("/config").get("browser.driver");
    public long TIME_OUT = (Long) new JSONReader().readJson("/config").get("element.wait");
    public long DELAY =  (Long)new JSONReader().readJson("/config").get("element.poling");
    protected long EXIST =  (Long)new JSONReader().readJson("/config").get("element.exist");
    public String DRIVER_VERSION = new JSONReader().readJson("/config").get("driver.version").toString();
}