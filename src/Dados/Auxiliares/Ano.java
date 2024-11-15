package Dados.Auxiliares;

public class Ano {
    private int ano;
    private Mes[] arrayMeses = new Mes[12];
    private int[] diasDoMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    // Construtor do ano que verifica se é bissexto
    public Ano(int ano) {
        this.ano = ano;
        if (isBissexto(ano)) {
            diasDoMes[1] = 29; // Ajusta fevereiro para 29 dias
        }
        for (int i = 0; i < 12; i++) {
            this.arrayMeses[i] = new Mes(diasDoMes[i], 17);
        }
    }

    public Mes[] getArrayMeses() {
        return arrayMeses;
    }

    public int getAno() {
        return this.ano;
    }

    // Método para verificar se o ano é bissexto
    private boolean isBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
}
