package java10x.dev.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController // Fala pro java que isto é um controller.
@RequestMapping("/ninjas") // Para colocar todas as rotas no mesmo lugar.

public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja ( CREATE )
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    // Mostrar todos os ninjas ( READ )
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninja";
    }

    // Mostrar ninja por ID ( READ )
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar Ninja por ID";
    }

    // Alterar dados dos Ninjas ( UPDATE )
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por ID";
    }


    // Deletar Ninja ( DELETE )
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }



}