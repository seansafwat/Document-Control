package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DocumentReaderService {

    public void importDocument(List<Document> listDocument, List<Cliente> listClientes) throws IOException, ParseException {
        System.out.println("Importar documentos:");
        System.out.print("Favor, informe aqui o caminho do arquivo da importação(Incluisive nome do arquivo com estenção .txt):");
        Scanner is = new Scanner(System.in);
        String caminho = is.next();
        File file = new File(caminho);

        if (caminho.isEmpty() || !file.exists()){
            System.out.print("Caminho informado é invalido ou inexistente!");
            System.out.print("--------------------------------------------");
            return;
        }

        try (Scanner scanner = new Scanner(new File(caminho))) {
            while(scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] values = linha.split("\\|");
                Document document = new Document();
                document.codigo = 1;
                document.serie = values[1];
                document.dataEmissao = new SimpleDateFormat("dd/MM/yyyy").parse(values[2]);
                document.dataEntrada = new SimpleDateFormat("dd/MM/yyyy").parse(values[3]);
                document.valor = Double.parseDouble(values[4]);

                listDocument.add(document);
            }
        }
        System.out.println("--------------------------------------------");
        System.out.println("Documentos importados com sucesso.");
    }

    public void exportDocument(List<Document> listDocument) throws IOException{
        System.out.println("Exportar documentos:");
        System.out.print("Favor, informe aqui o caminho da exportação:");
        Scanner is = new Scanner(System.in);
        String caminho = is.next();
        File file = new File(caminho);

        if (caminho.isEmpty() || !file.exists()){
            System.out.print("Caminho informado é invalido ou inexistente!");
            System.out.print("--------------------------------------------");
            return;
        }

        try(PrintWriter pw = new PrintWriter(caminho+"\\saida.txt")){
            listDocument.forEach(document -> pw.println(document.codigo + "|"+document.serie+"|"+
                                                        new SimpleDateFormat("dd/mm/yyyy", new Locale("pt", "BR")).format(document.dataEmissao) +"|"+
                                                        new SimpleDateFormat("dd/mm/yyyy", new Locale("pt", "BR")).format(document.dataEntrada)+"|"+
                                                        +document.valor));
        }

        System.out.println("--------------------------------------------");
        System.out.println("Documentos exportados com sucesso.");

    }

}
