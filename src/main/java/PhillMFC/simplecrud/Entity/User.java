package PhillMFC.simplecrud.Entity;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;

import PhillMFC.simplecrud.Service.GenerateAccountNumber;
import PhillMFC.simplecrud.Service.GenerateAgencyNumber;
import jakarta.annotation.PostConstruct;
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

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "address")
    private String address;
}
