package com.company;

import java.util.List;

public class ClienteController {

    public static int executarOpcaoCadastroLista(int opcaoSelecionada, List<Cliente> listCliente){

        ClienteService service = new ClienteService();

        switch (opcaoSelecionada){
            case contantes.OPCAO_CADASTRAR :
                service.cadastrarCliente(listCliente);
                break;
            case contantes.OPCAO_LISTAR :
                service.listarClientes(listCliente);
                break;
        }

        return opcaoSelecionada;
    }

}
