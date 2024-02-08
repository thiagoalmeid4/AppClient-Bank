package br.com.fourbank.utils;

import br.com.fourbank.frames.LoginFrame;
import br.com.fourbank.request.ApiRequest;
import cache.io.Cache;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class SessionExpiry {
    
    public static Boolean execute () throws Exception{
        String token = Cache.get("token").toString();
        var response = new ApiRequest().getCheckToken(token);
        if(response.getStatus() == 200){
            return true;
        }else{
            return false;
        }
    }
}
