package RestTests;

import ApiControllers.BetController;
import ApiControllers.User;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Bet Scenarios")
public class TestBets {

    User userCon = new User();
    BetController betCon = new BetController();


    String createBetFriend ="";

    String email1 = "coffe90@mailinator.com";
    String email2 = "coffe91@mailinator.com";
    String email3 = "coffe92@mailinator.com";
    String password = "Qwe1156q@@";
    int betId;
    int idRandomBet;
    int groupBetId;

    @Story("Bet Flow checks")
    @Test(description = "Create and join to Random bet")
    public void checkbetRandomCreationJoin() {
      String  token1 = userCon.signIn(email1, password);
      String  token2 = userCon.signIn(email2, password);
        userCon.checkConfirmLineUp(token1);
        userCon.checkConfirmLineUp(token2);
        idRandomBet = betCon.createBetRandom(token1);
        betCon.joinRandomBet(token2, idRandomBet);
    }

    @Test
    @Story("Create full group bet public")
    public void checkFullPublicBet() {
       String token = userCon.signIn("coffe100@mailinator.com", password);
       userCon.checkConfirmLineUp(token);


    }


    @Test
    @Story("Check bet Friend bet")
    public void checkbetFriendBet() {

    }

    @Test
    @Story("Check Group bet private")
    public void checkGroupPrivateBet() {

    }

    @Test
    @Story("Check Group bet public")
    public void checkGroupPublicBet() {

    }


}
