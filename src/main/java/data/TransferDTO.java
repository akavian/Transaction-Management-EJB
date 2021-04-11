package data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferDTO {

    private String sourceDeposit;

    private String destinationDeposit;

    private BigDecimal balance;

    private LocalDateTime date;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
