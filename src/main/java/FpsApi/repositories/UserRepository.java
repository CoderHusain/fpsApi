package FpsApi.repositories;

import FpsApi.models.entities.User;
import FpsApi.models.entities.UserPlayLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;

@Repository
public class UserRepository extends AbstractRepository<User> {

    @PersistenceContext
    EntityManager entityManager;

    public UserRepository(Class<User> type) {
        super(type);
    }

    public UserPlayLog aggregateByLocationMode(LocalDateTime dateTime){
        String hql = "SELECT u.gameMode,max(count(u.totalPlayers)) FROM UserPlayLog log " +
                "INNER JOIN log.user u ";
        if(dateTime != null){
            hql = ":dateTime BETWEEN log.startDateTime AND log.endDateTime";
        }
        hql += " GROUP BY u.gameMode";
        TypedQuery<UserPlayLog> query = entityManager.createQuery(hql,UserPlayLog.class);
        query.setParameter("dateTime",dateTime);
        return query.getSingleResult();
    }
}
