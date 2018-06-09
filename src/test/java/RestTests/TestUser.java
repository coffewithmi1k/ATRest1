package RestTests;

import ApiControllers.UserController;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.apache.log4j.PropertyConfigurator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("User TestsEpic")
public class TestUser {

  /*  @BeforeClass
            public void logConfig() {
        String log4jConfPath = "E:\\IntelijIdea\\ATRest1\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }*/

    UserController userCon = new UserController();
    String token ="";

    @Story("Dummy testsStory")
    @Test

    public void sign() {
        userCon.checkSignIn();
    }

    @Story("Dummy testsStory")
    @Test
    public void confirmLineUp() {

      token=  userCon.checkSignIn();
      userCon.checkConfirmLineUp(token);

    }




}
