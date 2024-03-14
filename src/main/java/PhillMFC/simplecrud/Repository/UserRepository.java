package PhillMFC.simplecrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import PhillMFC.simplecrud.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
