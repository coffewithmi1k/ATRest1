package Examples;

import ApiControllers.ConfigControllers;
import ApiControllers.User;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


public class TestExampleBets extends ConfigControllers {

User usercontr = new User();

 /*   JsonObject joinBetJson = Json.createObjectBuilder()
            .add("commonBetRequests", Json.createArrayBuilder()
                    .add(Json.createObjectBuilder()
                            .add("currency", "BET_COIN")
                            .add("bet", "100")
                            .add("betId", "11573")
                            .add("confirmBetActionType", "JOIN_TO_BET"))).build();
*/





/*@Story("New Flow")
    @Test(description = "myyy")
    public void checkRandomFlow(){
    String token = userManagement.signIn("coffe22@mailinator.com","Qwe1156q@@");
    userManagement.checkConfirmLineUp(token);

}*/

public void check100SigIn(){
    for(int i=1;i<170;i++){
        String email = "coffe"+i+"@mailinator.com";
        String password = "Qwe1156q@@";
        System.out.println("Here you can find token for coffe"+i+"@mailinator.com  "+usercontr.signIn(email,password));
    }
}




}
