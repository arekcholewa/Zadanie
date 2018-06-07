package app.domain;

import app.dto.PositionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    private String description;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees = new HashSet<>();

    public PositionDto toDto(){
        return PositionDto.builder()
                .id(id)
                .name(name)
                .numberOfemployees(employees.size())
                .build();
    }

}
