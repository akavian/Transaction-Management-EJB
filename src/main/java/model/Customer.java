package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_CUSTOMER")
@NamedQueries({
        @NamedQuery(name = "Customer.findAll",query = "select customer from Customer customer"),
        @NamedQuery(name = "Customer.findById", query ="select  customer from  Customer customer " +
                "where customer.id=:id"),
        @NamedQuery(name = "Customer.findByCustomerNumber", query = "select customer from  Customer customer" +
                " where customer.customerNumber =: customerNumber")
})
public class Customer extends EntityModel{

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
    private String customerNumber ;

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

    private void addDeposit(Deposit deposit){
        if(deposits == null){
            deposits =  new ArrayList<>();
        }
        deposits.add(deposit);
    }
}
