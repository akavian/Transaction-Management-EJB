package repository;

import model.Customer;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PrePersist;
import java.util.List;
import java.util.Optional;

@Stateless
@LocalBean
public class CustomerRepository extends GenericRepository<Customer, Long> {

    public List<Customer> findAll(){
        return entityManager
                .createNamedQuery(Customer.FIND_ALL , Customer.class)
                .getResultList();
    }

    public Optional<Customer> findById (long id){
        return entityManager.createNamedQuery(Customer.FIND_BY_ID, Customer.class)
                .setParameter("id", id)
                .getResultList()
                .stream()
                .findFirst();
    }

    public Optional<Customer> findByCustomerNumber(String customerNumber){
        return entityManager
                .createNamedQuery(Customer.FIND_BY_CUSTOMER_NUMBER, Customer.class)
                .setParameter("customerNumber", customerNumber)
                .getResultList()
                .stream()
                .findFirst();
    }

}
