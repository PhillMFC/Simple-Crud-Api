package PhillMFC.simplecrud.Service;

import java.util.Random;

public class GenerateAgencyNumber {
     public String generateAgencyNumber(){

        Random digit = new Random();
        String agencyNumber = "";

        for(int i = 0; i<10; i++){
            if(i==8)
            agencyNumber += "-";
            
            agencyNumber += Integer.toString(digit.nextInt(10));
        }

        return agencyNumber;
    }
}
