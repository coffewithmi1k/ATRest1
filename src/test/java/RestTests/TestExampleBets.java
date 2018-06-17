package RestTests;

import ApiControllers.ConfigControllers;
import ApiControllers.ExampleController;
import ApiControllers.UserController;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import javax.json.Json;
import javax.json.JsonObject;


public class TestExampleBets extends ConfigControllers {
   ExampleController exampleManagement = new ExampleController();
    UserController userManagement = new UserController();


 /*   JsonObject joinBetJson = Json.createObjectBuilder()
            .add("commonBetRequests", Json.createArrayBuilder()
                    .add(Json.createObjectBuilder()
                            .add("currency", "BET_COIN")
                            .add("bet", "100")
                            .add("betId", "11573")
                            .add("confirmBetActionType", "JOIN_TO_BET"))).build();
*/

        JsonObject createRandomBetJson = Json.createObjectBuilder()
                .add("commonBetRequests", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("currency", "BET_COIN")
                                .add("bet", "100")
                                .add("confirmBetActionType", "CREATE_RANDOM"))).build();



@Story("New Flow")
    @Test
    public void checkRandomFlow(){
    String token = userManagement.signIn("coffe22@mailinator.com","Qwe1156q@@");
    userManagement.checkConfirmLineUp(token);
    exampleManagement.manageBets(token,createRandomBetJson);
   System.out.println("Hi"+createRandomBetJson.toString());
}






}
