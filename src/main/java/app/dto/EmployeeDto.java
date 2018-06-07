package app.dto;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;


@Getter
@Setter
@Data
@NoArgsConstructor
public class EmployeeDto{


    private Long id;

    private String name;

    private String surname;

    private String email;

    private String positionName;


}
