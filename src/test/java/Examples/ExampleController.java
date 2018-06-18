package Examples;

import ApiControllers.ConfigControllers;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import javax.json.JsonObject;
import static org.hamcrest.Matchers.equalTo;

public class ExampleController extends ConfigControllers {



    @Step("Create Bet Random")
    public int manageBets(String token, JsonObject bodyJson) {
        int betId;
        response = RestAssured.given()
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .body(bodyJson).when().post(urlDev + manageBets)
                .then().log().all().extract().response();
        response.then().statusCode(201).body("commonBetRequests.confirmBetActionType[0]", equalTo("CREATE_RANDOM"));

        betId = response.path("commonBetRequests.betId[0]");
        System.out.println(betId);
        return betId;
    }


}
