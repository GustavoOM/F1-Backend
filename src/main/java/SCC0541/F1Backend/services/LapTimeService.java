package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.CircuitDTO;
import SCC0541.F1Backend.dtos.LapTimeDTO;
import SCC0541.F1Backend.models.LapTimeModel;
import SCC0541.F1Backend.models.primary_keys.LapTimePK;
import SCC0541.F1Backend.repositories.CircuitRepository;
import SCC0541.F1Backend.repositories.LapTimeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LapTimeService {

    @Autowired
    private LapTimeRepository lapTimeRepository;

    public List<LapTimeDTO> list() {
        return lapTimeRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    private LapTimeDTO convertToDTO(LapTimeModel lapTimeModel) {
        LapTimeDTO lapTimeDTO = new LapTimeDTO();

        // Converter os atributos do LapTimePK
        LapTimePK lapTimePK = lapTimeModel.getLapTimePK();
        lapTimeDTO.setRaceId(lapTimePK.getRaceId());
        lapTimeDTO.setDriverId(lapTimePK.getDriverId());
        lapTimeDTO.setLap(lapTimePK.getLap());

        // Converter os demais atributos
        lapTimeDTO.setPosition(lapTimeModel.getPosition());
        lapTimeDTO.setTime(lapTimeModel.getTime());
        lapTimeDTO.setMilliseconds(lapTimeModel.getMilisseconds());

        return lapTimeDTO;
    }



}
