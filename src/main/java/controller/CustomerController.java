package controller;

import data.CustomerDTO;
import service.CustomerService;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@LocalBean
@WebService(
        name = "CustomerService",
        portName = "CustomerPort",
        targetNamespace = "training.tosan.com/customer")
public class CustomerController {

    @EJB
    CustomerService customerService;


    @WebMethod(operationName = "create")
    public CustomerDTO create(CustomerDTO customerDTO){
        return customerService.createCustomer(customerDTO);
    }

    @WebMethod(operationName = "update")
    public CustomerDTO update(CustomerDTO customerDTO){
        return customerService.updateCustomer(customerDTO);
    }


    @WebMethod(operationName = "findByCustomerNumber")
    public CustomerDTO findByCustomerNumber(String customerNumber){
        return customerService.findByCustomerNumber(customerNumber);
    }

}
