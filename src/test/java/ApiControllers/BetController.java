package ApiControllers;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class BetController extends ConfigControllers {

File bodyCreateRandomBetJson = new File("E:\\IntelijIdea\\ATRest1\\src\\test\\Resources\\CreateRandomBet50.json");
File bodyJoinBetJson = new File("E:\\IntelijIdea\\ATRest1\\src\\test\\Resources\\JoinBet.json");


    @Step("Create Bet Random")
        public int createBetRandom(String token){
        int betId;
        response = RestAssured.given()
                .queryParam("formation", "FOUR_FOUR_TWO")
                .headers("Authorization", "bearer " + token,
                        "Content-Type", "application/json")
                .body(bodyCreateRandomBetJson).when().post(urlDev + manageBets)
                .then().log().all().extract().response();
        response.then().statusCode(201).body("commonBetRequests.confirmBetActionType",equalTo("CREATE_RANDOM"));
        betId = response.path("commonBetRequests.betId");
        System.out.println(betId);
        return betId;
    }


    @Step("Join to Random bet")
    public void joinRandomBet(String token,String betId){

    }

}
