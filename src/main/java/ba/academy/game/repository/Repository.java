package ba.academy.game.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class Repository<E, PK extends Serializable> implements PanacheRepositoryBase<E, PK> {

    private final Class<E> entityClass;

    protected Repository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    /** @return Entity manager instance */
    protected EntityManager entityManager() {
        return getEntityManager();
    }

    /** @return Criteria builder */
    protected CriteriaBuilder cb() {
        return entityManager().getCriteriaBuilder();
    }

    protected CriteriaQuery<E> criteriaQuery() {
        return cb().createQuery(entityClass());
    }


    protected Class<E> entityClass() {
        return this.entityClass;
    }


    public E findBy(PK pk) {
        return entityManager().find(entityClass(), pk);
    }


    /** Flushed the complete entity cache. */
    public void flush() {
        entityManager().flush();
    }

    /**
     * Default method for saving new entity object. Persist takes an entity instance, adds it to the
     * context and makes that instance managed (in future updates to the entity will be tracked).
     *
     * @param entity E
     */
    public void persist(E entity) {
        entityManager().persist(entity);
    }


    /**
     * removes the given entity, entity will be deleted at the end of transaction.
     *
     * @param entity To detach
     * it will throw an exception if .remove doesn't work
     */
    public void remove(E entity) {
        entityManager().remove(entity);
    }

    public List<E> findAllAsList() {
        CriteriaQuery<E> query = criteriaQuery();
        Root<E> table = query.from(entityClass);
        query.select(table);
        return entityManager()
                .createQuery(query).getResultList();
    }

    public void merge(E entity) {
        entityManager().merge(entity);
    }
}
