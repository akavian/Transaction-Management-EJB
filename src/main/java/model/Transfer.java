package model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_TRANSFER")
@NamedQueries({
        @NamedQuery(name = Transfer.FIND_ALL, query = "select transfer from Transfer transfer"),
        @NamedQuery(name = Transfer.FIND_BY_ID, query = "select  transfer from  Transfer transfer " +
                "where transfer.id=:id"),
        @NamedQuery(name = Transfer.FIND_BY_SOURCE_DEPOSIT, query = "select transfer from  Transfer transfer" +
                " where transfer.sourceDeposit =: sourceDeposit"),
        @NamedQuery(name = Transfer.FIND_BY_DESTINATION_DEPOSIT, query = "select transfer from  Transfer transfer" +
                " where transfer.destinationDeposit =: destinationDeposit")
})
public class Transfer extends EntityModel {

    public static final String FIND_ALL = "Transfer.findAll";
    public static final String FIND_BY_ID = "Transfer.findById";
    public static final String FIND_BY_SOURCE_DEPOSIT = "Transfer.findBySourceDeposit";
    public static final String FIND_BY_DESTINATION_DEPOSIT = "Transfer.findByDestinationDeposit";


    @Column(
            name = "C_SOURCE_DEPOSIT",
            nullable = false
    )

    private String sourceDeposit;

    @Column(
            name = "C_DESTINATION_DEPOSIT",
            nullable = false
    )
    private String destinationDeposit;

    @Column(
            name = "C_BALANCE",
            nullable = false
    )
    @Min(10000)
    private BigDecimal balance;

    @Column(name = "C_DATE_TIME", nullable = false)
    private LocalDateTime dateTime;

    public String getSourceDeposit() {
        return sourceDeposit;
    }

    public void setSourceDeposit(String sourceDeposit) {
        this.sourceDeposit = sourceDeposit;
    }

    public String getDestinationDeposit() {
        return destinationDeposit;
    }

    public void setDestinationDeposit(String destinationDeposit) {
        this.destinationDeposit = destinationDeposit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
