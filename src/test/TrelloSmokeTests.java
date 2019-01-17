
import org.testng.annotations.Test;
import page.Trello;
import utils.Listener;
import static page.MainData.*;

public class TrelloSmokeTests extends Listener {
    Trello trelloPage = new Trello();

    @Test (priority = 1, description = "Login to Trello and add card to board")
    public void loginToTrelloAndAddCard() {
        trelloPage.loginToTrello(loginTrello, loginTrello);
        trelloPage.goToBoard(boardTrello);
        trelloPage.addCard(cardTrello);
        trelloPage.checkThatCardWasAdded(cardTrello);
    }
}
