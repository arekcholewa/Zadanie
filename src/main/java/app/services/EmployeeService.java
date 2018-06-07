package app.services;

import app.domain.Employee;
import app.domain.Position;
import app.dto.EmployeeDto;
import app.exceptions.PositionNotExistException;
import app.exceptions.UserNotExistException;
import app.repository.EmployeeRepository;
import app.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, PositionRepository positionRepository){
        this.employeeRepository=employeeRepository;
        this.positionRepository=positionRepository;
    }

    public void addEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();

        Optional<Position> position= positionRepository.findByName(employeeDto.getPositionName());
        if(!position.isPresent()){
            throw new PositionNotExistException("Nie można dodać pracownika. Podane stanowisko nie istnieje");
        }else{

        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setEmail(employeeDto.getEmail());
        employee.setPosition(position.get());

        employeeRepository.save(employee);
        }
    }

    public void deleteEmployee(Long id){
        if(employeeRepository.existsById(id)){
            employeeRepository.removeById(id);
        }else {
            throw new UserNotExistException("Nie można usunąć. Pracownik o podanym id nie istnieje");
        }
    }

    public List<EmployeeDto> getAllEmployees(){

        return StreamSupport.
                stream(employeeRepository.findAll().spliterator(), true)
                .map(Employee::toDto)
                .collect(Collectors.toList());
    }
    
    public List<EmployeeDto> getEmployeeByName(String name){
        return StreamSupport.
                stream(employeeRepository.findByName(name).spliterator(), true)
                .map(Employee::toDto)
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> getEmployeeBySurname(String surname){
        return StreamSupport.
                stream(employeeRepository.findBySurname(surname).spliterator(), true)
                .map(Employee::toDto)
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> getEmployeeByEmail(String email){
        return StreamSupport.
                stream(employeeRepository.findByEmail(email).spliterator(), true)
                .map(Employee::toDto)
                .collect(Collectors.toList());
    }
}
