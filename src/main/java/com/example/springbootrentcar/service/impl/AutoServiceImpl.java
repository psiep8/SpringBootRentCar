package com.example.springbootrentcar.service.impl;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.exception.ResourceNotFoundException;
import com.example.springbootrentcar.mapper.AutoMapper;
import com.example.springbootrentcar.repository.AutoRepository;
import com.example.springbootrentcar.repository.PrenotazioneRepository;
import com.example.springbootrentcar.service.AutoService;
//import com.example.springbootrentcar.specifications.DateSpecifications;
import com.example.springbootrentcar.specifications.DateSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.springbootrentcar.mapper.UtenteMapper.settersDTOtoEntity;

@Service
@Transactional
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {
    private final AutoRepository autoRepository;
    private final PrenotazioneRepository prenotazioneRepository;
    private final AutoMapper mapper;

    @Transactional
    @Override
    public void updateAuto(AutoDTO autoDTO) {
        if (autoDTO.getId() != 0) {
            Auto auto = autoRepository.findById(autoDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Utente non esiste con id:" + autoDTO.getId()));
            auto.setMarca(autoDTO.getMarca());
            auto.setModello(autoDTO.getModello());
            auto.setCilindrata(autoDTO.getCilindrata());
            autoRepository.save(auto);
        } else {
            autoRepository.save(mapper.fromDTOtoEntity(autoDTO));
        }
    }

    @Transactional
    @Override
    public void deleteAuto(AutoDTO autoDTO) {
        autoRepository.delete(mapper.fromDTOtoEntity(autoDTO));
    }

    @Override
    public List<AutoDTO> getAutoList() {
        List<Auto> autos = autoRepository.findAll();
        return mapper.getAllAutoDTO(autos);
    }

    @Override
    public AutoDTO getAuto(int id) {
        return mapper.fromEntityToDTO(autoRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Prenotazione non esiste con id:" + id))));
    }

    @Override
    public List<AutoDTO> getDataRange(LocalDate inizio, LocalDate fine) {
        List<Prenotazione> listPrenotazioniInRange = prenotazioneRepository.findAll(DateSpecifications.getRangeData(inizio, fine));
        List<Integer> autoList = new ArrayList<>();
        if (listPrenotazioniInRange.isEmpty()) {
            return getAutoList();
        } else {
            for (Prenotazione p : listPrenotazioniInRange) {
                int id = p.getAuto().getIdAuto();
                autoList.add(id);
            }
            List<Auto> list = autoRepository.findAll(DateSpecifications.getAutoNotInRange(autoList));
            return mapper.getAllAutoDTO(list);
        }
    }
}
