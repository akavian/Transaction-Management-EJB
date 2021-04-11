package service;


import data.CustomerDTO;
import mapper.CustomerMapper;
import model.Customer;
import repository.CustomerRepository;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Stateless
@LocalBean
public class CustomerService {

    @EJB
    CustomerRepository customerRepository;

    @EJB
    CustomerMapper customerMapper;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO, new Customer());
        customer.setCustomerNumber(generateCustomerNumber());
        customerRepository.persist(customer);
        customerDTO.setCustomerNumber(customer.getCustomerNumber());
        return customerDTO;
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository
                .findByCustomerNumber(customerDTO.getCustomerNumber())
                .orElseThrow(EJBException::new);
        customer = customerMapper.toEntity(customerDTO, customer);
        customerRepository.merge(customer);
        return customerDTO;
    }


    public Customer findByCustomerNumber(String customerNumber) {
        return customerRepository
                .findByCustomerNumber(customerNumber)
                .orElseThrow(EJBException::new);
    }


    private String generateCustomerNumber() {
        LocalDateTime localDateTime = LocalDateTime.now();
        SecureRandom secureRandom = new SecureRandom();
        IntStream ints = secureRandom.ints(16, 0, 10);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(localDateTime.getYear());
        ints.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

}
