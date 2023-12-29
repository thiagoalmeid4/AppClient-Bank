package br.com.fourbank.models;

import java.math.BigDecimal;

public class TransactionPixModel {
    
    private Double value;
    
    private String pixKey;

    public TransactionPixModel() {}

    public TransactionPixModel(Double value, String key) {
        this.value = value;
        this.pixKey = key;
    }

    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public String getKey() {
        return pixKey;
    }
    public void setKey(String key) {
        this.pixKey = key;
    }
    
}
