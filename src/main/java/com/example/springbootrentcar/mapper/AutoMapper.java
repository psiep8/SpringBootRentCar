package com.example.springbootrentcar.mapper;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Utente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class AutoMapper {

    public List<AutoDTO> getAllAutoDTO(List<Auto> autos) {
        return autos.stream().map(this::fromEntityToDTO).collect(Collectors.toList());
    }

    public Auto fromDTOtoEntity(AutoDTO autoDTO) {
        Auto auto = new Auto();
        auto.setMarca(autoDTO.getMarca());
        auto.setModello(autoDTO.getModello());
        auto.setCilindrata(autoDTO.getCilindrata());
        return auto;
    }

    public AutoDTO fromEntityToDTO(Auto auto) {
        AutoDTO autoDTO = new AutoDTO();
        autoDTO.setId(auto.getIdAuto());
        autoDTO.setMarca(auto.getMarca());
        autoDTO.setModello(auto.getModello());
        autoDTO.setCilindrata(auto.getCilindrata());
        return autoDTO;
    }
}
