package br.com.fourbank.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author thiag
 */
public class MoneyFormat {

    public static DefaultFormatterFactory getMoneyFormatter() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(','); // Define a vírgula como separador decimal
        symbols.setGroupingSeparator('.'); // Define o ponto como separador de milhares
        decimalFormat.setDecimalFormatSymbols(symbols);
        decimalFormat.setMinimumFractionDigits(2); // Define o número mínimo de casas decimais
        decimalFormat.setMaximumFractionDigits(2); // Define o número máximo de casas decimais
        NumberFormatter formatter = new NumberFormatter(decimalFormat);
        formatter.setAllowsInvalid(false); // Não permite valores inválidos
        formatter.setOverwriteMode(false); // Não sobrescreve os valores
        formatter.setValueClass(Double.class); // Define a classe do valor como Double
        formatter.setCommitsOnValidEdit(true); // Realiza a edição ao final da entrada

        return new DefaultFormatterFactory(formatter);
    }
    
    
    public static double getValue(String value){
        String xValue = value.replace(".", "");
        xValue = xValue.replace(",", ".");
        return Double.parseDouble(xValue);
    }
}
