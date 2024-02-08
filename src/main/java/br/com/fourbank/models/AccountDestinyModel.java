package br.com.fourbank.models;

public class AccountDestinyModel {
    
    private String nameCustomer;
    
    private Long idAccount;

    private Long idCostumer;

    public AccountDestinyModel() {}

    public AccountDestinyModel(String name, Long idAccount, Long idCostumer) {
        this.nameCustomer = name;
        this.idAccount = idAccount;
        this.idCostumer = idCostumer;
    }

    public String getName() {
        return nameCustomer;
    }
    public void setName(String name) {
        this.nameCustomer = name;
    }
    public Long getIdAccount() {
        return idAccount;
    }
    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }
    public Long getIdCostumer() {
        return idCostumer;
    }
    public void setIdCostumer(Long idCostumer) {
        this.idCostumer = idCostumer;
    }
    
}
