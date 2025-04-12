package java10x.dev.CadastroDeNinjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;
// JPA é uma abstração ( uma maneira de deixar mais facil o entendimento simplificando)  FACILITA PARA UTILIAR O BANCO DE DADOS.
// E irei conseguir usar os metodos do JPA.

public interface MissoesRepository extends JpaRepository <MissoesModel, Long> { // <Classe que é para o ORM escanear, TIPO DO ID>





}
