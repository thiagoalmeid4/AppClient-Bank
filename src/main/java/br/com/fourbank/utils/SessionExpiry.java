package br.com.fourbank.utils;

import br.com.fourbank.frames.LoginFrame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class SessionExpiry {
    
    public static void execute (int status, JFrame frame){
        if(status == 401){
            JOptionPane.showMessageDialog(null, "Sessão expirada",null, JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            new LoginFrame().setVisible(true);
        }
    }
}
