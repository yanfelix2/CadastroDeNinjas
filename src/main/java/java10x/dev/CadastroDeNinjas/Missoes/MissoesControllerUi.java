package java10x.dev.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;



@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {
    private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
                return "listarMissoes"; // Tem que retornar o nome da página que renderiza


    }

    @GetMapping("/deletar/{id}")
    public String deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissoesPorId(id);
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarMissoesPorId(@PathVariable Long id, Model model){
        MissoesDTO missao = missoesService.listarMissoesPorId(id);
        if (missao != null){
            model.addAttribute("missao", missao);
            return "detalhesMissao";
        }else{
            model.addAttribute("mensagem", "Missão não encontrada");
            return "listarMissoes";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarMissao(Model model){
        model.addAttribute("missao", new MissoesDTO());
        return "adicionarMissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes){
        missoesService.criarMissao(missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missão cadastrada com sucesso!");
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String mostrarForumalarioEditarMissao(@PathVariable Long id, Model model){
        MissoesDTO missao = missoesService.listarMissoesPorId(id);
            if (missao != null){
                model.addAttribute("missao", missao);
                return "alterarMissao";
            }else{
                model.addAttribute("mensagem", "Missão não encontrada");
                return "redirect:/missoes/ui/listar";
            }
    }

    @PostMapping("/salvarMissaoAtualizada")
    public String salvarMissaoAtualizada(@ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes){
        missoesService.atualizarMissao(missao.getId(), missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missão atualizada com sucesso!");
        return "redirect:/missoes/ui/listar";
    }




}


