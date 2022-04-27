package FpsApi.repositories;

import FpsApi.models.entities.User;
import FpsApi.models.entities.UserPlayLog;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserPlayLogRepository extends AbstractRepository<UserPlayLog> {

    public UserPlayLogRepository() {
        super(UserPlayLog.class);
    }

    public List<UserPlayLog> aggregateByLocationMode(LocalDateTime dateTime){
        String hql = "SELECT new "+ UserPlayLog.class.getName() +"(log.gameMode,count(log.id)) FROM UserPlayLog log " +
                "INNER JOIN log.user u ";
        if(dateTime != null){
            hql += "WHERE :dateTime BETWEEN log.startDateTime AND log.endDateTime";
        }
        hql += " GROUP BY log.gameMode";
        TypedQuery<UserPlayLog> query = entityManager.createQuery(hql,UserPlayLog.class);
        query.setParameter("dateTime",dateTime);
        return query.getResultList();
    }
}
