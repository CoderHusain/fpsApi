package FpsApi.repositories;

import FpsApi.models.entities.User;
import FpsApi.models.entities.UserPlayLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;

@Repository
public class UserRepository extends AbstractRepository<User> {

    public UserRepository() {
        super(User.class);
    }
}
