package java10x.dev.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.IllegalFormatCodePointException;
import java.util.List;

@RestController // Fala pro java que isto é um controller.
@RequestMapping("/ninjas") // Para colocar todas as rotas no mesmo lugar.

public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja ( CREATE )
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado Com Sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // Mostrar todos os ninjas ( READ )
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);

    }

    // Mostrar ninja por ID ( READ )
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // Alterar dados dos Ninjas ( UPDATE )
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninja = ninjaService.atualizarNinja(id,ninjaAtualizado);

        if (ninja != null){
            return ResponseEntity.ok("Ninja com o ID: " + id + ", atualizado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe um ninja com esse ID: " + id);
        }

    }


    // Deletar Ninja ( DELETE )
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

       if (ninjaService.listarNinjasPorId(id) != null) {
           ninjaService.deletarNinjaPorId(id);
           return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso!");
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("O ninja com o ID: " + id + " não encontrado!");
       }

    }





}