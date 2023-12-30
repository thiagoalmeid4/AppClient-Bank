package br.com.fourbank.models;

/**
 *
 * @author thiag
 */
public class TransactionTedModel {
    
    private String agency;
    
    private String accountNumber;
    
    private Double value;
    
    public TransactionTedModel(){}

    public TransactionTedModel(String agency, String accountNumber, Double value) {
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.value = value;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    
    
    
}
