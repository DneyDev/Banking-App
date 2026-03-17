package repository;

import java.util.ArrayList;
import model.Conta;

public class ContaRepository {
    
    private ArrayList<Conta> contas = new ArrayList<>(); //contas é a lista da Classe Conta, e será armazenado aqui as contas existentes e criadas

    public void salvarConta(Conta conta){
        contas.add(conta); 
    }

    public Conta buscarConta(int numero){

        for (Conta c : contas){
            if (c.getNumero() == numero){
                return c;
            }
        }
        return null;
    }

    public ArrayList<Conta> listarContas(){
        return contas;
    }
}
