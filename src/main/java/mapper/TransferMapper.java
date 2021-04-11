package mapper;


import data.TransferDTO;
import model.Transfer;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
@LocalBean
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(value = LockType.READ)
public class TransferMapper {

     public TransferDTO toDTO(Transfer transfer) {
        TransferDTO transferDTO = null;
        if (transfer != null) {
            transferDTO = new TransferDTO();
            transferDTO.setBalance(transfer.getBalance());
            transferDTO.setDate(transfer.getDateTime());
            transferDTO.setDestinationDeposit(transfer.getDestinationDeposit());
            transferDTO.setSourceDeposit(transfer.getSourceDeposit());
        }
        return transferDTO;
    }


     public List<TransferDTO> toDTOList(List<Transfer> transfers) {
        List<TransferDTO> transferDTOList = new ArrayList<>();
        transfers.forEach(transfer -> {
            transferDTOList.add(toDTO(transfer));
        });

        return transferDTOList;
    }


     public Transfer toEntity(TransferDTO transferDTO){
        Transfer transfer = null;
        if(transferDTO != null){
            transfer = new Transfer();
            transfer.setBalance(transferDTO.getBalance());
            transfer.setDateTime(transferDTO.getDate());
            transfer.setDestinationDeposit(transferDTO.getDestinationDeposit());
            transfer.setSourceDeposit(transferDTO.getSourceDeposit());
        }
        return transfer;
    }

     public List<Transfer> toEntityList ( List <TransferDTO> transferDTOList){
        List<Transfer> transfers = new ArrayList<>();
        transferDTOList.forEach(transferDTO -> {
            transfers.add(toEntity(transferDTO));
        });
        return transfers;
    }


}
