package Dados.Auxiliares;

import Negocio.ClassesBasicas.Consulta;

import java.util.ArrayList;

public class ListadeConsultas {
    ArrayList<Consulta> consultas = new ArrayList<>();

    // Construtor sem argumentos
    public ListadeConsultas() {
        // inicializa a lista vazia
    }

    // Construtor com argumento (opcional, caso você precise adicionar uma consulta imediatamente)
    public ListadeConsultas(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public ArrayList<Consulta> getConsultas() {
        return this.consultas;
    }

    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }
}
