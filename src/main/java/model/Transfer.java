package model;

import javax.ejb.TransactionAttribute;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_TABLE")
@NamedQueries({
        @NamedQuery(name = "Transfer.findAll",query = "select transfer from Transfer transfer"),
        @NamedQuery(name = "Transfer.findById", query ="select  transfer from  Transfer transfer " +
                "where transfer.id=:id"),
        @NamedQuery(name = "Transfer.findBySourceDeposit", query = "select transfer from  Transfer transfer" +
                " where transfer.sourceDeposit =: sourceDeposit"),
        @NamedQuery(name = "Transfer.findByDestinationDeposit", query = "select transfer from  Transfer transfer" +
                " where transfer.destinationDeposit =: destinationDeposit")
})
public class Transfer extends EntityModel {

    @Column(
            name = "C_SOURCE_DEPOSIT",
            nullable = false
    )

    private String sourceDeposit;

    @Column(
            name = "C_DESTINATION_DEPOSIT",
            nullable = false
    )
    private  String destinationDeposit;

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
