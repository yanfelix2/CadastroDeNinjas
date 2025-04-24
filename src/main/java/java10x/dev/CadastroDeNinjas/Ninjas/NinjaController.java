package java10x.dev.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas ( READ )
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID ( READ )
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    // Alterar dados dos Ninjas ( UPDATE )
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por ID";
    }


    // Deletar Ninja ( DELETE )
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }



}