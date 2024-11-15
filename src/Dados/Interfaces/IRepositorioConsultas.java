package Dados.Interfaces;

import Negocio.ClassesBasicas.Consulta;

public abstract interface IRepositorioConsultas {
    public abstract void adicionar(Consulta consulta);
    public abstract void remover(Consulta consulta);
    public abstract void atualizar(Consulta consulta);
}
