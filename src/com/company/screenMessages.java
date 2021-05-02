package com.company;

public class screenMessages {

    public static void mensagemAbertura(){
        System.out.println("Bem vindo ao sistema de controle de notas");
        System.out.println("------------------------------------------");
        System.out.println("Selecione as opções do menu abaixo para continuar:");
    }

    public static void emitirOpcoes(){
        System.out.println("1 : Cadastros");
        System.out.println("2 : Processos");
        System.out.println("3 : Relatorios");
        System.out.println("4 : Sair");
    }

    public static void emitirOpcoesCadastro(){
        System.out.println("1 : Cadastrar cliente");
        System.out.println("2 : Sair");
    }

    public static void emitirOpcoesProcessos(){
        System.out.println("1 : Lançamento de documento");
        System.out.println("2 : Sair");
    }

    public static void emitirOpcoesRelatorios(){
        System.out.println("1 : Importar documento");
        System.out.println("2 : Exportar documento");
        System.out.println("3 : Sair");
    }

    public static void emitirOpcoesCadastrarListar() {
        System.out.println("1 : Cadastrar");
        System.out.println("2 : Listar");
        System.out.println("3 : Sair");
    }
}
