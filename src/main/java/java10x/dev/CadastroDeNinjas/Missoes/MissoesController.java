package java10x.dev.CadastroDeNinjas.Missoes;

//LOCALHOST:8080/rota

import org.springframework.web.bind.annotation.*;

@RestController // Anotação para controller
@RequestMapping("missoes") // Mapear APIS

public class MissoesController {

    @GetMapping("/listar") // GET - Mandar uma requisicao para mostrar as missoes
    public String listarMissao(){
        return "Missoes listadas com sucesso";
    }

    @PostMapping("/criar")  // POST - Mandar uma requisicao para criar as missoes
    public String criarMissao(){
        return "Missao criada com sucesso";
    }

    @PutMapping("/alterar") // PUT - Mandar uma requisicao para alterar as missoes
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }

    @DeleteMapping("/deletar") // DELETE - Mandar uma requisicao para deletar as missoes
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }





}
