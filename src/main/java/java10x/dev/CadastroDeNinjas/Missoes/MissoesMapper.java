package java10x.dev.CadastroDeNinjas.Missoes;

import java10x.dev.CadastroDeNinjas.Ninjas.NinjaDTO;
import java10x.dev.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        // Aqui você pode depois adicionar a lógica de salvar os ninjas também, se precisar.

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());

        // Mapear também a lista de ninjas!
        if (missoesModel.getNinjas() != null) {
            List<NinjaDTO> ninjaDTOs = missoesModel.getNinjas().stream()
                    .map(ninja -> new NinjaDTO(ninja.getId(), ninja.getNome()))
                    .collect(Collectors.toList());
            missoesDTO.setNinjas(ninjaDTOs);
        }

        return missoesDTO;
    }
}
