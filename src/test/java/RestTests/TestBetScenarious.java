package RestTests;

import ApiControllers.BetController;
import ApiControllers.UserController;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Bet Scenarios")
public class TestBetScenarious {

    UserController userCon = new UserController();
    BetController betCon = new BetController();

    String email1 = "coffe90@mailinator.com";
    String email2 = "coffe91@mailinator.com";
    String email3 = "coffe92@mailinator.com";
    String password1 = "Qwe1156q@@";
    String password2 = "Qwe1156q@@";
    String password3 = "Qwe1156q@@";
    String token1 = "";
    String token2 = "";
    String token3 = "";
    String idRandomBet ="";

    @Story("Random Flow checks")
    @Test
public void checkbetRandomCreationJoin(){
    token1 = userCon.signIn(email1,password1);
    token2 = userCon.signIn(email2,password2);
    userCon.checkConfirmLineUp(token1);
    userCon.checkConfirmLineUp(token2);
    betCon.createBetRandom(token1);
    betCon.joinRandomBet(token2,idRandomBet);
}
}
