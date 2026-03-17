public class Conta {

    private String titular; // usamos private para encapsular dados
    private int numero;
    private double saldo;

    public Conta(String titular, int numero){ //dentro vão os parâmetros que vou usar
        this.titular = titular;
        this.numero = numero;
        this.saldo = 0;
    }
    // os códigos void abaixo serão os métodos para cada ação
    public void depositar(double valor){
    saldo += valor;
        if (valor > 0){ // aqui criei uma validação do valor
            saldo += valor;
        }
        else{
            return;
        }
    }

    public boolean sacar(double valor) {
        if (valor > saldo) {
            return false;
        }

        saldo -= valor;
        return true;
    }

    public void transferir(Conta destino, double valor){
        if (valor > saldo || valor <= 0){
            System.out.println("Valor invalido, tente novamente");
            return;
        } else{
            this.sacar(valor);
            destino.depositar(valor);
            System.out.println("Transferencia feita com sucesso");
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
    
}