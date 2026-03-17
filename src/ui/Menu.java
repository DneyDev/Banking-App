package ui;

import java.util.Scanner;

import model.Conta;
import service.BancoService;

public class Menu {

    private Scanner scanner;
    private BancoService service;

    public Menu(BancoService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInt();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    listarContas();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    sacar();
                    break;
                case 5:
                    transferir();
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\n=== BANCO CLI ===");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Listar contas");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Transferir");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    // 🔥 evita bug de input
    private int lerInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Digite um número válido!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double lerDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Digite um valor válido!");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private void criarConta() {
        System.out.print("Nome do titular: ");
        scanner.nextLine(); // limpa buffer
        String nome = scanner.nextLine();

        System.out.print("Número da conta: ");
        int numero = lerInt();

        boolean criada = service.criarConta(nome, numero);

        if (criada) {
            System.out.println("✔ Conta criada!");
        } else {
            System.out.println("❌ Conta já existe!");
        }
    }

    private void listarContas() {
        System.out.println("\n=== CONTAS ===");

        for (Conta c : service.listarContas()) {
            System.out.println(
                "Conta: " + c.getNumero() +
                " | Titular: " + c.getTitular() +
                " | Saldo: " + c.getSaldo()
            );
        }
    }

    private void depositar() {
        System.out.print("Conta: ");
        int numero = lerInt();

        System.out.print("Valor: ");
        double valor = lerDouble();

        if (service.depositar(numero, valor)) {
            System.out.println("✔ Depósito realizado!");
        } else {
            System.out.println("❌ Erro no depósito!");
        }
    }

    private void sacar() {
        System.out.print("Conta: ");
        int numero = lerInt();

        System.out.print("Valor: ");
        double valor = lerDouble();

        if (service.sacar(numero, valor)) {
            System.out.println("✔ Saque realizado!");
        } else {
            System.out.println("❌ Erro no saque!");
        }
    }

    private void transferir() {
        System.out.print("Conta origem: ");
        int origem = lerInt();

        System.out.print("Conta destino: ");
        int destino = lerInt();

        System.out.print("Valor: ");
        double valor = lerDouble();

        if (service.transferir(origem, destino, valor)) {
            System.out.println("✔ Transferência realizada!");
        } else {
            System.out.println("❌ Erro na transferência!");
        }
    }
}