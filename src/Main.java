import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

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
                    scanner.nextLine();
                    String nome = scanner.nextLine();

                    System.out.print("Número da conta: ");
                    int numero = scanner.nextInt();

                    banco.criarConta(nome, numero);

                    break;

                case 2:

                    banco.listarContas();

                    break;

                case 3:

                    System.out.print("Conta: ");
                    int contaDep = scanner.nextInt();

                    Conta conta = banco.buscarConta(contaDep);

                    if (conta != null) {

                        System.out.print("Valor: ");
                        double valor = scanner.nextDouble();

                        conta.depositar(valor);

                    }

                    break;

                case 4:

                    System.out.print("Conta: ");
                    int contaSaque = scanner.nextInt();

                    Conta conta2 = banco.buscarConta(contaSaque);

                    if (conta2 != null) {

                        System.out.print("Valor: ");
                        double valor = scanner.nextDouble();

                        if (!conta2.sacar(valor)) {
                            System.out.println("Saldo insuficiente.");
                        }

                    }

                    break;

                case 5:

                    System.out.print("Conta origem: ");
                    int origem = scanner.nextInt();

                    System.out.print("Conta destino: ");
                    int destino = scanner.nextInt();

                    Conta c1 = banco.buscarConta(origem);
                    Conta c2 = banco.buscarConta(destino);

                    if (c1 != null && c2 != null) {

                        System.out.print("Valor: ");
                        double valor = scanner.nextDouble();

                        c1.transferir(c2, valor);

                    }

                    break;

            }

        } while (opcao != 0);

        scanner.close();
    }
}