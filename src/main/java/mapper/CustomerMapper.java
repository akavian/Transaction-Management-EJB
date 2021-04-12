package mapper;


import data.CustomerDTO;
import model.Customer;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;


@LocalBean
@Singleton
@Startup
@DependsOn("DepositMapper")
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.READ)
public class CustomerMapper {

    @EJB
    private DepositMapper depositMapper;


    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        if (customer != null) {
            customerDTO.setCustomerNumber(customer.getCustomerNumber());
            customerDTO.setFirstName(customer.getFirstName());
            customerDTO.setLastName(customer.getLastName());
            customerDTO.setNationalCode(customer.getNationalCode());
            customerDTO.setDepositDTOList(depositMapper.toDepositDTOList(customer.getDeposits()));
        }
        return customerDTO;
    }


    public List<CustomerDTO> toDTOList(List<Customer> customers) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        customers.forEach(customer -> {
            customerDTOList.add(toDTO(customer));
        });
        return customerDTOList;
    }


    public Customer toEntity(CustomerDTO customerDTO, Customer customer) {

        if (customerDTO != null) {
            if (customer == null) {
                customer = new Customer();
            }

            customer.setCustomerNumber(customerDTO.getCustomerNumber());
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setNationalCode(customerDTO.getNationalCode());
        }
        return customer;
    }


    public List<Customer> toEntityList(List<CustomerDTO> customerDTOList) {
        List<Customer> customers = new ArrayList<>();

        customerDTOList.forEach(customerDTO -> {
            customers.add(toEntity(customerDTO, new Customer()));
        });
        return customers;
    }

}
