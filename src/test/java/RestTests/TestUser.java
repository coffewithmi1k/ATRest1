package RestTests;

import ApiControllers.User;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Epic("User Controller tests")
public class TestUser {

  /*  @BeforeClass
            public void logConfig() {
        String log4jConfPath = "E:\\IntelijIdea\\ATRest1\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }*/

    User userCon = new User();
    String token ="";
    String email = "coffe90@mailinator.com";
    String password = "Qwe1156q@@";

    @BeforeSuite
    public void assignToken(){
        token= userCon.signIn("coffe91@mailinator.com", "Qwe1156q@@");
        System.out.println("This is Before all method"); }

    @Story("Regression")
    @Test(description = "Check sign in request")
    public void sign() {
        userCon.signIn(email,password); }

    @Story("Regression")
    @Test(description = "check line-up confirmation")
    public void checkConfirmLineUp() {
      userCon.checkConfirmLineUp(token); }




}
