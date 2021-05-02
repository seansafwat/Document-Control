package com.company;

import java.util.Objects;

public class Cliente {

    int codigo;
    String nome;

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return codigo == cliente.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
