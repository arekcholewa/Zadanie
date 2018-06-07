package app.repository;

import app.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

       @Transactional
       void removeById(Long id);

       List<Employee> findByName(String name);

       List<Employee> findBySurname(String surname);

       List<Employee> findByEmail(String email);

       boolean existsById(Long id);
}
