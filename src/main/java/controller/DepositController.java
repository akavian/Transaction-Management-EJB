package controller;

import data.DepositDTO;
import model.Deposit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


@Stateless
@LocalBean
@WebService
public class DepositController {

    @WebMethod
    public List<DepositDTO> getCustomerDepositList(String customerNumber){
        return null;
    }

    @WebMethod(operationName = "addDeposit")
    public DepositDTO x(DepositDTO o){
         return new DepositDTO();
    }

    @WebMethod
    public void deleteDeposit(String customerNumber, String depositNumber){

    }


}
