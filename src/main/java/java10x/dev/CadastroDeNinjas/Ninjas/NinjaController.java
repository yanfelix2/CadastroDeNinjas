package java10x.dev.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.IllegalFormatCodePointException;
import java.util.List;

@RestController // Fala pro java que isto é um controller.
@RequestMapping("/ninjas") // Para colocar todas as rotas no mesmo lugar.

public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }


    // Adicionar Ninja ( CREATE )
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })


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
    @Operation(summary = "Lista o ninja por ID", description = "Rota lista um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
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
    @Operation(summary = "Altera o ninja por ID", description = "Rota altera um ninja por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja não encontrado, não foi possivel alterar")
    })
    public ResponseEntity<String> alterarNinjaPorId(
            @Parameter(description = "Usuario manda o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado) {

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