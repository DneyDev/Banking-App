import java.util.Scanner;

import model.Conta;
import repository.ContaRepository;
import service.BancoService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 🔗 ligando as camadas
        ContaRepository repository = new ContaRepository();
        BancoService service = new BancoService(repository);

        int opcao;

        do {

            System.out.println("\n=== BANCO CLI ===");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("Nome do titular: ");
                    scanner.nextLine(); // limpa buffer ao clicar enter
                    String nome = scanner.nextLine();

                    System.out.print("Número da conta: ");
                    int numero = scanner.nextInt();

                    boolean criada = service.criarConta(nome, numero);

                    if (criada) {
                        System.out.println("✔ Conta criada com sucesso!");
                    } else {
                        System.out.println("❌ Conta já existe!");
                    }
                    break;

                case 2:
                    for (Conta c : repository.listarContas()) {
                        System.out.println(
                            "Conta: " + c.getNumero() +
                            " | Titular: " + c.getTitular() +
                            " | Saldo: " + c.getSaldo()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Conta: ");
                    int contaDep = scanner.nextInt();

                    System.out.print("Valor: ");
                    double valorDep = scanner.nextDouble();

                    boolean deposito = service.depositar(contaDep, valorDep);

                    if (deposito) {
                        System.out.println("✔ Depósito realizado!");
                    } else {
                        System.out.println("❌ Erro no depósito!");
                    }
                    break;

                case 4:
                    System.out.print("Conta: ");
                    int contaSaque = scanner.nextInt();

                    System.out.print("Valor: ");
                    double valorSaque = scanner.nextDouble();

                    boolean saque = service.sacar(contaSaque, valorSaque);

                    if (saque) {
                        System.out.println("✔ Saque realizado!");
                    } else {
                        System.out.println("❌ Saldo insuficiente ou conta inválida!");
                    }
                    break;

                case 5:
                    System.out.print("Conta origem: ");
                    int origem = scanner.nextInt();

                    System.out.print("Conta destino: ");
                    int destino = scanner.nextInt();

                    System.out.print("Valor: ");
                    double valorTransf = scanner.nextDouble();

                    boolean transferencia = service.transferir(origem, destino, valorTransf);

                    if (transferencia) {
                        System.out.println("✔ Transferência realizada!");
                    } else {
                        System.out.println("❌ Erro na transferência!");
                    }
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}