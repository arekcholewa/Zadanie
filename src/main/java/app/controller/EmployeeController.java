package app.controller;
import app.dto.EmployeeDto;
import app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.addEmployee(employeeDto);
    }


    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping(value = "/delete")
    public void removeEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping(value = "/name")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> getEmployeesByName(@RequestParam String name){
        return employeeService.getEmployeeByName(name);
    }

    @GetMapping(value = "/surname")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> getEmployeesBySurname(@RequestParam String surname){
        return employeeService.getEmployeeBySurname(surname);
    }

    @GetMapping(value = "/email")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> getEmployeesByEmail(@RequestParam String email){
        return employeeService.getEmployeeByEmail(email);
    }

}
