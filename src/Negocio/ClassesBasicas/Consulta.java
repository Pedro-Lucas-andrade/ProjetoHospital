package Negocio.ClassesBasicas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private LocalDate data;
    private LocalTime hora;
    private String status;

    public Consulta(Medico medico, Paciente paciente, LocalDate data, LocalTime hora, String status){
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.hora = hora;
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "Consulta [Paciente: " + this.getPaciente() + "Medico: " + this.getMedico() + "Data: " + this.getData() + "Hora: " + this.getHora() + "Status: " + this.getStatus() + "]";
    }
}
