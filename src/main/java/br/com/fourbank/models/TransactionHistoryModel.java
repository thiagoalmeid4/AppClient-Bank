package br.com.fourbank.models;

import java.math.BigDecimal;

public class TransactionHistoryModel {

    private String flag;
    
    private String dateTransaction;
    
    private BigDecimal value;
    
    private String originDestiny;
    
    private String typeTransaction;

    public TransactionHistoryModel() {}

    public TransactionHistoryModel(String flag, String dateTransaction, BigDecimal value, String originDestiny) {
        this.flag = flag;
        this.dateTransaction = dateTransaction;
        this.value = value;
        this.originDestiny = originDestiny;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getOriginDestiny() {
        return originDestiny;
    }

    public void setOriginDestiny(String originDestiny) {
        this.originDestiny = originDestiny;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

}
