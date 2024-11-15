package Negocio.ClassesBasicas;

import Negocio.Constantes.Especialidade;
import Negocio.Constantes.Sexo;

public class Medico extends PessoaAbstrata {
    private Especialidade especialidade;
    private final String CRM;

    public Medico(String nome, String cpf, String dataDeNascimento, Sexo sexo, String CRM, Especialidade especialidade) {
        super(nome, cpf, dataDeNascimento, sexo);
        this.CRM = CRM;
        this.especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }
}