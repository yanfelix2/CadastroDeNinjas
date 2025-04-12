package java10x.dev.CadastroDeNinjas.Missoes;
import jakarta.persistence.*;
import java10x.dev.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table (name = "tb_missoes")
@Data // É usada para gerar os getters e os  setters.
@NoArgsConstructor // Cria um contrutor sem argumentos
@AllArgsConstructor // Cria um construtor om todos os argumentos

//Cada missao vai poder ter varios ninjas, mas cada ninja vai ter uma missao


public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID sequencialmente e automaticamente.
    private Long id;

    private String nome;
    private String dificuldade;

    // OneToMany Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
