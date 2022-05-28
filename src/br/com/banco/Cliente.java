package br.com.banco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter@Getter
@AllArgsConstructor


public class Cliente {

    private String nome;
    private String  cpf;

    @Override
    public String toString() {
        return "" + nome + '\'' +
                ", cpf='" + cpf + '\''
                ;
    }
}
