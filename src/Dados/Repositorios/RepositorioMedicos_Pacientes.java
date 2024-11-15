package Dados.Repositorios;

import Dados.Interfaces.IRepositorioPessoas;
import Negocio.ClassesBasicas.PessoaAbstrata;

import java.util.ArrayList;

public class RepositorioMedicos_Pacientes implements IRepositorioPessoas {
    private ArrayList<PessoaAbstrata> arrayPessoas = new ArrayList<>();

    @Override
    public boolean buscar(String cpf){
        for(PessoaAbstrata pessoa: arrayPessoas){
            if(cpf.equals(pessoa.getCpf())){
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<PessoaAbstrata> ler() {
        if(arrayPessoas.isEmpty()){
            return null;
        }
        return arrayPessoas;
    }

    @Override
    public boolean adicionar(PessoaAbstrata pessoa) {
        if(arrayPessoas.add(pessoa)) return true;
        return false;
    }

    @Override
    public void remover(PessoaAbstrata pessoa) {
        arrayPessoas.remove(pessoa);
    }

    @Override
    public boolean atualizar(String cpf, String nome) {
        for (PessoaAbstrata pessoa : arrayPessoas) {
            if (cpf.equals(pessoa.getCpf())) {
                pessoa.setNome(nome);
                return true;
            }
        }
        return false;
    }
}
