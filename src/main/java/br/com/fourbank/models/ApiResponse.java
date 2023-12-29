package br.com.fourbank.models;

public class ApiResponse {

    private String body;

    private int status;

    public ApiResponse (){}

    public ApiResponse(String body, int status) {
        this.body = body;
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
