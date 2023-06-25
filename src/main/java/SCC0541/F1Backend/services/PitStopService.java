package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.PitStopDTO;
import SCC0541.F1Backend.dtos.PitStopDTO;
import SCC0541.F1Backend.models.PitStopModel;
import SCC0541.F1Backend.models.primary_keys.PitStopPK;
import SCC0541.F1Backend.repositories.PitStopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PitStopService {

    @Autowired
    private PitStopRepository pitStopRepository;

    public List<PitStopDTO> getAllPitStops() {
        return pitStopRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }


    private PitStopDTO convertToDTO(PitStopModel pitStopModel) {
        PitStopDTO pitStopDTO = new PitStopDTO();

        // Converter os atributos do PitStopPK
        PitStopPK pitStopPK = pitStopModel.getPitStopPK();
        pitStopDTO.setRaceId(pitStopPK.getRaceId());
        pitStopDTO.setDriverId(pitStopPK.getDriverId());
        pitStopDTO.setStop(pitStopPK.getStop());

        // Converter os demais atributos
        pitStopDTO.setLap(pitStopModel.getLap());
        pitStopDTO.setTime(pitStopModel.getTime());
        pitStopDTO.setDuration(pitStopModel.getDuration());
        pitStopDTO.setMilliseconds(pitStopModel.getMilisseconds());

        return pitStopDTO;
    }
}
