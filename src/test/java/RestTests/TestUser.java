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
    static String  token ="";
    String email = "coffe90@mailinator.com";
    String password = "Qwe1156q@@";

    @BeforeSuite
    public  void assignToken(){
        token= userCon.signIn("coffe62@mailinator.com", "Qwe1156q@@");
        System.out.println("This is Before all method"); }

    @Story("Regression")
    @Test(description = "Check sign in request")
    public void sign() {
        userCon.signIn(email,password); }

    @Story("Regression")
    @Test(description = "check line-up confirmation")
    public void checkConfirmLineUp() {
      userCon.checkConfirmLineUp(token); }

    @Story("Regression")
    @Test(description = "check user Info")
    public void checkUserInfo() {
        userCon.checkUserInfo(token); }

    @Story("Regression")
    @Test(description = "check User Activity")
    public void checkUserActivity() {
        userCon.getUserActivity(token); }
    @Story("Regression")
    @Test(description = "check Clear Line-up")
    public void checkClearLineUp() {
        userCon.checkClearLineUp(token); }

    @Story("Regression")
    @Test(description = "check user FriendList")
    public void checkFriendsList() {
        userCon.checkFriendsList(token); }

    @Story("Regression")
    @Test(description = "check user FriendList")
    public void checkLatestLineUp() {
        userCon.checkLatestLineUp(token); }

    @Story("Regression")
    @Test(description = "check user currentLineup")
    public void checkCurrentLineUp() {
        userCon.checkCurrentLineUp(token); }

    @Story("Regression")
    @Test(description = "check user Session")
    public void checkUserSession() {
        userCon.checkUserSession(token); }

    @Story("Regression")
    @Test(description = "check user Wallet")
    public void checkUserWallet() {
        userCon.checkUserWallet(token); }

    @Story("Regression")
    @Test(description = "check user Profile")
    public void checkUserProfile() {
        String userId = "5ae17a306344590007cca2ef";
        userCon.checkUserProfile(token,userId); }

    @Story("Regression")
    @Test(description = "check Auto fill line-up")
    public void checkAutoFillLineUp() {
    userCon.autoFillLineUp(token);
    }
}
