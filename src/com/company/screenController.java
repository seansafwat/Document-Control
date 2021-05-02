package com.company;

import com.sun.security.ntlm.Client;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class screenController {

    List<Cliente> listCliente;
    List<Document> listDocument;

    public screenController() {
        this.listCliente = new ArrayList<>();
        this.listDocument = new ArrayList<>();
    }

    public static int informarOpcao() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public void executarOpcao(int opcaoSelecionada) {

        switch (opcaoSelecionada){
            case contantes.OPCAO_CADASTRO:
                do {
                    screenMessages.emitirOpcoesCadastro();
                    opcaoSelecionada = informarOpcao();
                    executarOpcaoCadastro(opcaoSelecionada, listCliente);
                }while (opcaoSelecionada != contantes.OPCAO_CADASTRO_SAIR);
                break;
            case contantes.OPCAO_PROCESSO :
                do {
                    screenMessages.emitirOpcoesProcessos();
                    opcaoSelecionada = informarOpcao();
                    executarOpcaoProcesso(opcaoSelecionada, listDocument, listCliente);
                }while (opcaoSelecionada != contantes.OPCAO_PROCESSO_SAIR);
                break;
            case contantes.OPCAO_RELATORIO :
                do {
                    screenMessages.emitirOpcoesRelatorios();
                    opcaoSelecionada = informarOpcao();
                    executarOpcaoRelatorio(opcaoSelecionada, listDocument, listCliente);
                }while (opcaoSelecionada != contantes.OPCAO_RELATORIO_SAIR);
                break;
        }
    }

    public static void executarOpcaoCadastro(int opcaoSelecionada, List<Cliente> listCliente) {

        switch (opcaoSelecionada){
            case contantes.OPCAO_CADASTRO_CLIENTE:
                screenMessages.emitirOpcoesCadastrarListar();
                opcaoSelecionada = informarOpcao();
                ClienteController controller = new ClienteController();
                int retorno  = controller.executarOpcaoCadastroLista(opcaoSelecionada, listCliente);
                break;
            case contantes.OPCAO_CADASTRO_SAIR :
                break;
        }
    }

    public static void executarOpcaoProcesso(int opcaoSelecionada, List<Document> listDocument, List<Cliente> listCliente) {

        switch (opcaoSelecionada){
            case contantes.OPCAO_PROCESSO_NOTA:
                screenMessages.emitirOpcoesCadastrarListar();
                opcaoSelecionada = informarOpcao();
                DocumentController controller = new DocumentController();
                int retorno  = controller.executarOpcaoCadastroLista(opcaoSelecionada, listDocument, listCliente);
                break;
            case contantes.OPCAO_CADASTRO_SAIR :
                break;
        }
    }

    public static void executarOpcaoRelatorio(int opcaoSelecionada, List<Document> listDocument, List<Cliente> listCliente) {

        DocumentReaderService service = new DocumentReaderService();

        switch (opcaoSelecionada){
            case contantes.OPCAO_RELATORIO_IMPORTAR:
                try {
                    service.importDocument(listDocument, listCliente);
                } catch (IOException | ParseException e){
                    System.out.println("Erro"+e.getMessage());
                }

                break;
            case contantes.OPCAO_RELATORIO_EXPORTAR:
                try {
                    service.exportDocument(listDocument);
                } catch (IOException e){
                    System.out.println("Erro"+e.getMessage());
                }

                break;
            case contantes.OPCAO_RELATORIO_SAIR:
                break;
        }
    }

    public static void clearScreen(){
        /*try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String ReadInformationOnScreen(Scanner is, String title){
        is = new Scanner(System.in);
        System.out.print(title);
        return is.nextLine();
    }


}
