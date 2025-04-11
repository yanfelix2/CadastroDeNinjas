package java10x.dev.CadastroDeNinjas;

import jakarta.persistence.*;

// JPA = Java Persistence API
@Entity // Entity Transforma uma classe em uma entidade do BD
@Table(name = "tb_cadastro") // Cria tabela

public class NinjaModel { // Transformei a classe em uma entidade do BD e criei a tabela.

    @Id // Fala que o atributo que está abaixo vai ser o ID
    @GeneratedValue (strategy = GenerationType.IDENTITY)  // Estrategia de como vai ser gerado o ID automaticamente
    private Long id;
    private String nome;
    private String email;
    private int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


}