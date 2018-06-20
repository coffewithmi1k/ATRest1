package ApiControllers;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import javax.json.Json;
import javax.json.JsonObject;

import static org.hamcrest.Matchers.*;

import java.io.File;

public class BetController extends ConfigControllers {

    File bodyCreateRandomBetJson = new File("src\\test\\Resources\\CreateRandomBet50.json");
    File bodyJoinBetJson = new File("src\\test\\Resources\\JoinBet.json");




    @Step("Create Bet Random")
    public int createBetRandom(String token) {
        int betId;
        response = RestAssured.given()
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .body(bodyCreateRandomBetJson).when().post(urlDev + manageBets)
                .then().log().all().extract().response();
        response.then().statusCode(201).body("commonBetRequests.confirmBetActionType[0]", equalTo("CREATE_RANDOM"));

        betId = response.path("commonBetRequests.betId[0]");
        System.out.println(betId);
        return betId;
    }


    @Step("Join to Random bet")
    public void joinRandomBet(String token, int betId) {
        response = RestAssured.given()
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .body("{\n" +
                        " \"commonBetRequests\": [\n" +
                        "{\n" +
                        "   \"currency\":\"BET_COIN\",\n" +
                        "   \"bet\": 50,\n" +
                        "   \"betId\":" + betId + ",\n" +
                        "   \"confirmBetActionType\": \"JOIN_TO_BET\"\n" +
                        " }\n" +
                        "]\n" +
                        "}")
                .when().post(urlDev + manageBets).then()
                .log().all()
                .extract().response();
        response.then().statusCode(201).body("commonBetRequests.betId[0]", equalTo(betId));


    }
    @Step("Create bet")
    public String CreateBet(String token,String bodyJson){
        String bedId="";


        return bedId;
    }
    @Step("Join bet")
    public void JoinBet(String token, String bodyJson){




    }


}
