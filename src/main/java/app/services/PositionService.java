package app.services;

import app.domain.Position;
import app.dto.PositionDto;
import app.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository){
        this.positionRepository=positionRepository;
    }

    public List<PositionDto> getAllPositions(){
        return StreamSupport.
                stream(positionRepository.findAll().spliterator(), true)
                .map(Position::toDto)
                .collect(Collectors.toList());
    }
}
