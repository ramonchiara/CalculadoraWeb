package modelos;

public class Calculadora {

    private double n1, n2;
    private String operador;

    public Calculadora(double n1, double n2, String operador) {
        this.n1 = n1;
        this.n2 = n2;
        this.operador = operador;
    }

    public double getValorCalculado() {
        double valor;

        switch (operador) {
            case "+":
                valor = n1 + n2;
                break;
            case "-":
                valor = n1 - n2;
                break;
            case "*":
                valor = n1 * n2;
                break;
            case "/":
                valor = n1 / n2;
                break;
            default:
                throw new IllegalArgumentException();
        }

        return valor;
    }

}
