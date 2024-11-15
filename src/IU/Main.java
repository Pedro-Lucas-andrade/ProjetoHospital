package IU;

import Dados.Auxiliares.Ano;
import Dados.Auxiliares.Mes;
import Dados.Auxiliares.ListadeConsultas;
import Negocio.ClassesBasicas.Consulta;
import Negocio.ClassesBasicas.Medico;
import Negocio.ClassesBasicas.Paciente;
import Negocio.Constantes.Especialidade;
import Negocio.Constantes.Plano;
import Negocio.Constantes.Sexo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Criando o ano de exemplo, por exemplo, 2025
        Ano ano2025 = new Ano(2025);

        // Obtendo o mês de janeiro do ano 2025
        Mes janeiro = ano2025.getArrayMeses()[0]; // índice 0 para janeiro

        // Criando um objeto Medico com todos os parâmetros necessários
        Medico medico = new Medico(
                "Dr. Silva",
                "123.456.789-00",
                "01/01/1980",
                Sexo.MASCULINO,
                "CRM12345",
                Especialidade.CARDIOLOGISTA
        );

        // Criando um objeto Paciente com todos os parâmetros necessários
        Paciente paciente = new Paciente(
                "Maria",
                "987.654.321-00",
                "15/03/1990",
                Sexo.FEMININO,
                Plano.GOLD
        );

        // Criando uma consulta para o dia 10 de janeiro às 3h da manhã
        Consulta consultaExemplo = new Consulta(
                medico,
                paciente,
                LocalDate.of(2025, 1, 10),
                LocalTime.of(3, 0),
                "Confirmada"
        );


        // Verificando se a consulta foi adicionada corretamente
        ListadeConsultas consultasDiaHora = janeiro.getDiaPorHora()[3][9]; // [hora][dia - 1] -> 3 e 9

        System.out.println("Consultas para o dia 10 de janeiro às 3h:");
        for (Consulta consulta : consultasDiaHora.getConsultas()) {
            System.out.println(consulta);
        }
    }
}
