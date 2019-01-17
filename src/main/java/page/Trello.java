package page;

import org.openqa.selenium.By;
import org.testng.Assert;
import ui.seleniumElement.Button;
import ui.seleniumElement.ElementProperties;
import ui.seleniumElement.Fields;
import ui.seleniumElement.Windows;

import static page.MainData.trello;

public class Trello {
    private Button button = new Button();
    private Windows windows = new Windows();
    private Fields fields = new Fields();
    private ElementProperties element = new ElementProperties();

    private By loginButton = By.xpath("//*[contains(text(),'Log In')]");
    private By emailField = By.xpath("//*[@id='user']");
    private By passField = By.xpath("//*[@id='password']");
    private By logInButton = By.xpath("//*[@id='login']");
    private By addCardButton = By.xpath("//*[@id='board']/div[1]/div[1]/a/span[3]");
    private By titleCardField = By.xpath("//*[@id='board']/div[1]/div[1]/div[2]/div/div[1]/div/textarea");
    private By submitCardButton = By.xpath("(//*[@type='submit'])[1]");

    private By boardLocator(String board) {
        return By.xpath("(//*[@title='" + board + "'])[last()]");
    }

    private By cardLocator(String card) {
        return By.xpath("//span[contains(text(),'" + card + "')]");
    }

    public void loginToTrello(String login, String pass) {
        windows.navigate(trello);
        button.click(loginButton);
        fields.type(emailField, login);
        fields.type(passField, pass);
        button.click(logInButton);
    }

    public void goToBoard(String board) {
        button.click(boardLocator(board));
    }

    public void addCard(String card) {
        button.click(addCardButton);
        fields.type(titleCardField, card);
        button.click(submitCardButton);
    }

    public void checkThatCardWasAdded(String card) {
        element.isDisplayed(cardLocator(card));
        String actualCard = element.getTxt(cardLocator(card));
        Assert.assertEquals(actualCard, card);
    }
}
