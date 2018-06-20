package Examples;

import ApiControllers.ConfigControllers;
import ApiControllers.User;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


public class TestExampleBets extends ConfigControllers {

User usercontr = new User();



public void check100SigIn(){
    for(int i=1;i<170;i++){
        String email = "coffe"+i+"@mailinator.com";
        String password = "Qwe1156q@@";
        System.out.println("Here you can find token for coffe"+i+"@mailinator.com  "+usercontr.signIn(email,password));
    }
}






}
