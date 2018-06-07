package app.dto;

import app.domain.Employee;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Builder
@Data
@Getter
@Setter
public class PositionDto {

    private Long id;

    private String name;

    private int numberOfemployees;




}
