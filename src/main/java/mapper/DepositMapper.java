package mapper;

import data.DepositDTO;
import enums.DepositStatus;
import model.Deposit;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
@LocalBean
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(value = LockType.READ)
public class DepositMapper {

    public DepositDTO toDTO(Deposit deposit) {
        DepositDTO depositDTO = null;
        if (deposit != null) {
            depositDTO = new DepositDTO();
            depositDTO.setBalance(deposit.getBalance());
            depositDTO.setLocalDateTime(deposit.getOpeningTime());
            depositDTO.setStatus(deposit.getStatus().toString());
            depositDTO.setNumber(deposit.getNumber());
            depositDTO.setCustomerNumber(deposit.getCustomer().getCustomerNumber());

        }
        return depositDTO;
    }

    public List<DepositDTO> toDepositDTOList(List<Deposit> deposits) {
        List<DepositDTO> depositDTOList = new ArrayList<>();

        deposits.forEach(deposit -> {
            depositDTOList.add(toDTO(deposit));
        });
        return depositDTOList;
    }

    public Deposit toEntity(DepositDTO depositDTO, Deposit deposit) {
        if (deposit == null) {
            deposit = new Deposit();
        }
        if (depositDTO != null) {
            deposit = new Deposit();
            deposit.setBalance(depositDTO.getBalance());
            deposit.setNumber(depositDTO.getNumber());
            deposit.setOpeningTime(depositDTO.getLocalDateTime());
            deposit.setStatus(DepositStatus.valueOf(depositDTO.getStatus()));

        }
        return deposit;
    }

}
