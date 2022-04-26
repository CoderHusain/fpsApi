package FpsApi.repositories;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class AbstractRepository<T> {

    @PersistenceContext
    EntityManager entityManager;

    private final Class<T> tClass;

    public AbstractRepository(Class<T> type) {
        tClass = type;
    }
    public Session getSession() {
        return entityManager.unwrap(Session.class);

    }

    public void save(T entity) throws Exception {
        getSession().saveOrUpdate(entity);
    }

    public void save(Collection<T> entities) throws Exception {
        for (T entity : entities) {
            getSession().saveOrUpdate(entity);
        }
    }

    public void update(Collection<T> entities) throws Exception {
        for (T entity : entities) {
            getSession().update(entity);
        }
    }

    public void update(T entity) throws Exception {
        getSession().update(entity);
    }
}
