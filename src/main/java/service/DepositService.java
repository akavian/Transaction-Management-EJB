package service;


import data.DepositDTO;
import mapper.DepositMapper;
import model.Customer;
import model.Deposit;
import repository.DepositRepository;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.math.BigDecimal;

@Stateless
@LocalBean
public class DepositService {

    @EJB
    private DepositRepository depositRepository;

    @EJB
    private DepositMapper depositMapper;

    @EJB
    CustomerService customerService;

    public Deposit findByDepositNumber(String depositNumber) {
        return depositRepository.findByNumber(depositNumber).orElseThrow(EJBException::new);
    }

    public DepositDTO create(DepositDTO depositDTO) {
        Deposit deposit = depositMapper.toEntity(depositDTO);
        Customer customer = customerService.findByCustomerNumber(depositDTO.getCustomerNumber());
        deposit.setCustomer(customer);
        depositDTO.setCustomerNumber(customer.getCustomerNumber());

        depositRepository.persist(deposit);

        return depositDTO;

    }


    private void createDepositNumber(){


    }

    public void changeBalance(String sourceDepositNumber, String destinationDepositNumber, BigDecimal amount) {

        Deposit sourceDeposit = depositRepository
                .findByNumber(sourceDepositNumber)
                .orElseThrow(EJBException::new);

        Deposit destinationDeposit = depositRepository
                .findByNumber(destinationDepositNumber)
                .orElseThrow(EJBException::new);

        if(sourceDeposit.getBalance().compareTo(amount.abs()) < 1){
            throw new EJBException();
        } else {
         sourceDeposit.setBalance(sourceDeposit.getBalance().add(amount.negate()));
         destinationDeposit.setBalance(destinationDeposit.getBalance().add(amount));
         depositRepository.merge(sourceDeposit);
         depositRepository.merge(destinationDeposit);
        }
    }

}
