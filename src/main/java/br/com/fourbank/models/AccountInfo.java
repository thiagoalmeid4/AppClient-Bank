package br.com.fourbank.models;

import java.math.BigDecimal;

public class AccountInfo {

    private String accountNumber;
    
    private String accountAgency;
    
    private BigDecimal value;

    public AccountInfo(){}

    public AccountInfo(String accountNumber, String accountAgency, BigDecimal value) {
        this.accountNumber = accountNumber;
        this.accountAgency = accountAgency;
        this.value = value;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountAgency() {
        return accountAgency;
    }
    public void setAccountAgency(String accountAgency) {
        this.accountAgency = accountAgency;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
