package FpsApi.repositories;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public CriteriaQuery<T> getCriteriaQueryForEntity() {
        return getSession().getCriteriaBuilder().createQuery(tClass);
    }

    public T findByGuid(String guid) {
        return this.findByGuid(Collections.singleton(guid)).stream().findFirst().orElse(null);
    }

    public List<T> findByGuid(Collection<String> guids) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> query1 = getCriteriaQueryForEntity();
        Root<T> root = query1.from(tClass);
        Predicate expression;
        expression = root.get("guid").in(guids);

        query1.where(expression);
        return getSession().createQuery(query1).getResultStream().collect(Collectors.toList());
    }
}
