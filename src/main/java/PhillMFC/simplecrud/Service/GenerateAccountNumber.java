package PhillMFC.simplecrud.Service;

import java.util.Random;

public class GenerateAccountNumber {
    
    public String generateAccountNumber(){

        Random digit = new Random();
        String accountNumber = "";

        for(int i = 0; i<4; i++){
            
            accountNumber += Integer.toString(digit.nextInt(10));
        }

        return accountNumber;
    }
}
