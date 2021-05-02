package com.company;

import java.util.List;

public class DocumentController {

    public static int executarOpcaoCadastroLista(int opcaoSelecionada, List<Document> listDocument, List<Cliente> listCliente){

        DocumentService service = new DocumentService();

        switch (opcaoSelecionada){
            case contantes.OPCAO_CADASTRAR :
                service.cadastrarDocument(listDocument, listCliente);
                break;
            case contantes.OPCAO_LISTAR :
                service.listarDocument(listDocument);
                break;
        }

        return opcaoSelecionada;
    }
}
