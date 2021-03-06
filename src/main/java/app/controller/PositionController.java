package app.controller;

import app.domain.Position;
import app.dto.EmployeeDto;
import app.dto.PositionDto;
import app.repository.PositionRepository;
import app.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/position")
public class PositionController {

    private final PositionService positionService;


    public PositionController(PositionService positionService){
        this.positionService=positionService;
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PositionDto> getAllEmployees(){
        return positionService.getAllPositions();
    }
}
