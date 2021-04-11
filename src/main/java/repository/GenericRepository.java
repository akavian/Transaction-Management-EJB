package repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Optional;

public abstract class GenericRepository <T extends Serializable, ID extends Serializable>{

    @PersistenceContext
    EntityManager entityManager;

    public void persist(T t){
        entityManager.persist(t);
    }

    public T merge(T t){
        return entityManager.merge(t);
    }

    public void delete(T t){
        entityManager.remove(t);
    }

    public Optional<T> find(Class<T> clazz, T t){
       return Optional.ofNullable(entityManager.find(clazz, t));
    }

}
