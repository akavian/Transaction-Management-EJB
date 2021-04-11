package model;


import enums.DepositStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "T_DEPOSIT")

@NamedQueries({
        @NamedQuery(name = Deposit.FIND_ALL, query = "select deposit from Deposit deposit"),
        @NamedQuery(name = Deposit.FIND_BY_ID, query = "select  deposit from  Deposit deposit " +
                "where deposit.id=:id"),
        @NamedQuery(name = Deposit.FIND_BY_NUMBER, query = "select deposit from  Deposit deposit" +
                " where deposit.number =: number")
})
public class Deposit extends EntityModel {

    public static final String FIND_ALL = "Deposit.findAll";
    public static final String FIND_BY_ID = "Deposit.findById";
    public static final String FIND_BY_NUMBER = "Deposit.findByNumber";

    @Column(
            name = "C_NUMBER",
            nullable = false,
            unique = true
    )
    private String number;

    @Column(name = "C_STATUS")
    @Enumerated(EnumType.STRING)
    private DepositStatus status;

    @Column(
            name = "C_OPENING_TIME",
            nullable = false,
            updatable = false
    )
    private LocalDateTime openingTime;

    @Column(
            name = "C_BALANCE",
            nullable = false
    )
    private BigDecimal balance = new BigDecimal(0);

    @ManyToOne(
            optional = false,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST}
    )
    @JoinColumn(
            name = "FK_CUSTOMER_ID",
            referencedColumnName = "C_ID"
    )
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public DepositStatus getStatus() {
        return status;
    }

    public void setStatus(DepositStatus status) {
        this.status = status;
    }

    public LocalDateTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalDateTime openingTime) {
        this.openingTime = openingTime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
