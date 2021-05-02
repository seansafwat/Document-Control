package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ClienteService {

   public void cadastrarCliente(List<Cliente> listCliente){
        System.out.println("Cadastrar cliente:");
        Cliente cliente = new Cliente();

        int maxCode = 0;
        if (listCliente == null || listCliente.size() == 0){
            maxCode = 1;
        }
        else {
            maxCode = listCliente.size()+1;
        }

        cliente.codigo = maxCode;

        InputStream is = System.in;
        System.out.print("Nome:");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        try {
            cliente.nome   = br.readLine();
        } catch (Exception exception){
            System.out.println("Erro ao buscar string do nome!");
        }


        listCliente.add(cliente);
    }

    public void listarClientes(List<Cliente> listCliente){
        listCliente.forEach(cliente -> System.out.println("Código:"+cliente.codigo + " - Nome:"+cliente.nome.toUpperCase()));
    }

    public boolean validaClientePorCodigo(int codigo, List<Cliente> listCliente){

        return listCliente.stream()
                .filter(c -> c.getCodigo() == codigo)
                .collect(Collectors.toList())
                .size() > 0;
    }
}
