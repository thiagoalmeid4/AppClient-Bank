package br.com.fourbank.utils;

import br.com.fourbank.models.ApiResponse;
import com.google.gson.Gson;

public class ConvertJson {

    private static Gson gson = new Gson();

    public static <T> T execute(String json, Class<T> clazz) {
        try{
            T response = gson.fromJson(json, clazz);
            return response;
        }catch(Throwable e){
            return null;
        }
    }
}
