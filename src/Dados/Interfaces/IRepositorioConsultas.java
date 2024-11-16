package Dados.Interfaces;

import Negocio.ClassesBasicas.Consulta;

public abstract interface IRepositorioConsultas {
    void adicionar(Consulta consulta);
    void remover(Consulta consulta);
    void atualizar(Consulta consulta);
}
