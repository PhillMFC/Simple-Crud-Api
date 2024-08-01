package PhillMFC.simplecrud.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import PhillMFC.simplecrud.Service.GenerateAccountNumber;
import PhillMFC.simplecrud.Service.GenerateAgencyNumber;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;

public class Account extends User{

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @Column(name = "agency_number")
    private String agencyNumber;

    @Autowired
    private transient GenerateAccountNumber generateAccountNumber;

    @Autowired
    private transient GenerateAgencyNumber generateAgencyNumber;

    @PostConstruct
    public void setAccountNumber(){
        this.accountNumber = generateAccountNumber.generateAccountNumber();
    }

    @PostConstruct
    public void setAgencyNumber(){
        this.agencyNumber = generateAgencyNumber.generateAgencyNumber();
    }
}
