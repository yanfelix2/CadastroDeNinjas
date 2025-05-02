package java10x.dev.CadastroDeNinjas.Missoes;

import java10x.dev.CadastroDeNinjas.Ninjas.NinjaDTO;
import java10x.dev.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());

        if (missoesModel.getNinjas() != null) {
            List<NinjaDTO> ninjaDTOs = missoesModel.getNinjas().stream()
                    .map(ninjaModel -> {
                        NinjaDTO dto = new NinjaDTO();
                        dto.setId(ninjaModel.getId());
                        dto.setNome(ninjaModel.getNome());
                        dto.setIdade(ninjaModel.getIdade());
                        dto.setEmail(ninjaModel.getEmail());
                        dto.setRank(ninjaModel.getRank());
                        dto.setImgUrl(ninjaModel.getImgUrl());
                        return dto;
                    })
                    .collect(Collectors.toList());
            missoesDTO.setNinjas(ninjaDTOs);
        }

        return missoesDTO;
    }
}
