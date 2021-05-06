package loren.usmp.api_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import loren.usmp.api_crud.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}