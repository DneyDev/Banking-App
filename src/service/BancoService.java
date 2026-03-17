package service;

import model.Conta;
import repository.ContaRepository;

public class BancoService {

    private ContaRepository repository; //ligação dizendo que depende do Repository

    public BancoService(ContaRepository repository){
        this.repository = repository;
    }

    public boolean criarConta(String titular, int numero) {
        
       Conta conta = repository.buscarConta(numero);

        if (conta != null) {
        return false;
        }
        else{Conta novaConta = new Conta(titular, numero);
        repository.salvarConta(novaConta);
        return true;
        }
    }
    //criando o método publico para realizar deposito
    public boolean depositar(int numero, double valor){ 

        Conta conta = repository.buscarConta(numero);

        if (conta == null || valor <= 0) {
            return false;
        }
        conta.depositar(valor);
        return true;

    }
    public boolean sacar(int numero, double valor){
        
        Conta conta = repository.buscarConta(numero);

        if (conta == null || valor <= 0){
            return false;
        }
        else{
           return conta.sacar(valor); //assim Service decide se saca ou não, caso seja true
        }
    }
    public boolean transferir(int origem, int destino, double valor){

        Conta contaOrigem = repository.buscarConta(origem);
        Conta contaDestino = repository.buscarConta(destino);

        if(contaOrigem == null || contaDestino == null || valor <= 0){
            return false;
        }
        boolean saqueOk = sacar(origem, valor);
        if(!saqueOk){
            return false;
        }
        depositar(destino, valor);
        return true;
    }
}
