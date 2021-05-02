package com.company;

import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        screenMessages messages = new screenMessages();
        screenController controller = new screenController();

        messages.mensagemAbertura();

        int opcaoSelecionada = 0;

        while (opcaoSelecionada != contantes.OPCAO_SAIR){
            messages.emitirOpcoes();
            opcaoSelecionada = controller.informarOpcao();
            controller.executarOpcao(opcaoSelecionada);
        }
    }
}
