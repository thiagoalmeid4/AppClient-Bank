package br.com.fourbank.models;

/**
 *
 * @author thiag
 */
public class PixKeysModel {
    
    private String pixKey;
    
    private String typePixKey;
    
    public PixKeysModel (){}

    public PixKeysModel(String pixKey, String typePixKey) {
        this.pixKey = pixKey;
        this.typePixKey = typePixKey;
    }
    
    public String getPixKey() {
        return pixKey;
    }

    public void setPixKey(String pixKey) {
        this.pixKey = pixKey;
    }

    public String getTypePixKey() {
        return typePixKey;
    }

    public void setTypePixKey(String typePixKey) {
        this.typePixKey = typePixKey;
    }
    
    
}
