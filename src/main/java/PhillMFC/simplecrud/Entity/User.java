package PhillMFC.simplecrud.Entity;

import java.util.Random;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "address")
    private String address;

    @Column(name = "account_number", unique = true)
    private String accountNumber = generateAccountNumber();

    @Column(name = "agency_number", unique = true)
    private String agencyNumber = generateAgencyNumber();

    private String generateAccountNumber(){

        Random digit = new Random();
        String accountNumber = "";

        for(int i = 0; i<4; i++){
            
            this.accountNumber += Integer.toString(digit.nextInt(10));
        }

        return accountNumber;
    }

    private String generateAgencyNumber(){

        Random digit = new Random();
        String agencyNumber = "";

        for(int i = 0; i<10; i++){
            if(i==8)
            this.accountNumber += "-";
            
            this.accountNumber += Integer.toString(digit.nextInt(10));
        }

        return agencyNumber;
    }
}
