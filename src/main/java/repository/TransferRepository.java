package repository;

import model.Transfer;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
@LocalBean
public class TransferRepository extends GenericRepository<Transfer, Long> {

    public List<Transfer> findAll() {
        return entityManager
                .createNamedQuery(Transfer.FIND_ALL, Transfer.class)
                .getResultList();
    }

    public Optional<Transfer> findById(long id) {
        return entityManager
                .createNamedQuery(Transfer.FIND_BY_ID, Transfer.class)
                .getResultList()
                .stream().findFirst();
    }

    public List<Transfer> findBySourceDeposit(String sourceDeposit) {
        return entityManager
                .createNamedQuery(Transfer.FIND_BY_SOURCE_DEPOSIT, Transfer.class)
                .setParameter("sourceDeposit", sourceDeposit)
                .getResultList();
    }

    public List<Transfer> findByDestinationDeposit(String destinationDeposit) {
        return entityManager
                .createNamedQuery(Transfer.FIND_BY_DESTINATION_DEPOSIT, Transfer.class)
                .setParameter("destinationDeposit", destinationDeposit)
                .getResultList();
    }

}
