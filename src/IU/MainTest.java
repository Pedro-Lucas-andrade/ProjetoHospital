package IU;

import Dados.Repositorios.RepositorioConsultas;
import Negocio.ClassesBasicas.Consulta;
import Negocio.ClassesBasicas.Medico;
import Negocio.ClassesBasicas.Paciente;
import Negocio.Constantes.Sexo;
import Negocio.Constantes.Especialidade;
import Negocio.Constantes.Plano;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        // Criação de repositório
        RepositorioConsultas repositorio = new RepositorioConsultas();

        // Criando objetos Médico e Paciente
        Medico medico1 = new Medico("Dr. João", "123456789", "1975-05-20", Sexo.MASCULINO, "CRM1234", Especialidade.CARDIOLOGISTA);
        Paciente paciente1 = new Paciente("Maria Silva", "987654321", "1985-08-10", Sexo.FEMININO, Plano.PARTICULAR);

        // Criando consultas
        Consulta consulta1 = new Consulta(medico1, paciente1, LocalDate.of(2025, 5, 15), LocalTime.of(10, 0), "Agendada");
        Consulta consulta2 = new Consulta(medico1, paciente1, LocalDate.of(2025, 5, 16), LocalTime.of(11, 0), "Agendada");

        // Adicionar consultas
        repositorio.adicionar(consulta1);
        repositorio.adicionar(consulta2);

        // Buscar por data e hora
        System.out.println("Buscando consultas no dia 15 de Maio de 2025 às 10h:");
        List<Consulta> consultasDataHora = repositorio.buscarPorDataHora(LocalDate.of(2025, 5, 15), LocalTime.of(10, 0));
        for (Consulta consulta : consultasDataHora) {
            System.out.println(consulta);
        }

        // Atualizar uma consulta
        consulta1.setStatus("Realizada");
        repositorio.atualizar(consulta1);

        // Remover uma consulta
        repositorio.remover(consulta2);

        // Buscar consultas por paciente
        System.out.println("\nConsultas do paciente Maria Silva:");
        List<Consulta> consultasPaciente = repositorio.buscarPorPaciente("987654321");
        for (Consulta consulta : consultasPaciente) {
            System.out.println(consulta);
        }

        // Buscar consultas por médico
        System.out.println("\nConsultas do médico Dr. João:");
        List<Consulta> consultasMedico = repositorio.buscarPorMedico("CRM1234");
        for (Consulta consulta : consultasMedico) {
            System.out.println(consulta);
        }
    }
}

