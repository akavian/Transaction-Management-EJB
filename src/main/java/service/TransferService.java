package service;

import data.TransferDTO;
import mapper.TransferMapper;
import model.Transfer;
import repository.TransferRepository;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TransferService {


    @EJB
    TransferRepository transferRepository;

    @EJB
    TransferMapper transferMapper;

    @EJB
    DepositService depositService;

    public TransferDTO transfer(TransferDTO transferDTO) {

        depositService.changeBalance(
                transferDTO.getSourceDeposit(),
                transferDTO.getDestinationDeposit(),
                transferDTO.getBalance()
        );
        Transfer transfer = transferMapper.toEntity(transferDTO);
        transferRepository.persist(transfer);
        return transferDTO;
    }
}

