package Dados.Auxiliares;

import Negocio.ClassesBasicas.Consulta;

import java.util.ArrayList;

public class Mes {
    private int dias;
    private int horas;
    private ListadeConsultas[][] diaPorHora;

    // Construtor que inicializa dias e horas e prepara cada posição com uma lista de consultas
    public Mes(int dias, int horas) {
        this.dias = dias;
        this.horas = horas;
        this.diaPorHora = new ListadeConsultas[horas][dias];

        // Inicializa cada posição da matriz com uma nova instância de ListadeConsultas
        for (int i = 0; i < horas; i++) {
            for (int j = 0; j < dias; j++) {
                diaPorHora[i][j] = new ListadeConsultas();
            }
        }
    }

    // Método para obter a matriz de listas de consultas
    public ListadeConsultas[][] getDiaPorHora() {
        return diaPorHora;
    }

    // Getters para dias e horas
    public int getDias() {
        return dias;
    }

    public int getHoras() {
        return horas;
    }
}
