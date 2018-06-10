package ApiControllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class ConfigControllers {
    Response response;
    ValidatableResponse json;

    //User Controller Endpoints
    String urlDev = "http://46.101.196.83/api";
    String signIn = "/oauth/token";
    String postConfirmRegistration ="/users/confirm-registration";
    String postConfirmResendEmail ="/users/confirm/resend";
    String confirmLineUp = "/users/me/team/players";
    String postUserActivity = "/users/me/activity";
    String getUserBillingInfo = "/users/me/billing-info";
    String postSaveBillingInfo = "/users/me/billing-info";
    String postChangeName = "/users/me/change-name";
    String clearLineUp = "/users/me/clear-lineup";
    String putDisableUser ="";


    //Bet Controllers
    String manageBets="/bets/confirm"; //for create betFriend, random, group , and join;

}
