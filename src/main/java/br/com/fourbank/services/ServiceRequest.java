package br.com.fourbank.services;

import java.util.HashMap;
import java.util.Map;

import br.com.fourbank.models.AccountDestinyModel;
import br.com.fourbank.models.AccountInfo;
import br.com.fourbank.models.AuthModel;
import br.com.fourbank.models.CustomerModel;
import br.com.fourbank.models.ErrModel;
import br.com.fourbank.models.TokenModel;
import br.com.fourbank.models.TransactionHistoryModel;
import br.com.fourbank.models.TransactionPixModel;
import br.com.fourbank.models.TransactionResponseModel;
import br.com.fourbank.request.ApiRequest;
import br.com.fourbank.utils.ConvertJson;
import cache.io.Cache;

public class ServiceRequest {

    private final ApiRequest appRequest = new ApiRequest();

    public String saveCustomer(CustomerModel customer) {
        var response = appRequest.saveCustomer(customer);
        if (response.getStatus() != 200 || response.getStatus() != 201) {
            return returnError(response.getBody());
        } else {
            return "Cliente salvo!";
        }
    }

    public String getToken(AuthModel auth) {
        var response = appRequest.getToken(auth);
        if (response.getStatus() != 200 || response.getStatus() != 201) {
            return returnError(response.getBody());
        } else {
            TokenModel tokenModel = ConvertJson.execute(response.getBody(), TokenModel.class);
            Cache.put("token", tokenModel.getToken());
            return "ok";
        }
    }

    public String saveAccount() throws Exception {
        var response = appRequest.saveAccount(Cache.get("token").toString());
        if (response.getStatus() != 200 || response.getStatus() != 201) {
            return returnError(response.getBody());
        } else {
            return "Sua conta foi criada com sucesso!";
        }
    }

    public Map<String, Object> getInfoAccount() throws Exception {
        var response = appRequest.getAccountInfo(Cache.get("token").toString());
        var result = new HashMap<String, Object>();
        result.put("status", response.getStatus());
        if (response.getStatus() != 200 || response.getStatus() != 201) {
            result.put("erro", returnError(response.getBody()));
        } else {
            AccountInfo accountInfo = ConvertJson.execute(response.getBody(), AccountInfo.class);
            result.put("infoConta", accountInfo);
        }
        return result;
    }

    public String savePixKey(String typekey) throws Exception {
        var response = appRequest.savePixKey(Cache.get("token").toString(), typekey);
        if (response.getStatus() != 201) {
            return returnError(response.getBody());
        } else {
            return "Chave registrada com sucesso!";
        }
    }

    public Map<String, Object> getAccountByPix(String key) throws Exception {
        var response = appRequest.findAccountByKey(Cache.get("token").toString(), key);
        var result = new HashMap<String, Object>();
        result.put("status", response.getStatus());
        if (response.getStatus() != 200) {
            result.put("erro", returnError(response.getBody()));
        } else {
            var accountDestiny = ConvertJson.execute(response.getBody(), AccountDestinyModel.class);
            result.put("contaDestino", accountDestiny);
        }
        return result;
    }

    public Map<String, Object> transactionByPix(TransactionPixModel pixModel) throws Exception {
        var response = appRequest.transactionPix(Cache.get("token").toString(), pixModel);
        var result = new HashMap<String, Object>();
        result.put("status", response.getStatus());
        if (response.getStatus() != 200 || response.getStatus() != 201) {
            result.put("erro", returnError(response.getBody()));
        } else {
            var transaction = ConvertJson.execute(response.getBody(), TransactionResponseModel.class);
            result.put("transacao", transaction);
        }
        return result;
    }

    public Map<String, Object> getHistory() throws Exception {
        var response = appRequest.getTransactionHistory(Cache.get("token").toString());
        var result = new HashMap<String, Object>();
        result.put("status", response.getStatus());
        if (response.getStatus() != 200) {
            result.put("erro", returnError(response.getBody()));
        } else {
            var history = ConvertJson.execute(response.getBody(), TransactionHistoryModel.class);
            result.put("historico", history);
        }
        return result;
    }

    private String returnError(String json) {
        try {
            ErrModel err = (ErrModel) ConvertJson.execute(json, ErrModel.class);
            return err.getMessage();
        } catch (Exception e) {
            ErrModel[] err = (ErrModel[]) ConvertJson.execute(json, ErrModel[].class);
            String message = "\n";
            for (ErrModel error : err) {
                message += error.getMessage() + "\n";
            }
            return message;
        }
    }
}
