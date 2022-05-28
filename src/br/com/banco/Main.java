package br.com.banco;



import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Banco banco = Banco.getInstance();
        Scanner teclado = new Scanner(System.in);

        //contas criadas para serem usadas nas opções de acesso direto as contas
        Conta contaCorrente = new ContaCorrente(new Cliente("Ariana", "313"));
        banco.cadastrarConta(contaCorrente);
        ContaPoupanca contaPoupanca = new ContaPoupanca(new Cliente("Rafael", "148"));
        banco.cadastrarConta(contaPoupanca);

        boolean naoSair= true;

        while (naoSair){

            System.out.println("Bem vindo ao Banco Digital DIO! Escolha a opção desejada");
            System.out.println("1- Cadastrar nova conta");
            System.out.println("2- Acessar conta");
            System.out.println("3- Sair");

            int opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    criarConta(banco,teclado);
                    break;

                case 2:
                    acessarConta(banco,teclado);
                    break;
                case 3:
                    naoSair=false;
                    break;
                default:
                    System.out.println("Opção Invalida");
            }
        }


    }

    private static void criarConta(Banco banco, Scanner teclado){

        System.out.println("Conta Corrente (1) ou Conta Poupança (2)");
        int tipoConta = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Informe o nome");
        String nome= teclado.nextLine();

        System.out.println("Informe o cpf");
        String cpf= teclado.nextLine();
        Cliente clienteNovo= new Cliente(nome, cpf);

        if (tipoConta == 1) {
            Conta contaCorrenteNova = new ContaCorrente(clienteNovo);
            System.out.println(contaCorrenteNova+ "cadastrada com sucesso!");
            banco.cadastrarConta(contaCorrenteNova);

        }else if (tipoConta == 2) {
            Conta contaPoupancaNova = new ContaPoupanca( clienteNovo);
            System.out.println(contaPoupancaNova+ "cadastrada com sucesso");
            banco.cadastrarConta(contaPoupancaNova);


        }else {
            System.out.println("Tipo de conta inválida");
        }
    }

    private static void acessarConta(Banco banco, Scanner teclado){

        System.out.println("Digite CPF");
        String cpf= teclado.next();
        Conta contaEncontrada= banco.encontrarConta(cpf);

        if(contaEncontrada==null){
            System.out.println("Conta não encontrada");
        }

        System.out.println("Qual operação deseja realizar? ");
        System.out.println("1- Imprimir Informações e Saldo");
        System.out.println("2- Realizar Deposito");
        System.out.println("3- Realizar Saque");
        System.out.println("4- Realizar Transferência");

        int opcao= teclado.nextInt();

        switch (opcao){
            case 1:
                contaEncontrada.imprimirInformacoes();
                break;
            case 2:
                System.out.println("Quanto deseja depositar");
                BigDecimal valor = teclado.nextBigDecimal();
                contaEncontrada.depositar(valor);
                break;
            case 3:
                System.out.println("Quanto deseja sacar");
                BigDecimal valor1 = teclado.nextBigDecimal();
                contaEncontrada.sacar(valor1);
                break;
            case 4:
                System.out.println("Quanto deseja tranferir");
                BigDecimal valor2 = teclado.nextBigDecimal();
                System.out.println("Informar CPF da conta de destino");
                String cpfDestino = teclado.next();
                Conta contaDestino= banco.encontrarConta(cpfDestino);
                contaEncontrada.transferir(valor2, contaDestino);
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }

}
