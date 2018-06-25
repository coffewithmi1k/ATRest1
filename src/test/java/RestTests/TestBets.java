package RestTests;

import ApiControllers.BetController;
import ApiControllers.User;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Bet Scenarios")
public class TestBets {

    User userCon = new User();
    BetController betCon = new BetController();

    String email1 = "coffe90@mailinator.com";
    String email2 = "coffe91@mailinator.com";
    String email136 = "coffe136@mailinator.com";
    String email137 = "coffe137@mailinator.com";
    String email138 = "coffe138@mailinator.com";
    String email139 = "coffe139@mailinator.com";
    String email140 = "coffe140@mailinator.com";
    String email141 = "coffe141@mailinator.com";

    String password = "Qwe1156q@@";
    String randomGroupName = "MilkShake" + ((int) (Math.random() * 1000 + 1));
    int betId;
    int idRandomBet;


    public String getCreateBetFriendJson() {
        String jSonBetFriend = "{\n" +
                " \"commonBetRequests\": [\n" +
                " \n" +
                "{\n" +
                "  \"currency\":\"BET_COIN\",\n" +
                "   \"bet\": 100,\n" +
                "   \"confirmBetActionType\": \"CREATE_HEAD_TO_HEAD\",\n" +
                // friend ID coffe99@mailinator.com
                "   \"opponentId\": \"5ae1741b6344590007cca25b\"\n" +
                " }\n" +
                "\n" +
                "]\n" +
                "}";

        return jSonBetFriend;
    }

    public String getCreatebetRandomJson() {
        String json = "{\n" +
                " \"commonBetRequests\": [\n" +
                " \n" +
                "{\n" +
                "  \"currency\":\"BET_COIN\",\n" +
                "   \"bet\": 50,\n" +
                "   \"confirmBetActionType\": \"CREATE_RANDOM\"\n" +
                "   \n" +
                " }\n" +
                "\n" +
                "]\n" +
                "}";
        return json;
    }

    public String getCreateGroupPublicJson() {
        String json = "{\n" +
                " \"commonBetRequests\": [\n" +
                " \n" +
                " {\n" +
                "   \"bet\": 100,\n" +
                "   \"currency\": \"BET_COIN\",\n" +
                "   \"confirmBetActionType\": \"CREATE_GROUP\",\n" +
                "   \"groupBet\": {\n" +
                "     \"groupName\": \"" + randomGroupName + "\",\n" +
                "     \"isPrivate\": false,\n" +
                "     \"maxPeople\": 10,\n" +
                "     \"opponentIds\": [\n" +
                "      \n" +
                "     ],\n" +
                "     \"payOutMethod\": \"SEPARATED_POT_100_0_0\"\n" +
                "   }\n" +
                " }\n" +
                "\n" +
                "]\n" +
                "}";
        return json;
    }

    public String getCreatePrivateGroupJson() {
        String json = "{\n" +
                "  \"commonBetRequests\": [\n" +
                "\n" +
                "    {\n" +
                "      \"bet\": 50,\n" +
                "      \"currency\": \"BET_COIN\",\n" +
                "      \"confirmBetActionType\": \"CREATE_GROUP\",\n" +
                "      \"groupBet\": {\n" +
                "        \"groupName\": \"SuperGroup44\",\n" +
                "        \"isPrivate\": true,\n" +
                "        \"maxPeople\": 2,\n" +
                "        \"opponentIds\": [\n" +
                // coffe140@mailinator.com , coffe141@mailinator.com
                "          \"5b1790056344590007d00a85\",\"5b17975a6344590007d00a91\"\n" +
                "        ],\n" +
                "        \"payOutMethod\": \"SEPARATED_POT_100_0_0\"\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "  ]\n" +
                "}";
        return json;
    }

    public String getJoinBetJson(int betId) {
        String jSonBetFriend = "{\n" +
                " \"commonBetRequests\": [\n" +
                "{\n" +
                "   \"currency\":\"BET_COIN\",\n" +
                "   \"bet\": 100,\n" +
                "   \"betId\": " + betId + ",\n" +
                "   \"confirmBetActionType\": \"JOIN_TO_BET\"\n" +
                " }\n" +
                "]\n" +
                "}";
        return jSonBetFriend;

    }


    @Story("Bet Flow checks")
    @Test(description = "Create and join to Random bet")
    public void checkbetRandomCreationJoin() {
        String token1 = userCon.signIn(email1, password);
        String token2 = userCon.signIn(email2, password);
        userCon.checkConfirmLineUp(token1);
        userCon.checkConfirmLineUp(token2);
        idRandomBet = betCon.createBetRandom(token1);
        betCon.joinRandomBet(token2, idRandomBet);
    }


    @Test(description = "Bet friend create and join")
    @Story("Bet Flow checks")
    public void checkbetFriendBet() {
        String token1 = userCon.signIn("coffe100@mailinator.com", password);
        String token2 = userCon.signIn("coffe99@mailinator.com", password);

        userCon.checkConfirmLineUp(token1);
        userCon.checkConfirmLineUp(token2);
        betId = betCon.createBet(token1, getCreateBetFriendJson());
        betCon.joinBet(token2, getJoinBetJson(betId));


    }

    @Test(description = "Create and join to Private group bet")
    @Story("Bet Flow checks")
    public void checkGroupPrivateBet() {
        //Login
        String token1 = userCon.signIn(email136, password);
        userCon.checkConfirmLineUp(token1);
        String token2 = userCon.signIn(email140, password);
        userCon.checkConfirmLineUp(token2);
        String token3 = userCon.signIn(email141, password);
        userCon.checkConfirmLineUp(token3);
        //Create bet
        betId = betCon.createBet(token1, getCreateGroupPublicJson());
        //Join
        betCon.joinBet(token2, getJoinBetJson(betId));
        betCon.joinBet(token3, getJoinBetJson(betId));


    }

    @Test(description = "Create and join to public group bet")
    @Story("Bet Flow checks")
    public void checkGroupPublicBet() {
        String token1 = userCon.signIn(email136, password);
        userCon.checkConfirmLineUp(token1);
        String token2 = userCon.signIn(email140, password);
        userCon.checkConfirmLineUp(token2);
        String token3 = userCon.signIn(email141, password);
        userCon.checkConfirmLineUp(token3);

        betId = betCon.createBet(token1, getCreatePrivateGroupJson());

        betCon.joinBet(token2, getJoinBetJson(betId));
        betCon.joinBet(token3, getJoinBetJson(betId));


    }

    @Test(description = "Check Create public group bet and fill group with all members")
    @Story("Bet Flow checks")
    public void checkFullGroupPublic() {
        //Host is logged In
        String token1 = userCon.signIn(email1, password);
        //Host set lineUp
        userCon.checkConfirmLineUp(token1);

        for (int i = 0; i < 10; i++) {
            betId = betCon.createBet(token1, getCreateGroupPublicJson());

            for (int k = 0; k < 10; k++) {
                String token = userCon.signIn("coffe13" + k + "@mailinator.com", password);
                userCon.checkConfirmLineUp(token);
                betCon.joinBet(token, getJoinBetJson(betId));
            }
        }
    }


}
