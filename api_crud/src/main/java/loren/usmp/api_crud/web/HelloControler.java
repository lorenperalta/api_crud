package loren.usmp.api_crud.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import loren.usmp.api_crud.domain.Employee;


@RestController
public class HelloControler {
    
    @RequestMapping("/")
    public String Index(){
        return "Aloja";
    }

    @RequestMapping("/empleaos")
    public List<Employee> index(){
        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee("juan", "peres"));
        employee.add(new Employee("juana", "peresosa"));
        return employee;
    }

}
