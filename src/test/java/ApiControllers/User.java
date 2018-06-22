package ApiControllers;

import static org.hamcrest.Matchers.*;

import io.qameta.allure.Step;
import io.restassured.RestAssured;

import java.io.File;
import java.util.Collection;

public class User extends ConfigControllers {

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
                .post(urlDev + signIn).then()
              .log().all()
                .extract().response();
       response.then().statusCode(200)
              .body("token_type", equalTo("bearer"));
       System.out.println(email+" is logged successfully");
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
                .then()
                .log().all()
                .extract().response();

        if(response.statusCode()==409){
            response = RestAssured.given()
                    .queryParam("formation", "FOUR_FOUR_TWO")
                    .headers("Authorization", "bearer " + myToken,
                            "Content-Type", "application/json")
                    .body(manchesterCityFormationJson).when().post(urlDev + confirmLineUp)
                    .then()
                    .log().all()
                    .extract().response();
            System.out.println("LineUp confirmed successfully");
        }
        response.then().statusCode(200).body("betCount", equalTo(0));
    }

    @Step("User Info")
    public void checkUserInfo(String token){
response = RestAssured.given()
        .headers("Authorization", "bearer " + token,
        "Content-Type", "application/json")
        .when().get(urlDev+userInfo)
        .then().log().all().extract().response();
response.then().assertThat()
        .body("id", notNullValue())
        .and().statusCode(200);
    }

    @Step("get Users activity")
    public void getUserActivity(String token){
        response = RestAssured.given()
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .when().post(urlDev+postUserActivity)
                .then().log().all().extract().response();
        response.then().assertThat()
                .statusCode(200);
    }

    @Step("Perform line-up clear")
    public void checkClearLineUp(String token){
        response = RestAssured.given()
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .when().post(urlDev+clearLineUp)
                .then().log().all().extract().response();
        response.then().assertThat()
                .statusCode(204);
    }

    @Step("Show friends list")
    public void checkFriendsList(String token){
        response = RestAssured.given()
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .when().get(urlDev+friendsList)
                .then().log().all().extract().response();
        response.then().assertThat()
                .statusCode(200)
                .and()
                .body("count", notNullValue());

    }
    @Step("Get latest lineUP")
    public void checkLatestLineUp(String token){
        response = RestAssured.given()
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .param("count","1")
                .when().get(urlDev+latestLineUp)
                .then().log().all().extract().response();
        response.then().assertThat()
                .statusCode(200);


    }
    @Step("Get current lineUP")
    public void checkCurrentLineUp(String token){
        response = RestAssured.given()
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .param("count","1")
                .when().get(urlDev+currentLineUp)
                .then().log().all().extract().response();
        response.then().assertThat()
                .statusCode(200);
    }
    @Step("Show user session")
    public void checkUserSession(String token){
        response = RestAssured.given()
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .when().get(urlDev+userSession)
                .then().log().all().extract().response();
        response.then().assertThat()
                .statusCode(200)
                .and()
                .body("userId", notNullValue());
    }
    @Step("Get User's wallet")
    public void checkUserWallet(String token){
        response = RestAssured.given()
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .when().get(urlDev+userWallet)
                .then().log().all().extract().response();
        response.then().assertThat()
                .statusCode(200)
                .and()
               .body("[0].currency", equalTo("BET_COIN"));
    }
    @Step("Get User's profile")
    public void checkUserProfile(String token, String userId){

        response = RestAssured
                .given()
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .param("userId",userId)
                .when().get(urlDev+userProfile)
                .then()
                .extract().response();
response.prettyPrint();
        response.then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", equalTo(userId));

    }


}
