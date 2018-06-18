package ApiControllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class ConfigControllers {
    public Response response;
    public    ValidatableResponse json;

    //User Controller Endpoints
    public String urlDev = "http://46.101.196.83/api";
    public String signIn = "/oauth/token";
    public String postConfirmRegistration = "/users/confirm-registration";
    public String postConfirmResendEmail = "/users/confirm/resend";
    public String confirmLineUp = "/users/me/team/players";
    public String postUserActivity = "/users/me/activity";
    public String getUserBillingInfo = "/users/me/billing-info";
    public String postSaveBillingInfo = "/users/me/billing-info";
    public String postChangeName = "/users/me/change-name";
    public String clearLineUp = "/users/me/clear-lineup";
    public String putDisableUser = "";


    //Bet Controllers
    public  String manageBets = "/bets/confirm"; //for create betFriend, random, group , and join;

}
