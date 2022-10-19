package com.example.springbootrentcar.mapper;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Utente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AutoMapper {
    private final ModelMapper mapper;

    public List<AutoDTO> getAllAutoDTO(List<Auto> autos) {
        return autos.stream().map(auto -> mapper.map(auto, AutoDTO.class)).collect(Collectors.toList());
    }

    public Auto fromDTOtoEntity(AutoDTO autoDTO) {
        return mapper.map(autoDTO, Auto.class);
    }

    public AutoDTO fromEntityToDTO(Auto auto) {
        return mapper.map(auto, AutoDTO.class);
    }
}
