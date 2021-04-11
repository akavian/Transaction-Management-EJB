package data;

import java.util.List;

public class CustomerDTO {

    private String firstName;

    private String lastName;

    private String nationalCode;

    private String customerNumber;

    private List<DepositDTO> depositDTOList;

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

    public List<DepositDTO> getDepositDTOList() {
        return depositDTOList;
    }

    public void setDepositDTOList(List<DepositDTO> depositDTOList) {
        this.depositDTOList = depositDTOList;
    }
}
