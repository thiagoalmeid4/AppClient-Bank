package br.com.fourbank.utils;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author thiag
 */
public class PdfUtils {

    public static void gerarEVisualizarPDF(String dataHora, String quemPagou, String quemRecebeu, String valor, String type, Long id) {
        try {
            // Criar um novo documento PDF
            PdfDocument pdf = new PdfDocument(new PdfWriter("arquivo.pdf"));
            Document document = new Document(pdf, PageSize.A6);

            LocalDateTime dataHoraFormatada = parsearDataHora(dataHora);
            DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            dataHora = formatoSaida.format(dataHoraFormatada);
            // Adicionar os dados ao PDF
            document.add(new Paragraph("------------------FOURBANK------------------"));
            document.add(new Paragraph("Data e Hora: " + dataHora));
            document.add(new Paragraph("_________________________________"));
            document.add(new Paragraph("ID da transação: " + id));
            document.add(new Paragraph("_________________________________"));
            document.add(new Paragraph("Quem Pagou: " + quemPagou));
            document.add(new Paragraph("Quem Recebeu: " + quemRecebeu));
            document.add(new Paragraph("_________________________________"));
            document.add(new Paragraph("Tipo de transação: " + type));
            document.add(new Paragraph("_________________________________"));
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

    private static LocalDateTime parsearDataHora(String dataHora) {
        return LocalDateTime.parse(dataHora, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
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
