# desafioDio-BancoDigital

Melhorias realizadas no código inicial:

-Classe Banco foi transformada em Singleton criando um atributo do tipo da própria classe, construtor privado e o método getInstance. 
-Método cadastrarConta (na classe Banco) para adicionar as contas no banco. 
-Método imprimirContas (na classe Banco)
-Método encontrarConta (na classe Banco) para encontrar a conta que se deseja realizar as operações (deposito, saque, transferência e impressão de informações)
-Usado BigDecimal por ser mais recomendado para trabalhar com valores monetários. 
-Criado construtores separados para ContaCorrente e ContaPoupanca para atribuir prefixos diferentes a elas. 
-Criado uma interface de texto com opções para cadastrar, acessar e realizar as operações. 
