package Dados.Interfaces;

import Negocio.ClassesBasicas.PessoaAbstrata;

import java.util.ArrayList;

public interface IRepositorioPessoas {
    public abstract boolean adicionar(PessoaAbstrata pessoa);
    public abstract void remover(PessoaAbstrata pessoa);
    public abstract boolean atualizar(String cpf, String nome);
    public abstract boolean buscar(String cpf);
    public abstract ArrayList<PessoaAbstrata> ler();
}
