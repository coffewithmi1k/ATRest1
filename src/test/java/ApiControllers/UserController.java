package ApiControllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class UserController extends ConfigControllers {

    String token = "";

    public void checkSignIn() {
        response = request.headers("Content-Type", "application/x-www-form-urlencoded",
                "Authorization", "Basic YmV0MTE6YmV0MTE=")
                .formParam("grant_type", "password")
                .formParam("username", "coffe90@mailinator.com")
                .formParam("platform", "ANDROID")
                .formParam("password", "Qwe1156q@@").when()
                .post(urlDev + signIn).then()
                .extract().response();
        response.then().statusCode(200)
                .body("token_type", equalTo("bearer"))
                .log().all();
        token = response.path("access_token");
        System.out.println(token);
    }

    public void checkConfirmLineUp() {
        response =
                request
                        .headers("Authorization", "bearer" + token,
                                "Content-Type", "application/json")
                        .formParam("formation","FOUR_FOUR_TWO")
                        .post(urlDev+confirmLineUp)
                        .body("ddd")
                        .then().extract().response();

    }


}
