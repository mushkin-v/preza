import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class easyButWrongWayTest {

    @Test
    public void trelloAddTaskTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/qafestchenko/IdeaProjects/preza/src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://trello.com/");
        driver.findElement(By.xpath("//*[contains(text(),'Log In')]")).click();
        driver.findElement(By.xpath("//*[@id='user']")).clear();
        driver.findElement(By.xpath("//*[@id='user']")).sendKeys("uqburhagqozz@dropmail.me");
        driver.findElement(By.xpath("//*[@id='password']")).clear();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("uqburhagqozz@dropmail.me");
        driver.findElement(By.xpath("//*[@id='login']")).click();
        Thread.sleep(1000);
        driver.navigate().to("https://trello.com/b/VLp726RG/untitled-board");

        driver.findElement(By.xpath("//*[@id='board']/div[1]/div[1]/a/span[3]")).click();
        driver.findElement(By.xpath("//*[@id='board']/div[1]/div[1]/div[2]/div/div[1]/div/textarea")).sendKeys("Learn JAVA!!!");
        driver.findElement(By.xpath("//*[@id='board']/div[1]/div[1]/div[2]/div/div[1]/div/textarea")).sendKeys(Keys.ENTER);

        String task = driver.findElement(By.xpath("//*[@id='board']/div[1]/div[1]/div[2]/a[2]/div[3]/span")).getText();
        Assert.assertEquals(task,"Learn JAVA!!!");

        driver.quit();
    }
}
