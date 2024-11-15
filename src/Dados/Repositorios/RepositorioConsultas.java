package Dados.Repositorios;

import Dados.Auxiliares.Ano;
import Dados.Auxiliares.ListadeConsultas;
import Dados.Auxiliares.Mes;
import Dados.Interfaces.IRepositorioConsultas;
import Negocio.ClassesBasicas.Consulta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioConsultas implements IRepositorioConsultas {
    Ano ano = new Ano(2025);
    Mes[] meses = ano.getArrayMeses();

    @Override
    public void adicionar(Consulta consulta) {
        int mesDaConsulta = consulta.getData().getMonthValue() - 1; // Ajuste para índice de array (0 a 11)
        int diaDaConsulta = consulta.getData().getDayOfMonth() - 1; // Ajuste para índice (0 a 30/29)
        int horaDaConsulta = consulta.getHora().getHour();

        Mes mes = meses[mesDaConsulta];

        // Verifica se o índice está dentro dos limites antes de acessar o array
        if (horaDaConsulta >= 8 && horaDaConsulta < mes.getHoras() && diaDaConsulta >= 0 && diaDaConsulta < mes.getDias()) {
            // Adiciona a consulta ao horário e dia específicos
            mes.getDiaPorHora()[horaDaConsulta][diaDaConsulta].getConsultas().add(consulta);
        } else {
            System.out.println("Erro: Hora ou dia da consulta está fora dos limites.");
        }
    }


    @Override
    public void remover(Consulta consulta) {
        int mesDaConsulta = consulta.getData().getMonthValue() - 1;
        int diaDaConsulta = consulta.getData().getDayOfMonth() - 1;
        int horaDaConsulta = consulta.getHora().getHour();

        Mes mes = meses[mesDaConsulta];

        // Verificação de limites
        if (horaDaConsulta >= 0 && horaDaConsulta < mes.getHoras() && diaDaConsulta >= 0 && diaDaConsulta < mes.getDias()) {
            ListadeConsultas lista = mes.getDiaPorHora()[horaDaConsulta][diaDaConsulta];
            lista.getConsultas().remove(consulta); // Remover a consulta específica
        } else {
            System.out.println("Erro: Hora ou dia da consulta está fora dos limites para remoção.");
        }
    }

    @Override
    public void atualizar(Consulta consulta) {
        remover(consulta); // Remove a consulta existente, com verificação de limites
        adicionar(consulta); // Adiciona a consulta atualizada
    }


    // Método para buscar consultas por data e hora específicas
    // Método para buscar consultas por data e hora específicas
    public List<Consulta> buscarPorDataHora(LocalDate data, LocalTime hora) {
        int mesDaConsulta = data.getMonthValue() - 1; // Ajusta para índice de array (0 a 11)
        int diaDaConsulta = data.getDayOfMonth() - 1; // Ajuste para índice (0 a 30/29)
        int horaDaConsulta = hora.getHour();

        Mes mes = meses[mesDaConsulta];

        // Verificação de limites
        if (horaDaConsulta >= 0 && horaDaConsulta < mes.getHoras() && diaDaConsulta >= 0 && diaDaConsulta < mes.getDias()) {
            ListadeConsultas lista = mes.getDiaPorHora()[horaDaConsulta][diaDaConsulta];
            return new ArrayList<>(lista.getConsultas()); // Retorna uma cópia das consultas
        } else {
            System.out.println("Erro: Hora ou dia da consulta está fora dos limites.");
            return new ArrayList<>(); // Retorna uma lista vazia caso esteja fora dos limites
        }
    }


    // Método para buscar todas as consultas de um paciente específico
    public List<Consulta> buscarPorPaciente(String cpfPaciente) {
        List<Consulta> consultasPaciente = new ArrayList<>();
        for (Mes mes : meses) {
            for (int i = 0; i < mes.getHoras(); i++) {
                for (int j = 0; j < mes.getDias(); j++) {
                    for (Consulta consulta : mes.getDiaPorHora()[i][j].getConsultas()) {
                        if (consulta.getPaciente().getCpf().equals(cpfPaciente)) {
                            consultasPaciente.add(consulta);
                        }
                    }
                }
            }
        }
        return consultasPaciente;
    }

    // Método para buscar todas as consultas de um médico específico
    public List<Consulta> buscarPorMedico(String crmMedico) {
        List<Consulta> consultasMedico = new ArrayList<>();
        for (Mes mes : meses) {
            for (int i = 0; i < mes.getHoras(); i++) {
                for (int j = 0; j < mes.getDias(); j++) {
                    for (Consulta consulta : mes.getDiaPorHora()[i][j].getConsultas()) {
                        if (consulta.getMedico().getCRM().equals(crmMedico)) {
                            consultasMedico.add(consulta);
                        }
                    }
                }
            }
        }
        return consultasMedico;
    }
}
