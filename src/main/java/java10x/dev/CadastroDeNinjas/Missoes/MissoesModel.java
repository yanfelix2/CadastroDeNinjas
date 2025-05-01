package java10x.dev.CadastroDeNinjas.Missoes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java10x.dev.CadastroDeNinjas.Ninjas.NinjaModel;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table (name = "tb_missoes")
//@Data // É usada para gerar os getters e os  setters.
//@NoArgsConstructor // Cria um contrutor sem argumentos
//@AllArgsConstructor // Cria um construtor om todos os argumentos

//Cada missao vai poder ter varios ninjas, mas cada ninja vai ter uma missao


public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID sequencialmente e automaticamente.
    private Long id;

    private String nome;
    private String dificuldade;

    public MissoesModel() {
    }

    public MissoesModel(Long id, String nome, String dificuldade, List<NinjaModel> ninjas) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.ninjas = ninjas;
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

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }

    // OneToMany Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;

    @Override
    public String toString() {
        return "MissoesModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dificuldade='" + dificuldade + '\'' +
                ", ninjasCount=" + (ninjas != null ? ninjas.size() : 0) +
                '}';
    }


}
