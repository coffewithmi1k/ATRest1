package MyFavoriteTests;

import ApiControllers.UserController;
import org.testng.annotations.Test;

public class TestAttempt1 {

UserController userCon = new UserController();

    @Test
    public void Sign(){
        userCon.checkSignIn();
    }

    public void confirmLine(){
        userCon.checkSignIn();
        userCon.checkConfirmLineUp();
    }
}
