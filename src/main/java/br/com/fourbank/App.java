package br.com.fourbank;

import br.com.fourbank.frames.LoginFrame;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
    public static void main( String[] args ) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new FlatLightLaf());
        new LoginFrame().setVisible(true);
    }
}
