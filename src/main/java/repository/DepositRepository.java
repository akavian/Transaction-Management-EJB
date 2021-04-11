package repository;

import model.Deposit;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
@LocalBean
public class DepositRepository extends GenericRepository<Deposit, Long> {

    public List<Deposit> findAll(){
        return entityManager
                .createNamedQuery("Deposit.findAll", Deposit.class)
                .getResultList();
    }

    public Optional<Deposit> findById(long id){
        return entityManager
                .createNamedQuery("Deposit.findById", Deposit.class)
                .setParameter("id",id)
                .getResultList()
                .stream()
                .findFirst();
    }

    public Optional<Deposit> findByNumber(String number){
        return entityManager
                .createNamedQuery("Deposit.findByNumber", Deposit.class)
                .getResultList()
                .stream().findFirst();
    }
}
