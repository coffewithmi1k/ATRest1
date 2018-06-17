package ApiControllers;

import static org.hamcrest.Matchers.*;

import io.qameta.allure.Step;
import io.restassured.RestAssured;

import java.io.File;

public class UserController extends ConfigControllers {

    String token = "";
    File LeicesterCityFormationJson = new File("src\\test\\Resources\\ConfirmLineUp.json");
    File manchesterCityFormationJson = new File("src\\test\\Resources\\ConfirmLineUpManchesterCity.json");

    @Step("Sign In")
    public String signIn(String email, String password) {
        response = RestAssured.given()
                .queryParam("grant_type", "password")
                .queryParam("username", email)
                .queryParam("platform", "ANDROID")
                .queryParam("password", password).when()
                .headers("Content-Type", "application/x-www-form-urlencoded", "Authorization", "Basic YmV0MTE6YmV0MTE=")
                .post(urlDev + signIn).then().log().all()
                .extract().response();
        response.then().statusCode(200)
                .body("token_type", equalTo("bearer"));
        token = response.path("access_token");
        return token;

    }

    @Step("Confirm Line Up without Match day")
    public void checkConfirmLineUpWithoutMatchDay(String myToken) {

        response = RestAssured.given()
                .queryParam("formation", "FOUR_FOUR_TWO")
                .headers("Authorization", "bearer " + myToken,
                        "Content-Type", "application/json")
                .body(LeicesterCityFormationJson).when().post(urlDev + confirmLineUp)
                .then().log().all().extract().response();
        response.then().statusCode(404).body("status", equalTo(404));
    }
    @Step("Set Line-up")
    public void checkConfirmLineUp(String myToken) {

        response = RestAssured.given()
                .queryParam("formation", "FOUR_FOUR_TWO")
                .headers("Authorization", "bearer " + myToken,
                        "Content-Type", "application/json")
                .body(LeicesterCityFormationJson).when().post(urlDev + confirmLineUp)
                .then().log().all().extract().response();

        if(response.statusCode()==409){
            response = RestAssured.given()
                    .queryParam("formation", "FOUR_FOUR_TWO")
                    .headers("Authorization", "bearer " + myToken,
                            "Content-Type", "application/json")
                    .body(manchesterCityFormationJson).when().post(urlDev + confirmLineUp)
                    .then().log().all().extract().response();
        }
        response.then().statusCode(200).body("betCount", equalTo(0));
    }

}
