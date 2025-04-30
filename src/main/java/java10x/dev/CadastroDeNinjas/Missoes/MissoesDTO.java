package java10x.dev.CadastroDeNinjas.Missoes;

import java10x.dev.CadastroDeNinjas.Ninjas.NinjaDTO;

import java.util.List;

public class MissoesDTO {

    private Long id;

    private String nome;

    private String dificuldade;

    private List<NinjaDTO> ninjas;

    public MissoesDTO() {
    }

    public MissoesDTO(Long id, String nome, String dificuldade, List<NinjaDTO> ninjas) {
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

    public List<NinjaDTO> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaDTO> ninjas) {
        this.ninjas = ninjas;
    }
}
