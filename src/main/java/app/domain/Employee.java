package app.domain;


import app.dto.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    @ManyToOne
    @JsonIgnore
    private Position position;

    public EmployeeDto toDto(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail(email);
        employeeDto.setName(name);
        employeeDto.setId(id);
        employeeDto.setSurname(surname);
        employeeDto.setPositionName(position.getName());
        return employeeDto;
    }


}
