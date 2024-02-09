package br.com.fourbank.request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import java.net.http.HttpResponse;

import br.com.fourbank.models.ApiResponse;
import br.com.fourbank.models.AuthModel;

import com.google.gson.Gson;

import br.com.fourbank.models.CustomerModel;
import br.com.fourbank.models.TransactionPixModel;
import br.com.fourbank.models.TransactionTedModel;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApiRequest {

    private final String url = "https://fourbankservice.onrender.com/api-fourbank";

    private HttpClient client = HttpClient.newHttpClient();

    private Gson gson = new Gson();

    private HttpRequest request;

    public ApiResponse saveCustomer(CustomerModel customer) {
            
        String requestBody = gson.toJson(customer);

        var apiResponse = new ApiResponse();

        request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(url.concat("/save-customer")))
                .setHeader("Content-Type", "application/json")
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponse.setBody(response.body());
            apiResponse.setStatus(response.statusCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return apiResponse;
    }

    public ApiResponse getToken(AuthModel auth) {

        var apiResponse = new ApiResponse();
        var requestBody = gson.toJson(auth);
        request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(url.concat("/get-token")))
                .setHeader("Content-Type", "application/json")
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponse.setBody(response.body());
            apiResponse.setStatus(response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public ApiResponse saveAccount(String token) {

        var apiResponse = new ApiResponse();

        request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .uri(URI.create(url.concat("/save-account")))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", token)
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponse.setBody(response.body());
            apiResponse.setStatus(response.statusCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return apiResponse;
    }

    public ApiResponse getAccountInfo(String token) {

        var apiResponse = new ApiResponse();

        request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url.concat("/account-info")))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", token)
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponse.setBody(response.body());
            apiResponse.setStatus(response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public ApiResponse savePixKey(String token, String typeKey) {

        var apiResponse = new ApiResponse();

        request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .uri(URI.create(url.concat("/save-pix-key?type_key=".concat(typeKey))))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", token)
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponse.setBody(response.body());
            apiResponse.setStatus(response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public ApiResponse findAccountByKey(String token, String key) {

        var apiResponse = new ApiResponse();

        try {
            key = URLEncoder.encode(key, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ApiRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url.concat("/find-account/pix?key=".concat(key))))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", token)
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponse.setBody(response.body());
            apiResponse.setStatus(response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public ApiResponse transactionPix(String token, TransactionPixModel pixModel) {

        var apiResponse = new ApiResponse();

        var requestBody = gson.toJson(pixModel);

        request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(url.concat("/transaction/pix")))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", token)
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponse.setBody(response.body());
            apiResponse.setStatus(response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public ApiResponse getTransactionHistory(String token) {

        var apiResponse = new ApiResponse();

        request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url.concat("/transaction/history")))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", token)
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponse.setBody(response.body());
            apiResponse.setStatus(response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public ApiResponse getCheckToken(String token) {

        var apiResponse = new ApiResponse();

        request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url.concat("/check-token")))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", token)
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponse.setBody(response.body());
            apiResponse.setStatus(response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public ApiResponse transactionTed(String token, TransactionTedModel tedModel) {

        var apiResponse = new ApiResponse();

        var requestBody = gson.toJson(tedModel);

        request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(url.concat("/transaction/ted")))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", token)
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponse.setBody(response.body());
            apiResponse.setStatus(response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public ApiResponse getPixKeys(String token) {

        var apiResponse = new ApiResponse();

        request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url.concat("/my-pix-keys")))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", token)
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponse.setBody(response.body());
            apiResponse.setStatus(response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }
}
