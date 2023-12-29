package br.com.fourbank.models;

import java.math.BigDecimal;

public class TransactionPixModel {
    
    private BigDecimal value;
    
    private String key;

    public TransactionPixModel() {}

    public TransactionPixModel(BigDecimal value, String key) {
        this.value = value;
        this.key = key;
    }

    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    
}
