package br.com.fourbank.models;

public class CustomerModel {

    private String name;
    
    private String email;
    
    private String password;
    
    private String phone;
    
    private String dateBirth;

    private String cpf;
    
    public CustomerModel() {}

    public CustomerModel(String name, String email, String password, String phone, String dateOfBirth, String cpf) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dateBirth = dateOfBirth;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDateOfBirth() {
        return dateBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateBirth = dateOfBirth;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
