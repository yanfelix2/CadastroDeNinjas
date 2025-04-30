package java10x.dev.CadastroDeNinjas.Missoes;

//LOCALHOST:8080/rota

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Anotação para controller
@RequestMapping("/missoes") // Mapear APIS

public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar uma missão
    @PostMapping("/criar")  // POST - Mandar uma requisicao para criar as missoes
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão Criada Com Sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }


    // Mostrar todas as missões
    @GetMapping("/listar") // GET - Mandar uma requisicao para mostrar as missoes
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    // Mostrar missão passando o ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id){
        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if (missao != null){
            return ResponseEntity.ok(missao);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // Alterar dados das missões passando o ID ( UPDATE )
    @PutMapping("/alterar/{id}") // PUT - Mandar uma requisicao para alterar as missoes
    public ResponseEntity<String> alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        MissoesDTO missao = missoesService.atualizarMissao(id,missaoAtualizada);
        if (missao != null){
            return ResponseEntity.ok("Missão com o ID: " + id + ", atualizada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe uma missão com esse ID: " + id);
        }
    }

    // Deletar missão passando o id ( DELETE )
    @DeleteMapping("/deletar/{id}") // DELETE - Mandar uma requisicao para deletar as missoes
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id, MissoesDTO nomeMissao){
        if (missoesService.listarMissoesPorId(id) != null){
            missoesService.deletarMissoesPorId(id);
            return ResponseEntity.ok("Missão com o ID: " + id + ", deletada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + ", não encontrada!");
        }
    }





}
