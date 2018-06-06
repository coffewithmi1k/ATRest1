package ApiControllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ConfigControllers {


    //User Controller
    String urlDev = "http://46.101.196.83/api";
    String signIn ="/oauth/token";
    String confirmLineUp ="/users/me/team/players";
    Response response;
    RequestSpecification request = RestAssured.given();
    ValidatableResponse json;
}
