package br.com.fourbank.utils;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author thiag
 */
public class PdfUtils {

    public static void gerarEVisualizarPDF(String dataHora, String quemPagou, String quemRecebeu, String valor) throws ParseException {
        try {
            // Criar um novo documento PDF
            PdfDocument pdf = new PdfDocument(new PdfWriter("arquivo.pdf"));
             Document document = new Document(pdf, PageSize.A6);

            Date dataHoraFormatada = parsearDataHora(dataHora);
            SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            // Adicionar os dados ao PDF
            document.add(new Paragraph("-------------FOURBANK----------------"));
            document.add(new Paragraph("Data e Hora: " + formatoSaida.format(dataHoraFormatada)));
            document.add(new Paragraph("-------------------------------"));
            document.add(new Paragraph("Quem Pagou: " + quemPagou));
            document.add(new Paragraph("Quem Recebeu: " + quemRecebeu));
            document.add(new Paragraph("-------------------------------"));
            document.add(new Paragraph("Valor: R$" + valor));

            // Fechar o documento
            document.close();

            // Abrir o arquivo com o leitor de PDF padrão
            Desktop.getDesktop().open(new File("arquivo.pdf"));

            System.out.println("Arquivo PDF gerado e aberto com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Date parsearDataHora(String dataHora) throws ParseException {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        return formatoEntrada.parse(dataHora);
    }

    private static void abrirArquivoPDF(String filePath) {
        try {
            File file = new File(filePath);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
