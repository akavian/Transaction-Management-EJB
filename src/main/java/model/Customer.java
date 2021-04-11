package model;

import javax.persistence.*;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Entity
@Table(name = "T_CUSTOMER")
@NamedQueries({
        @NamedQuery(name = Customer.FIND_ALL, query = "select customer from Customer customer"),
        @NamedQuery(name = Customer.FIND_BY_ID, query = "select  customer from  Customer customer " +
                "where customer.id=:id"),
        @NamedQuery(name = Customer.FIND_BY_CUSTOMER_NUMBER, query = "select customer from  Customer customer" +
                " where customer.customerNumber =: customerNumber")
})
public class Customer extends EntityModel {

    public static final String FIND_ALL = "Customer.findAll";

    public static final String FIND_BY_ID = "Customer.findById";

    public static final String FIND_BY_CUSTOMER_NUMBER = "Customer.findByCustomerNumber";

    @Column(
            name = "C_FIRST_NAME",
            nullable = false
    )

    private String firstName;

    @Column(
            name = "C_LAST_NAME",
            nullable = false
    )

    private String lastName;

    @Column(
            name = "C_NATIONAL_CODE",
            unique = true,
            nullable = false,
            length = 10
    )
    private String nationalCode;

    @Column(
            name = "C_CUSTOMER_NUMBER",
            nullable = false,
            unique = true,
            length = 20,
            updatable = false
    )
    private String customerNumber;

    @OneToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            orphanRemoval = true,
            mappedBy = "customer"
    )
    private List<Deposit> deposits;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    private void addDeposit(Deposit deposit) {
        if (deposits == null) {
            deposits = new ArrayList<>();
        }
        deposits.add(deposit);
    }

    @PrePersist
    private void generateCustomerNumber() {
        LocalDateTime localDateTime = LocalDateTime.now();
        SecureRandom secureRandom = new SecureRandom();
        IntStream ints = secureRandom.ints(16, 0, 10);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(localDateTime.getYear());
        ints.forEach(stringBuilder::append);
        this.customerNumber = stringBuilder.toString();
    }
}
