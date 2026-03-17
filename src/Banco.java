import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas = new ArrayList<>(); //contas é a lista da Classe Conta, e será armazenado aqui as contas existentes e criadas

    public void criarConta(String titular, int numero){

        Conta novaConta = new Conta(titular, numero); //novaConta é a variável para guardar as novas contas
        contas.add(novaConta); 
    }

    public Conta buscarConta(int numero){

        for (Conta c : contas){
            if (c.getNumero() == numero){
                return c;
            }
        }
        System.out.println("Conta não encontrada");
        return null;
    }

    public void listarContas(){

        for (Conta c: contas){  // fazendo uma função que busca a Conta pelo indice c na lista "contas"
            System.out.println(
                "Conta: " + c.getNumero() + // em java usamos '+' ao invés de ',' para imprimir String e variavel juntos
                " | Titular: " + c.getTitular() +
                " | Saldo: " + c.getSaldo()
            );
        }
    }
    
}
