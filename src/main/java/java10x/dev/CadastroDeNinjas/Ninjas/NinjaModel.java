package java10x.dev.CadastroDeNinjas.Ninjas;

import jakarta.persistence.*;
import java10x.dev.CadastroDeNinjas.Missoes.MissoesModel;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import java.util.List;

// JPA = Java Persistence API
@Entity // Entity Transforma uma classe em uma entidade do BD
@Table(name = "tb_cadastro") // Cria tabela
//@Data // Cria automaticamente os getters e os setters ( LOMBOK )
//@NoArgsConstructor // Cria um construtor vazio ( LOMBOK )
//@AllArgsConstructor // Cria o construtor com todos atributos  e Sempre que eu adicionar algo ele ja atualiza automaticamente. ( LOMBOK )



public class NinjaModel { // Transformei a classe em uma entidade do BD e criei a tabela.

    @Id // Fala que o atributo que está abaixo vai ser o ID
    @GeneratedValue (strategy = GenerationType.IDENTITY)  // Estrategia de como vai ser gerado o ID automaticamente
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true) // Diz que o email é unico ( usado em cpf, rg, numero de passaporte. )
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;


    public NinjaModel() {
    }

    public NinjaModel(Long id, String nome, String email, String imgUrl, int idade, MissoesModel missoes, String rank) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.imgUrl = imgUrl;
        this.idade = idade;
        this.missoes = missoes;
        this.rank = rank;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public MissoesModel getMissoes() {
        return missoes;
    }

    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }

    public String getRank(){
        return rank;
    }

    public void setRank(String rank){
        this.rank = rank;
    }

    // @ManyToOne - Um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")  // Foreing Key ou Chave Estrangeira
    private MissoesModel missoes;

    @Override
    public String toString() {
        return "NinjaModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", idade=" + idade +
                ", rank='" + rank + '\'' +
                ", missoesNome='" + (missoes != null ? missoes.getNome() : null) + '\'' +
                '}';
    }


}