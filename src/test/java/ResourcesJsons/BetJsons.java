package ResourcesJsons;

public class BetJsons {




    public String getCreateBetFriendJson(){
        String jSonBetFriend = "{\n" +
                " \"commonBetRequests\": [\n" +
                " \n" +
                "{\n" +
                "  \"currency\":\"BET_COIN\",\n" +
                "   \"bet\": 100,\n" +
                "   \"confirmBetActionType\": \"CREATE_HEAD_TO_HEAD\",\n" +
                "   \"opponentId\": \"5af4205563445900070f58d0\"\n" +
                " }\n" +
                "\n" +
                "]\n" +
                "}";
        return jSonBetFriend;

    }
    public String getJoinBetFriendJson(int betId){
        String jSonBetFriend = "{\n" +
                " \"commonBetRequests\": [\n" +
                "{\n" +
                "   \"currency\":\"BET_COIN\",\n" +
                "   \"bet\": 100,\n" +
                "   \"betId\": "+betId+",\n" +
                "   \"confirmBetActionType\": \"JOIN_TO_BET\"\n" +
                " }\n" +
                "]\n" +
                "}";
        return jSonBetFriend;

    }


}
