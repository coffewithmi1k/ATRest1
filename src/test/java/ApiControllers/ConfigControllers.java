package ApiControllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class ConfigControllers {
    public Response response;
    public    ValidatableResponse json;


    //User Controller Endpoints
    public String urlDev = "http://46.101.196.83/api";
    public String signIn = "/oauth/token";
    public String postConfirmRegistration = "/users/confirm-registration";
    public String postConfirmResendEmail = "/users/confirm/resend";
    public String confirmLineUp = "/users/me/team/players";
    public String userInfo = "/users/me";
    public String postUserActivity = "/users/me/activity";
    public String getUserBillingInfo = "/users/me/billing-info";
    public String postSaveBillingInfo = "/users/me/billing-info";
    public String postChangeName = "/users/me/change-name";
    public String clearLineUp = "/users/me/clear-lineup";
    public String putDisableUser = "";
    public String friendsList ="/users/me/friend/list";
    public String latestLineUp = "/users/me/latest-lineups";
    public String currentLineUp = "/users/me/lineups/current";
    public String userSession ="/users/me/session";
    public String userWallet ="/users/me/wallet";
    public String userProfile ="/users/profile";
    public String autofillPlayers ="/players/random";

    //Bet Controllers
    public  String manageBets = "/bets/confirm"; //for create betFriend, random, group , and join;




}
