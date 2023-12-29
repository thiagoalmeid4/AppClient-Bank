package br.com.fourbank.models;

import java.math.BigDecimal;

public class TransactionHistoryModel {

    private long idTransaction;

    private String customerNameOrigin;

    private String customerNameDestiny;

    private String dateTransaction;

    private String typeTransaction;

    private BigDecimal value;

    public TransactionHistoryModel() {}

    public TransactionHistoryModel(long idTransaction, String customerNameOrigin, String customerNameDestiny, String dateTransaction, String typeTransaction, BigDecimal value) {
        this.idTransaction = idTransaction;
        this.customerNameOrigin = customerNameOrigin;
        this.customerNameDestiny = customerNameDestiny;
        this.dateTransaction = dateTransaction;
        this.typeTransaction = typeTransaction;
        this.value = value;
    }

    public long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getCustomerNameOrigin() {
        return customerNameOrigin;
    }

    public void setCustomerNameOrigin(String customerNameOrigin) {
        this.customerNameOrigin = customerNameOrigin;
    }

    public String getCustomerNameDestiny() {
        return customerNameDestiny;
    }

    public void setCustomerNameDestiny(String customerNameDestiny) {
        this.customerNameDestiny = customerNameDestiny;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
