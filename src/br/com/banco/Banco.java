package br.com.banco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter@Setter

/*
 * A classe Banco deve ser um Singleton (sera criada somente uma instancia de Banco)
 */
public class Banco {

    private final String nome= "Banco Digital Dio";
    private List <Conta> contas= new ArrayList<Conta>();
    private static Banco banco;
    /*
     * construtor privado para criação do Singleton
     */
    private Banco() {
    }
/*
 * metodo para criação de somente uma instancia de Banco
 */
    public static Banco getInstance() {
        if(banco == null) {
            banco = new Banco();
        }
        return banco;
    }
    public void cadastrarConta(Conta novaConta){
        contas.add(novaConta);
    }

    public void imprimirContas(List<Conta> contas){
        for (Conta conta:contas) System.out.println(conta);
    }

    public Conta encontrarConta(String cpf){
        for (Conta conta: contas) {
            if(conta.getCliente().getCpf().equals(cpf)) return conta;
        }
        return null;
    }



}
