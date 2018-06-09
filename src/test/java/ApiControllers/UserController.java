package ApiControllers;

import static org.hamcrest.Matchers.*;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class UserController extends ConfigControllers {

    String token = "";
    File file = new File("E:\\IntelijIdea\\ATRest1\\src\\test\\Resources\\ConfirmLineUp.json");

@Step("User is logged In")
    public String checkSignIn() {
        response = RestAssured.given()
                .queryParam("grant_type", "password")
                .queryParam("username", "coffe90@mailinator.com")
                .queryParam("platform", "ANDROID")
                .queryParam("password", "Qwe1156q@@").when()
                .headers("Content-Type", "application/x-www-form-urlencoded", "Authorization", "Basic YmV0MTE6YmV0MTE=")
                .post(urlDev + signIn).then().log().all()
                .extract().response();
        response.then().statusCode(200)
                .body("token_type", equalTo("bearer"));
        token = response.path("access_token");
        return token;

    }

@Step("User confirms his line-up")
    public void checkConfirmLineUp(String myToken) {

     response=   RestAssured.given()
                .queryParam("formation", "FOUR_FOUR_TWO")
                .headers("Authorization", "bearer "+myToken,
            "Content-Type", "application/json")
                .body(file).when().post(urlDev+"/users/me/team/players")
             .then().log().all().extract().response();
     response.then().statusCode(404).body("status", equalTo(404));
       /* response =
                request
                        .queryParam("formation", "FOUR_FOUR_TWO")
                        .headers("Authorization", "bearer "+myToken,
                                "Content-Type", "application/json")
                        .body(file)
                        .when()
                        .post(urlDev + "/users/me/team/players")
                        .then().log().all().extract().response();

                //.body("",equalTo("")) */



    }


}
