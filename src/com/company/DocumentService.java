package com.company;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DocumentService {

    public void cadastrarDocument(List<Document> listDocument, List<Cliente> listClientes){
        //-Limpar tela antes de cadastrar novo documento
        //screenController.clearScreen();
        System.out.println("Cadastrar de documentos:");
        Document document = new Document();

        int maxCode = 0;
        if (listDocument == null || listDocument.size() == 0){
            maxCode = 1;
        }
        else {
            maxCode = listDocument.size()+1;
        }

        document.codigo = maxCode;
        Scanner is = new Scanner(System.in);
        System.out.print("Serie:");
        String serie = is.next();
        document.serie   = (!serie.isEmpty())? serie: "";

        DateFormat format = new SimpleDateFormat("dd/mm/yyyy", new Locale("pt", "BR"));

        while (document.dataEmissao == null){
            String text = screenController.ReadInformationOnScreen(is,"Data de Emissão:");
            try {
                document.dataEmissao = format.parse(text);
            }catch(ParseException e){
                System.out.println("Erro ao realizar a conversão da data de Emissão informada");
            }
        }

        while (document.dataEntrada == null){
            String text = screenController.ReadInformationOnScreen(is,"Data de Entrada:");
            try {
                document.dataEntrada = format.parse(text);
            }catch(ParseException e){
                System.out.println("Erro ao realizar a conversão da data de Entrada informada");
            }
        }

        boolean codigoClienteValido = false;

        while (!codigoClienteValido)
        {
            System.out.println("--------------------");
            System.out.println("Clientes:");
            ClienteService cliente = new ClienteService();
            cliente.listarClientes(listClientes);
            System.out.println("--------------------");
            System.out.print("Informe o código do cliente:");
            is = new Scanner(System.in);
            try {
                document.codigoCliente   = is.nextInt();
            } catch (Exception exception){
                System.out.println("Erro ao buscar código do cliente!");
            }


            if (!(cliente.validaClientePorCodigo(document.codigoCliente, listClientes))){
                System.out.println("Código de cliente invalido, favor informar um código valido de acordo com a lista a baixo");
            }
            else {
                codigoClienteValido = true;
            }
        }

        System.out.print("Valor:");
        is = new Scanner(System.in);
        document.valor   = is.nextDouble();

        listDocument.add(document);
    }

    public void listarDocument(List<Document> listDocument){
        listDocument.forEach(document -> System.out.println("Código:"+document.codigo + " - Série:"+document.serie+
                                                            " - Data de emissão:"+ new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR")).format(document.dataEmissao) +
                                                            " - Valor:"+document.valor));
    }

}
